// ===== ReworkedIceBlockAvalancheProjectile.java =====
package net.NewAge.addon.entities.projectiles;

import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import xyz.pixelatedw.mineminenomi.api.damagesource.AbilityDamageSource;
import xyz.pixelatedw.mineminenomi.entities.projectiles.AbilityProjectileEntity;
import xyz.pixelatedw.mineminenomi.entities.projectiles.IFlexibleSizeProjectile;
import xyz.pixelatedw.mineminenomi.entities.projectiles.hie.HieProjectiles;
import xyz.pixelatedw.mineminenomi.init.ModEffects;
import xyz.pixelatedw.mineminenomi.init.ModParticleEffects;
import xyz.pixelatedw.mineminenomi.particles.effects.ParticleEffect;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;

import java.util.List;

public class ReworkedIceBlockAvalancheProjectile extends AbilityProjectileEntity implements IFlexibleSizeProjectile
{
    public boolean finalized = false;
    private float size = 1.0F;

    public ReworkedIceBlockAvalancheProjectile(EntityType<?> type, World world)
    {
        super(type, world);
    }

    public ReworkedIceBlockAvalancheProjectile(World world, LivingEntity user)
    {
        super((EntityType) HieProjectiles.ICE_BLOCK_AVALANCHE.get(), world);
        this.setDamage(100.0F);
        this.setMaxLife(150);
        this.setPassThroughEntities();
        this.setCanGetStuckInGround();
        this.setPhysical();

        this.onTickEvent = this::onTickEvent;
        this.onBlockImpactEvent = this::onImpact;
    }

    private void onTickEvent()
    {
        float mult = this.size / 6.0F;
        this.setBoundingBox(this.getBoundingBox().inflate(mult));
        this.setEntityCollisionSize(mult);

        if (!finalized)
            this.size = Math.min(this.size + 0.4F, 50.0F);

        if (this.level.getBlockState(this.blockPosition().below()).getMaterial().isSolid())
            this.setDeltaMovement(0, 0, 0);
    }

    private void onImpact(BlockPos pos)
    {
        if (!this.level.isClientSide)
        {
            WyHelper.spawnParticleEffect((ParticleEffect) ModParticleEffects.ICE_BLOCK_AVALANCHE.get(), this, this.getX(), this.getY(), this.getZ());

            double radius = 30.0;
            List<LivingEntity> list = this.level.getEntitiesOfClass(
                    LivingEntity.class,
                    new AxisAlignedBB(this.getX() - radius, this.getY() - radius, this.getZ() - radius,
                            this.getX() + radius, this.getY() + radius, this.getZ() + radius)
            );
            list.remove(this.getThrower());

            for (LivingEntity target : list)
            {
                target.hurt(AbilityDamageSource.causeAbilityDamage(this.getThrower(), this.getParent()), this.getDamage());
                target.addEffect(new EffectInstance(ModEffects.FROZEN.get(), 8 * 20));
                target.addEffect(new EffectInstance(ModEffects.FROSTBITE.get(), 15 * 20));
            }

            createCrater(this.blockPosition(), (int) radius);
        }
    }

    private void createCrater(BlockPos center, int radius)
    {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int x = -radius; x <= radius; x++)
            for (int y = -5; y <= 5; y++)
                for (int z = -radius; z <= radius; z++)
                {
                    double distSq = x * x + z * z;
                    if (distSq <= radius * radius)
                    {
                        mutable.set(center.getX() + x, center.getY() + y, center.getZ() + z);
                        if (this.level.getBlockState(mutable).getMaterial().isSolid())
                            this.level.setBlock(mutable, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
    }

    public void setSize(float size) { this.size = size; }
    public float getSize() { return this.size; }
}
