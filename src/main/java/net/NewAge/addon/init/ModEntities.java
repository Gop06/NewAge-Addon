package net.NewAge.addon.init;

import net.NewAge.addon.entities.projectiles.ReworkedIceBlockAvalancheProjectile;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, "newageaddon");

    public static final RegistryObject<EntityType<ReworkedIceBlockAvalancheProjectile>> REWORKED_ICE_BLOCK_AVALANCHE =
            ENTITY_TYPES.register("reworked_ice_block_avalanche",
                    () -> EntityType.Builder.<ReworkedIceBlockAvalancheProjectile>of(ReworkedIceBlockAvalancheProjectile::new, EntityClassification.MISC)
                            .sized(1.0F, 1.0F)
                            .build("reworked_ice_block_avalanche"));
}
