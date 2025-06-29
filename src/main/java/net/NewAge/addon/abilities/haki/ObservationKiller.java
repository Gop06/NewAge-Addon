package net.NewAge.addon.abilities.haki;

import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import xyz.pixelatedw.mineminenomi.abilities.haki.KenbunshokuHakiAuraAbility;
import xyz.pixelatedw.mineminenomi.abilities.haki.KenbunshokuHakiFutureSightAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.Ability;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.IAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ContinuousComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.CooldownComponent;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceHakiNature;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceType;
import xyz.pixelatedw.mineminenomi.api.helpers.HakiHelper;
import xyz.pixelatedw.mineminenomi.data.entity.ability.AbilityDataCapability;
import xyz.pixelatedw.mineminenomi.data.entity.ability.IAbilityData;
import xyz.pixelatedw.mineminenomi.data.entity.haki.HakiDataCapability;
import xyz.pixelatedw.mineminenomi.data.entity.haki.IHakiData;
import xyz.pixelatedw.mineminenomi.init.ModAbilityKeys;
import xyz.pixelatedw.mineminenomi.init.ModEffects;
import xyz.pixelatedw.mineminenomi.init.ModEntityPredicates;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;

public class ObservationKiller extends Ability
{
    public static final AbilityCore INSTANCE;
    public static int range;
    public static int cooldown;
    public static int overuse;

    public ObservationKiller(AbilityCore core)
    {
        super(core);
        this.isNew = true;
        this.addCanUseCheck(HakiHelper::canEnableHaki);
        this.addUseEvent(this::onUseEvent);
    }

    private void onUseEvent(LivingEntity player, IAbility ability)
    {
        boolean isOnMaxOveruse = HakiHelper.checkForHakiOveruse(player, overuse);
        if (!isOnMaxOveruse)
        {
            List<LivingEntity> targets = WyHelper.getNearbyLiving(Vector3d.atCenterOf(player.blockPosition()), player.level, (double)range, ModEntityPredicates.getEnemyFactions(player));
            targets.remove(player);
            IHakiData playerProps = HakiDataCapability.get(player);

            for (LivingEntity target : targets)
            {
                IHakiData props = HakiDataCapability.get(target);
                if (props.getMaxOveruse() < playerProps.getMaxOveruse())
                {
                    target.addEffect(new EffectInstance(ModEffects.PARALYSIS.get(), 20, 9));
                    target.addEffect(new EffectInstance(Effects.BLINDNESS.getEffect(), 20, 9));

                    IAbilityData abilityProps = AbilityDataCapability.get(target);
                    if (abilityProps != null)
                    {
                        for (IAbility a : abilityProps.getEquippedAbilities())
                        {
                            if (a.getCore() == KenbunshokuHakiAuraAbility.INSTANCE || a.getCore() == KenbunshokuHakiFutureSightAbility.INSTANCE)
                            {
                                a.getComponent(ModAbilityKeys.CONTINUOUS).ifPresent(comp -> ((ContinuousComponent) comp).stopContinuity(player));
                                a.getComponent(ModAbilityKeys.COOLDOWN).ifPresent(comp -> ((CooldownComponent) comp).startCooldown(player, 1200.0F));
                            }
                        }
                    }
                }
            }
        }
    }

    static
    {
        INSTANCE = (new AbilityCore.Builder("Observation Killer", AbilityCategory.HAKI, ObservationKiller::new))
                .addDescriptionLine("Stuns surrounding enemies and sets all their observation haki on a cooldown!")
                .setSourceType(new SourceType[]{SourceType.UNKNOWN})
                .setSourceHakiNature(SourceHakiNature.SPECIAL)
                .setUnlockCheck(user ->
                {
                    IHakiData hakiProps = HakiDataCapability.get(user);
                    return hakiProps != null && hakiProps.getTotalHakiExp() >= hakiProps.getMaxHakiExp() * 0.85F;
                })
                .build();

        range = 200;
        cooldown = 600;
        overuse = 10000;
    }
}