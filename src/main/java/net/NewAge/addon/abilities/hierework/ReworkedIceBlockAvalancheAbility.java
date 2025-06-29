package net.NewAge.addon.abilities.hierework;

import net.NewAge.addon.entities.projectiles.ReworkedIceBlockAvalancheProjectile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.*;
import xyz.pixelatedw.mineminenomi.api.abilities.components.*;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceElement;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.init.ModParticleEffects;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;

public class ReworkedIceBlockAvalancheAbility extends Ability
{
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("gopaddon", "reworked_ice_block_avalanche", new Pair[]{
            ImmutablePair.of("Launches a massive ice block that crashes down and freezes the impact zone.", null)
    });

    private static final float DAMAGE = 100.0F;
    private static final float CHARGE_TIME = 100.0F;
    private static final float COOLDOWN = 360.0F;

    public static final AbilityCore INSTANCE = new AbilityCore.Builder("Ice Block: Avalanche", AbilityCategory.DEVIL_FRUITS, ReworkedIceBlockAvalancheAbility::new)
            .addDescriptionLine(DESCRIPTION)
            .addAdvancedDescriptionLine(AbilityDescriptionLine.NEW_LINE)
            .addAdvancedDescriptionLine(ChargeComponent.getTooltip(CHARGE_TIME))
            .addAdvancedDescriptionLine(CooldownComponent.getTooltip(COOLDOWN))
            .setSourceElement(SourceElement.ICE)
            .setIcon(new ResourceLocation("mineminenomi", "textures/abilities/ice_block_avalanche.png"))
            .build();

    private final ChargeComponent chargeComponent = new ChargeComponent(this)
            .addStartEvent(this::onChargeStart)
            .addTickEvent(this::onChargeTick)
            .addEndEvent(this::onChargeEnd);

    private ReworkedIceBlockAvalancheProjectile avalancheProjectile;

    public ReworkedIceBlockAvalancheAbility(AbilityCore<ReworkedIceBlockAvalancheAbility> core)
    {
        super(core);
        this.isNew = true;
        this.setDisplayName(new StringTextComponent("Ice Block: Avalanche"));
        this.setDisplayIcon(new ResourceLocation("mineminenomi", "textures/abilities/ice_block_avalanche.png"));
        this.addComponents(chargeComponent);
        this.addUseEvent(this::onUse);
    }

    private void onUse(LivingEntity entity, IAbility ability)
    {
        if (!chargeComponent.isCharging())
        {
            chargeComponent.startCharging(entity, CHARGE_TIME);
        }
        else if (chargeComponent.getChargeTime() >= 20)
        {
            chargeComponent.stopCharging(entity);
        }
    }

    private void onChargeStart(LivingEntity entity, IAbility ability)
    {
        RayTraceResult ray = WyHelper.rayTraceBlocksAndEntities(entity, 64.0F);
        this.removeExistingProjectile();

        avalancheProjectile = new ReworkedIceBlockAvalancheProjectile(entity.level, entity);
        avalancheProjectile.setSize(1.0F); // Ensure starting small for smooth growth
        avalancheProjectile.setPos(ray.getLocation().x(), ray.getLocation().y() + 20.0F, ray.getLocation().z());
        AbilityHelper.setDeltaMovement(avalancheProjectile, 0, 0, 0);
        entity.level.addFreshEntity(avalancheProjectile);
    }

    private void onChargeTick(LivingEntity entity, IAbility ability)
    {
        if (entity != null && avalancheProjectile != null && chargeComponent.getChargeTime() % 2 == 0)
        {
            WyHelper.spawnParticleEffect(ModParticleEffects.ICE_BLOCK_AVALANCHE.get(), entity,
                    avalancheProjectile.getX(), avalancheProjectile.getY(), avalancheProjectile.getZ());

            float newSize = avalancheProjectile.getSize() + 0.4F;
            avalancheProjectile.setSize(Math.min(newSize, 50.0F));
        }
    }

    private void onChargeEnd(LivingEntity entity, IAbility ability)
    {
        if (avalancheProjectile != null)
        {
            avalancheProjectile.finalized = true;
            AbilityHelper.setDeltaMovement(avalancheProjectile, 0, -2.0, 0);
            this.cooldownComponent.startCooldown(entity, COOLDOWN);
        }
    }

    private void removeExistingProjectile()
    {
        if (avalancheProjectile != null && avalancheProjectile.isAddedToWorld())
        {
            avalancheProjectile.remove();
        }
    }
}
