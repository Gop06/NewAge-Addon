package net.NewAge.addon.init;

import net.NewAge.addon.particles.effects.hie.FreezingDashParticleEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import xyz.pixelatedw.mineminenomi.particles.effects.ParticleEffect;
import xyz.pixelatedw.mineminenomi.wypi.WyRegistry;

public class ModParticleEffects
{
    public static final RegistryObject<ParticleEffect<ParticleEffect.NoDetails>> FREEZING_DASH =
            WyRegistry.PARTICLE_EFFECTS.register("freezing_dash", FreezingDashParticleEffect::new);
    public static void register(IEventBus modEventBus) {
    }
}
