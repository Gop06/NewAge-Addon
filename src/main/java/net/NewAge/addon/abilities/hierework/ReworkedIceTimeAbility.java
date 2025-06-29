package net.NewAge.addon.abilities.hierework;

import java.util.function.Predicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityDescriptionLine;
import xyz.pixelatedw.mineminenomi.api.abilities.PunchAbility2;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ChangeStatsComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ContinuousComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.CooldownComponent;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceElement;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceHakiNature;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceType;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.init.ModDamageSource;
import xyz.pixelatedw.mineminenomi.init.ModEffects;

public class ReworkedIceTimeAbility extends PunchAbility2 {
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("gopaddon", "reworked_ice_time", new Pair[]{ImmutablePair.of("Hit the target to encase them in ice", (Object)null)});
    private static final int COOLDOWN = 800;
    public static final AbilityCore INSTANCE;

    public ReworkedIceTimeAbility(AbilityCore<xyz.pixelatedw.mineminenomi.abilities.hie.IceTimeAbility> core) {
        super(core);
    }

    public boolean onHitEffect(LivingEntity entity, LivingEntity target, ModDamageSource source) {
        target.addEffect(new EffectInstance((Effect)ModEffects.FROZEN.get(), 250, 0));
        return true;
    }

    public Predicate<LivingEntity> canActivate() {
        return (entity) -> super.continuousComponent.isContinuous();
    }

    public int getUseLimit() {
        return 1;
    }

    public float getPunchCooldown() {return COOLDOWN;
    }

    static {
        INSTANCE = (new AbilityCore.Builder("Ice Time", AbilityCategory.DEVIL_FRUITS, ReworkedIceTimeAbility::new)).addDescriptionLine(DESCRIPTION).addDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE}).addAdvancedDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE, CooldownComponent.getTooltip(900.0F), ContinuousComponent.getTooltip(), ChangeStatsComponent.getTooltip()}).setSourceHakiNature(SourceHakiNature.HARDENING).setSourceType(new SourceType[]{SourceType.FIST}).setSourceElement(SourceElement.ICE).build();
    }
}
