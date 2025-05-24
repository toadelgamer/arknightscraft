package net.akcraft.block.entity;

import net.akcraft.ArknightsCraft;
import net.akcraft.block.ModBlocks;
import net.akcraft.block.entity.custom.RecruiterBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<RecruiterBlockEntity> RECRUITER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(ArknightsCraft.MOD_ID, "recruiter_be"),
                    BlockEntityType.Builder.create(RecruiterBlockEntity::new, ModBlocks.RECRUITER).build(null));

    public static void registerBlockEntities() {
        ArknightsCraft.LOGGER.info("Registering block entities for " + ArknightsCraft.MOD_ID);
    }

}
