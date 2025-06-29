package net.NewAge.addon.particles.effects.hie;

import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleType;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xyz.pixelatedw.mineminenomi.init.ModParticleTypes;
import xyz.pixelatedw.mineminenomi.particles.data.SimpleParticleData;
import xyz.pixelatedw.mineminenomi.particles.effects.ParticleEffect;
import xyz.pixelatedw.mineminenomi.wypi.WyHelper;
import xyz.pixelatedw.mineminenomi.particles.SimpleParticle;

public class FreezingDashParticleEffect extends ParticleEffect<ParticleEffect.NoDetails>
        implements IForgeRegistryEntry<ParticleEffect<?>>
{
    public FreezingDashParticleEffect()
    {
        super();
    }
    @Override
    public void spawn(Entity entity, World world, double posX, double posY, double posZ, NoDetails details)
    {
        for (int i = 0; i < 40; ++i)
        {
            double offsetX = WyHelper.randomDouble() / 1.5;
            double offsetY = WyHelper.randomDouble() / 1.5;
            double offsetZ = WyHelper.randomDouble() / 1.5;

            SimpleParticleData data = new SimpleParticleData((ParticleType<?>) ModParticleTypes.HIE.get());
            data.setLife(12); // lasts longer than fire
            data.setSize(1.0F); // medium icy puff
            data.setMotion(offsetX / 5.0, offsetY / 5.0 + 0.03, offsetZ / 5.0); // soft snowy rise

            world.addParticle(data, true,
                    posX + offsetX,
                    posY + 1.0 + offsetY,
                    posZ + offsetZ,
                    0.0, 0.0, 0.0);
        }
    }
}
