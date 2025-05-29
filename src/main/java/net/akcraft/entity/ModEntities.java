package net.akcraft.entity;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.EurekaEntity;
import net.akcraft.entity.custom.SkalterEntity;
import net.akcraft.entity.custom.SlugEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<EurekaEntity> U_OFFICIAL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "u_official"),
            EntityType.Builder.create(EurekaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.975f).build());
    public static final EntityType<SkalterEntity> SKADI_ALTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "skadi_alter"),
            EntityType.Builder.create(SkalterEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.975f).build());

    public static final EntityType<SlugEntity> ORIGINIUM_SLUG = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "originium_slug"),
            EntityType.Builder.create(SlugEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.375f, 0.35f).build());

    public static void registerModEntities() {
        ArknightsCraft.LOGGER.info("Registering entities for " + ArknightsCraft.MOD_ID);
    }
}
