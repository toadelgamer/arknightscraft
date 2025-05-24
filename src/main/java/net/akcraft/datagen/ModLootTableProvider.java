package net.akcraft.datagen;

import net.akcraft.block.ModBlocks;
import net.akcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ORIGINIUM_BLOCK);
        addDrop(ModBlocks.ORUNDUM_BLOCK);
        addDrop(ModBlocks.RECRUITER);

        addDrop(ModBlocks.ORIGINIUM_ORE, oreDrops(ModBlocks.ORIGINIUM_ORE, ModItems.ORIGINIUM_SHARD));
    }
}
