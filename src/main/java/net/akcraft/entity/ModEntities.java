package net.akcraft.entity;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.custom.*;
import net.akcraft.entity.projectile.LapplandProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<EurekaEntity> U_OFFICIAL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "u_official"),
            EntityType.Builder.create(EurekaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.965f).build());
    public static final EntityType<SkalterEntity> SKADI_ALTER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "skadi_alter"),
            EntityType.Builder.create(SkalterEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.965f).build());
    public static final EntityType<SoraEntity> SORA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "sora"),
            EntityType.Builder.create(SoraEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.965f).build());
    public static final EntityType<PlumeEntity> PLUME = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "plume"),
            EntityType.Builder.create(PlumeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.965f).build());
    public static final EntityType<LapplandEntity> LAPPLAND = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "lappland"),
            EntityType.Builder.create(LapplandEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.65f, 1.965f).build());

    public static final EntityType<LapplandProjectileEntity> LAPPLAND_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "lappland_projectile"),
            EntityType.Builder.<LapplandProjectileEntity>create(LapplandProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build());

    public static final EntityType<SlugEntity> ORIGINIUM_SLUG = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ArknightsCraft.MOD_ID, "originium_slug"),
            EntityType.Builder.create(SlugEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.375f, 0.35f).build());

    public static void registerModEntities() {
        ArknightsCraft.LOGGER.info("Registering entities for " + ArknightsCraft.MOD_ID);
    }
}
