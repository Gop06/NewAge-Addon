package net.NewAge.addon.abilities.hierework;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.ITextComponent;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import xyz.pixelatedw.mineminenomi.api.abilities.Ability;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCategory;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityCore;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityDescriptionLine;
import xyz.pixelatedw.mineminenomi.api.abilities.IAbility;
import xyz.pixelatedw.mineminenomi.api.abilities.components.AbilityComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.CooldownComponent;
import xyz.pixelatedw.mineminenomi.api.abilities.components.ProjectileComponent;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceElement;
import xyz.pixelatedw.mineminenomi.api.damagesource.SourceHakiNature;
import xyz.pixelatedw.mineminenomi.api.helpers.AbilityHelper;
import xyz.pixelatedw.mineminenomi.entities.projectiles.hie.IceBlockPheasantProjectile;

public class ReworkedIceBlockPheasantAbility extends Ability {
    private static final ITextComponent[] DESCRIPTION = AbilityHelper.registerDescriptionText("mineminenomi", "ice_block_pheasant", new Pair[]{ImmutablePair.of("Releases a massive wave of ice in the shape of a pheasant", (Object)null)});
    private static final int COOLDOWN = 500;
    public static final AbilityCore<xyz.pixelatedw.mineminenomi.abilities.hie.IceBlockPheasantAbility> INSTANCE;
    private final ProjectileComponent projectileComponent = new ProjectileComponent(this, this::createProjectile);

    public ReworkedIceBlockPheasantAbility(AbilityCore<xyz.pixelatedw.mineminenomi.abilities.hie.IceBlockPheasantAbility> core) {
        super(core);
        super.isNew = true;
        this.addComponents(new AbilityComponent[]{this.projectileComponent});
        super.addUseEvent(this::onUseEvent);
    }

    private void onUseEvent(LivingEntity entity, IAbility ability) {
        this.projectileComponent.shoot(entity, 2.0F, 0.0F);
        super.cooldownComponent.startCooldown(entity, 500.0F);
    }

    private IceBlockPheasantProjectile createProjectile(LivingEntity entity) {
        IceBlockPheasantProjectile proj = new IceBlockPheasantProjectile(entity.level, entity, this);
        return proj;
    }

    static {
        INSTANCE = (new AbilityCore.Builder("Ice Block: Pheasant", AbilityCategory.DEVIL_FRUITS, xyz.pixelatedw.mineminenomi.abilities.hie.IceBlockPheasantAbility::new)).addDescriptionLine(DESCRIPTION).addAdvancedDescriptionLine(new AbilityDescriptionLine.IDescriptionLine[]{AbilityDescriptionLine.NEW_LINE, CooldownComponent.getTooltip(500.0F)}).addAdvancedDescriptionLine(ProjectileComponent.getProjectileTooltips()).setSourceHakiNature(SourceHakiNature.IMBUING).setSourceElement(SourceElement.ICE).build();
    }
}
