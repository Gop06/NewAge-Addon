package net.NewAge.addon.abilities.hierework;

import java.util.function.Predicate;
import net.NewAge.addon.init.ModResources;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityDescriptionLine;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityOverlay;
import xyz.pixelatedw.mineminenomi.api.abilities.IAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.PunchAbility2;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityOverlay.OverlayPart;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ChangeStatsComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ContinuousComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.CooldownComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.RequireMorphComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.SkinOverlayComponent;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceElement;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceHakiNature;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceType;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.init.ModDamageSource;
import xyz.pixelatedw.mineminenomi.init.ModEffects;



public class GlacialCoating extends PunchAbility2 {
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("gopaddon", "glacial_coating", new Pair[]{ImmutablePair.of("The user coats their arm in such a low temperature that it freezes", (Object)null)});
    private static final float THRESHOLD = 400.0F;
    private static final float COOLDOWN = 200.0F;
    private static final int FROSTBITE_TIME = 100;
    public static final AbilityCore INSTANCE = (new AbilityCore.Builder("Glacial Coating", AbilityCategory.DEVIL_FRUITS, GlacialCoating::new)).addDescriptionLine(DESCRIPTION).addDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE, RequireMorphComponent.getTooltip()}).addAdvancedDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE, CooldownComponent.getTooltip(200.0F), ContinuousComponent.getTooltip(400.0F), ChangeStatsComponent.getTooltip()}).setSourceHakiNature(SourceHakiNature.SPECIAL).setSourceType(new SourceType[]{SourceType.FIST}).setSourceElement(SourceElement.ICE).build();;
    private final SkinOverlayComponent skinOverlayComponent;
    private static final AbilityOverlay OVERLAY = (new AbilityOverlay.Builder()).setOverlayPart(OverlayPart.BODY).setTexture(ModResources.GLACIAL_COATING).build() ;
    public GlacialCoating(AbilityCore<GlacialCoating> core) {
        super(core);
        this.skinOverlayComponent = new SkinOverlayComponent(this, OVERLAY);
        super.isNew = true;
        super.continuousComponent.addStartEvent(this::onContinuityStart).addEndEvent(this::onContinuityEnd);
        super.addComponents(this.skinOverlayComponent);
    }
    private void onContinuityStart(LivingEntity entity, IAbility ability) {
        this.skinOverlayComponent.showAll(entity);
    }

    private void onContinuityEnd(LivingEntity entity, IAbility ability) {
        this.skinOverlayComponent.hideAll(entity);
    }

    public float getPunchDamage() {
        return 25.0F;
    }

    public float getPunchCooldown() {
        return COOLDOWN;
    }

    public boolean onHitEffect(LivingEntity entity, LivingEntity target, ModDamageSource source) {
        target.addEffect(new EffectInstance(ModEffects.FROSTBITE.get(), FROSTBITE_TIME, 2));
        return true;
    }

    public float getPunchHoldTime() {
        return THRESHOLD;
    }

    public Predicate<LivingEntity> canActivate() {
        return (entity) -> super.continuousComponent.isContinuous() && entity.getMainHandItem().isEmpty();
    }

    public int getUseLimit() {
        return -1;
    }
}
