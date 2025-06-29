package net.NewAge.addon.abilities.hierework;

import java.util.*;

import net.NewAge.addon.init.ModResources;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.Ability;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityDescriptionLine;
import xyz.pixelatedw.mineminenomi.api.abilities.IAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.components.*;
import xyz.pixelatedw.mineminenomi.api.abilities.components.RangeComponent.RangeType;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceElement;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.api.protection.BlockProtectionRule;
import xyz.pixelatedw.mineminenomi.api.protection.DefaultProtectionRules;
import xyz.pixelatedw.mineminenomi.data.entity.entitystats.EntityStatsCapability;
import xyz.pixelatedw.mineminenomi.data.entity.entitystats.IEntityStats;
import xyz.pixelatedw.mineminenomi.init.ModEffects;
import xyz.pixelatedw.mineminenomi.init.ModParticleEffects;
import xyz.pixelatedw.mineminenomi.init.ModSounds;
import xyz.pixelatedw.mineminenomi.wypi.BlockPlacingHelper;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;

public class ReworkedIceAgeAbility extends Ability {
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("mineminenomi", "ice_age", new Pair[]{ImmutablePair.of("Freezes a large area around the user and everyone inside of it", (Object)null)});
    private static final int CHARGE_TIME = 100;
    private static final int MIN_COOLDOWN = 200;
    private static final int MAX_COOLDOWN = 300;
    private static final int ICE_RANGE = 64;
    private static final float ENTITY_FREEZE_RANGE = 2F;
    public static final AbilityCore<ReworkedIceAgeAbility> INSTANCE = (new AbilityCore.Builder("Ice Age Reworked", AbilityCategory.DEVIL_FRUITS, ReworkedIceAgeAbility::new)).addDescriptionLine(DESCRIPTION).addAdvancedDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE, CooldownComponent.getTooltip(200.0F, 300.0F), ChargeComponent.getTooltip(100.0F), RangeComponent.getTooltip(64.0F, RangeType.AOE)}).setSourceElement(SourceElement.ICE).build();
    private static final BlockProtectionRule PROTECTION_RULE = (new BlockProtectionRule.Builder(new BlockProtectionRule[]{DefaultProtectionRules.CORE_FOLIAGE_ORE_LIQUID})).addReplaceRules((world, pos, state) -> {
        if (state.getBlock().equals(Blocks.SNOW) && (Integer)state.getValue(SnowBlock.LAYERS) > 5) {
            world.setBlock(pos, Blocks.BLUE_ICE.defaultBlockState(), 3);
            return true;
        } else {
            return false;
        }
    }).build();
    private final BlockPlacingHelper blockPlacingHelper = new BlockPlacingHelper();
    private final List<Pair<BlockPos, BlockState>> frozenBlocks = new ArrayList<>();
    private final ChargeComponent chargeComponent = (new ChargeComponent(this, (comp) -> (double)comp.getChargePercentage() > (double)0.5F)).addStartEvent(100, this::startChargeEvent).addTickEvent(100, this::duringChargeEvent).addEndEvent(100, this::stopChargeEvent);
    private final RangeComponent rangeComponent = new RangeComponent(this);
    private final HitTrackerComponent hitTrackerComponent = new HitTrackerComponent(this);
    private final AltModeComponent<Mode> altModeComponent;
    private final List<Pair<BlockPos, BlockState>> revertQueue = new ArrayList<>();
    private final ContinuousComponent revertContinuousComponent = new ContinuousComponent(this, true)
            .addTickEvent(this::onRevertTick)
            .addEndEvent(this::onRevertEnd);



    public ReworkedIceAgeAbility(AbilityCore<ReworkedIceAgeAbility> core) {
        super(core);
        this.isNew = true;
        this.addComponents(new AbilityComponent[]{this.chargeComponent, this.rangeComponent, this.hitTrackerComponent});
        this.addUseEvent(this::onUseEvent);
        this.altModeComponent = new AltModeComponent<>(this, Mode.class, Mode.ICE_AGE)
                .addChangeModeEvent(this::onAltModeChange);

        this.addComponents(new AbilityComponent[]{
                this.chargeComponent,
                this.rangeComponent,
                this.hitTrackerComponent,
                this.altModeComponent,
                this.revertContinuousComponent
        });
        // Force icon and name to appear based on starting mode
        this.onAltModeChange(null, null, this.altModeComponent.getCurrentMode());
    }
        private void onUseEvent(LivingEntity entity, IAbility ability) {
            if (this.altModeComponent.getCurrentMode() == Mode.ICE_AGE) {
                this.chargeComponent.startCharging(entity, CHARGE_TIME);
            } else if (this.altModeComponent.getCurrentMode() == Mode.REVERT_ICE) {
                if (!frozenBlocks.isEmpty()) {
                    WyHelper.spawnParticleEffect(
                            ModParticleEffects.ICE_AGE.get(),
                            entity,
                            entity.getX(),
                            entity.getY(),
                            entity.getZ()
                    );

                    this.revertQueue.clear();
                    List<Pair<BlockPos, BlockState>> reversed = new ArrayList<>(this.frozenBlocks);
                    Collections.reverse(reversed);
                    this.revertQueue.addAll(reversed);
                    this.revertContinuousComponent.startContinuity(entity, -1); // run until queue empty
                    this.cooldownComponent.startCooldown(entity, 400); // 10 seconds
                } else {
                    entity.sendMessage(new StringTextComponent("No ice to revert!"), entity.getUUID());
                }
            }


        }

    private void startChargeEvent(LivingEntity entity, IAbility ability) {
        if (!entity.level.isClientSide) {
            this.hitTrackerComponent.clearHits();
            this.blockPlacingHelper.clearList();
            this.frozenBlocks.clear();

            double radiusXZ = ICE_RANGE;
            double radiusY = 9.0F;

            entity.level.playSound(null, entity.blockPosition(), ModSounds.ICE_AGE_SFX.get(), SoundCategory.PLAYERS, 10.0F, 1.0F);
            WyHelper.spawnParticleEffect(ModParticleEffects.ICE_AGE.get(), entity, entity.getX(), entity.getY(), entity.getZ());

            BlockPos.Mutable mutpos = new BlockPos.Mutable();

            for (double y = -radiusY; y < radiusY; ++y) {
                for (double x = -radiusXZ; x < radiusXZ; ++x) {
                    for (double z = -radiusXZ; z < radiusXZ; ++z) {
                        double posX = entity.getX() + x + (Math.abs(x) > WyHelper.randomWithRange((int)(radiusXZ * 0.5F), (int)(radiusXZ * 0.75F)) ? WyHelper.randomWithRange(-5, 5) : 0);
                        double posY = entity.getY() + y;
                        double posZ = entity.getZ() + z + (Math.abs(z) > WyHelper.randomWithRange((int)(radiusXZ * 0.5F), (int)(radiusXZ * 0.75F)) ? WyHelper.randomWithRange(-5, 5) : 0);

                        if (AbilityHelper.canPlaceBlock(entity.level, posX, posY, posZ, Blocks.BLUE_ICE.defaultBlockState(), 3, PROTECTION_RULE)) {
                            mutpos.set(posX, posY, posZ);
                            this.blockPlacingHelper.addBlockPos(mutpos, (int)(x * x + y * y + z * z));
                        }
                    }
                }
            }
            for (BlockPos blockPos : this.blockPlacingHelper.getBlockList()) {
                BlockState original = entity.level.getBlockState(blockPos);
                this.frozenBlocks.add(Pair.of(blockPos.immutable(), original));
            }


        }
    }
    private void revertFrozenBlocks(LivingEntity entity) {
        for (Pair<BlockPos, BlockState> pair : frozenBlocks) {
            BlockPos pos = pair.getLeft();
            BlockState original = pair.getRight();
            AbilityHelper.placeBlockIfAllowed(entity, pos, original, 3, PROTECTION_RULE);
        }

        frozenBlocks.clear(); // Only clear after reverting
    }

    private void duringChargeEvent(LivingEntity entity, IAbility ability) {
        entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 2, false, false));
        Set<BlockPos> blockList = this.blockPlacingHelper.getBlockList();
        int finished = blockList.size() / 100;
        Iterator<BlockPos> iterator = blockList.iterator();

        while(iterator.hasNext()) {
            BlockPos blockPos = (BlockPos)iterator.next();
            if (finished-- < 0) {
                break;
            }
            BlockState original = entity.level.getBlockState(blockPos);
            AbilityHelper.placeBlockIfAllowed(entity, blockPos, Blocks.BLUE_ICE.defaultBlockState(), 3, PROTECTION_RULE);

            for(LivingEntity target : this.rangeComponent.getTargetsInArea(entity, blockPos,ENTITY_FREEZE_RANGE)) {
                if (this.hitTrackerComponent.canHit(target)) {
                    IEntityStats userStats = EntityStatsCapability.get(entity);
                    IEntityStats targetStats = EntityStatsCapability.get(target);

                    int userDoriki = (int) userStats.getDoriki();
                    int targetDoriki = (int) targetStats.getDoriki();

                    int freezeDuration = targetDoriki < userDoriki / 2 ? 1200 : 140; // 60s or 7s

                    EffectInstance instance = new EffectInstance(ModEffects.FROZEN.get(), freezeDuration, 0);
                    target.addEffect(instance);

                }
            }

            iterator.remove();
        }

    }

    private void stopChargeEvent(LivingEntity entity, IAbility ability) {
        this.cooldownComponent.startCooldown(entity, MIN_COOLDOWN + this.chargeComponent.getChargeTime());
    }
    private void onAltModeChange(LivingEntity entity, IAbility ability, Mode mode) {
        if (mode == Mode.ICE_AGE) {
            this.setDisplayName(new StringTextComponent("Ice Age"));
            this.setDisplayIcon(ModResources.ICON_ICE_AGE);
        } else if (mode == Mode.REVERT_ICE) {
            this.setDisplayName(new StringTextComponent("Revert Ice"));
            this.setDisplayIcon(ModResources.ICON_REVERT_ICE);
        }
    }
    private void onRevertTick(LivingEntity entity, IAbility ability) {
        if (revertQueue.isEmpty() || entity.level == null || entity.level.isClientSide) {
            this.revertContinuousComponent.stopContinuity(entity); // ✅ stop it manually
            return;
        }
        entity.setDeltaMovement(0, 0, 0);
        entity.addEffect(new EffectInstance((Effect)ModEffects.MOVEMENT_BLOCKED.get(), 2, 1, false, false));
        int amount = Math.min(300, revertQueue.size());
        Iterator<Pair<BlockPos, BlockState>> iterator = revertQueue.iterator();

        while (amount-- > 0 && iterator.hasNext()) {
            Pair<BlockPos, BlockState> pair = iterator.next();
            BlockPos pos = pair.getLeft();
            BlockState original = pair.getRight();

            AbilityHelper.placeBlockIfAllowed(entity, pos, original, 3, PROTECTION_RULE);
            iterator.remove();
        }
    }
    private void onRevertEnd(LivingEntity entity, IAbility ability) {
        this.frozenBlocks.clear();
        this.revertQueue.clear();

        // ❌ DO NOT call stopContinuity here — it's already called internally!!
    }
    public static enum Mode {
        ICE_AGE,
        REVERT_ICE;
    }
}