package net.NewAge.addon.abilities.hierework;

import net.NewAge.addon.init.ModParticleEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.*;
import xyz.pixelatedw.mineminenomi.api.abilities.components.*;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.api.util.Interval;
import xyz.pixelatedw.mineminenomi.init.ModEffects;
import xyz.pixelatedw.mineminenomi.particles.effects.ParticleEffect;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;

import java.util.List;

public class FreezingDashAbility extends Ability
{
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("gopaddon", "freezing_dash", new Pair[]{
            ImmutablePair.of("Dashes forward freezing enemies hit and dealing damage.", null)
    });

    private static final float DAMAGE = 40.0F;
    private static final float RANGE = 1.4F;
    private static final int DURATION = 120; // 6 seconds
    private static final float DASH_TICKS = 20.0F;
    private static final float CHARGE_TIME = 20.0F; // 2 seconds

    public static final AbilityCore<FreezingDashAbility> INSTANCE;

    private final ChargeComponent chargeComponent = new ChargeComponent(this)
            .addEndEvent(this::onChargeEnd);

    private final ContinuousComponent continuousComponent = new ContinuousComponent(this, true)
            .addStartEvent(this::onContinuityStart)
            .addTickEvent(this::onContinuityTick)
            .addEndEvent(this::onContinuityEnd);

    private final RangeComponent rangeComponent = new RangeComponent(this);
    private final DealDamageComponent dealDamageComponent = new DealDamageComponent(this);
    private final HitTrackerComponent hitTrackerComponent = new HitTrackerComponent(this);
    private final ChangeStatsComponent changeStatsComponent = new ChangeStatsComponent(this);
    private final Interval particleInterval = new Interval(2);

    private Vector3d lastDashPos = null;

    public FreezingDashAbility(AbilityCore<FreezingDashAbility> core)
    {
        super(core);
        this.isNew = true;
        this.addComponents(changeStatsComponent, chargeComponent, continuousComponent, rangeComponent, dealDamageComponent, hitTrackerComponent);
        this.addCanUseCheck(AbilityHelper::canUseMomentumAbilities);
        this.addUseEvent(this::useEvent);
    }

    private void useEvent(LivingEntity entity, IAbility ability)
    {
        if (!chargeComponent.isCharging())
        {
            chargeComponent.startCharging(entity, CHARGE_TIME);
        }
    }

    private void onChargeEnd(LivingEntity entity, IAbility ability)
    {
        continuousComponent.triggerContinuity(entity, DASH_TICKS);
    }

    private void onContinuityStart(LivingEntity entity, IAbility ability)
    {
        hitTrackerComponent.clearHits();
        particleInterval.restartIntervalToZero();
        lastDashPos = entity.position();
    }

    private void onContinuityTick(LivingEntity entity, IAbility ability)
    {
        if (!entity.isAlive())
            return;

        Vector3d look = entity.getLookAngle();
        Vector3d speed = look.multiply(1.5, 0.0, 1.5);
        entity.move(net.minecraft.entity.MoverType.SELF, speed);

        // Spawn particles
        if (particleInterval.canTick())
        {
            WyHelper.spawnParticleEffect((ParticleEffect) ModParticleEffects.FREEZING_DASH.get(), entity, entity.getX(), entity.getY(), entity.getZ());
        }

        // Leave trail of ice (3-wide)
        Vector3d currPos = entity.position();
        if (lastDashPos == null)
            lastDashPos = currPos;

        Vector3d delta = currPos.subtract(lastDashPos);
        Vector3d step = delta.normalize().scale(0.3);
        Vector3d side = delta.cross(new Vector3d(0, 1, 0)).normalize();
        int steps = (int)(delta.length() / 0.3);

        for (int i = 0; i <= steps; i++)
        {
            Vector3d stepPos = lastDashPos.add(step.scale(i));
            for (int w = -1; w <= 1; w++)
            {
                Vector3d offset = side.scale(w * 0.8);
                BlockPos pos = new BlockPos(stepPos.x + offset.x, stepPos.y - 1, stepPos.z + offset.z);
                BlockState state = entity.level.getBlockState(pos);
                if (!state.isAir() && state.getBlock() != Blocks.BLUE_ICE)
                    entity.level.setBlockAndUpdate(pos, Blocks.BLUE_ICE.defaultBlockState());
            }
        }
        lastDashPos = currPos;

        // Freeze and damage entities
        List<LivingEntity> targets = rangeComponent.getTargetsInArea(entity, RANGE);
        for (LivingEntity target : targets)
        {
            if (hitTrackerComponent.canHit(target) && entity.canSee(target))
            {
                dealDamageComponent.hurtTarget(entity, target, DAMAGE);
                target.addEffect(new EffectInstance(ModEffects.FROZEN.get(), DURATION));
            }
        }
    }

    private void onContinuityEnd(LivingEntity entity, IAbility ability)
    {
        changeStatsComponent.removeModifiers(entity);
        cooldownComponent.startCooldown(entity, 300.0F);
    }

    static
    {
        INSTANCE = new AbilityCore.Builder<>("Freezing Dash", AbilityCategory.DEVIL_FRUITS, FreezingDashAbility::new)
                .addDescriptionLine(DESCRIPTION)
                .addAdvancedDescriptionLine(
                        AbilityDescriptionLine.NEW_LINE,
                        DealDamageComponent.getTooltip(DAMAGE),
                        ContinuousComponent.getTooltip(DASH_TICKS),
                        ChargeComponent.getTooltip(CHARGE_TIME),
                        CooldownComponent.getTooltip(300.0F),
                        RangeComponent.getTooltip(RANGE, RangeComponent.RangeType.AOE)
                )
                .setIcon(new net.minecraft.util.ResourceLocation("gopaddon", "textures/abilities/freezing_dash.png"))
                .build();
    }
}
