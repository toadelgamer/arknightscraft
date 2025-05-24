package net.akcraft.datagen;

import net.akcraft.block.ModBlocks;
import net.akcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORIGINIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORUNDUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORIGINIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ORIGINITE_PRIME, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORIGINIUM_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORUNDUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCIENCE_DISK, Models.GENERATED);

        itemModelGenerator.register(ModItems.U_OFFICIAL_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.SLUG_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
