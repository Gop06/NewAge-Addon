package net.NewAge.addon;

import net.NewAge.addon.init.ModAbilities;
import net.NewAge.addon.init.ModEntities;
import net.NewAge.addon.init.ModParticleEffects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("newageaddon") // Make sure this matches your mod ID exactly
public class NewAgeAddon
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "newageaddon";

    public NewAgeAddon()
    {
        // Get the mod-specific event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register custom abilities
        ModAbilities.register();

        // Register custom entities
        ModEntities.ENTITY_TYPES.register(modEventBus);

        // Register custom particle effects
        ModParticleEffects.register(modEventBus);

        // Optional: Forge event bus (for general mod events, not needed for particles)
        MinecraftForge.EVENT_BUS.register(this);
    }
}
