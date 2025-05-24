package net.akcraft.datagen;

import net.akcraft.ArknightsCraft;
import net.akcraft.block.ModBlocks;
import net.akcraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> ORIGINIUM_SHARD_SMELTABLE = List.of(ModItems.ORIGINIUM_SHARD, ModBlocks.ORIGINIUM_ORE);

        offerSmelting(recipeExporter, ORIGINIUM_SHARD_SMELTABLE, RecipeCategory.MISC,
                ModItems.ORIGINIUM_SHARD, 0.25f, 200, "originium_shard");
        offerBlasting(recipeExporter, ORIGINIUM_SHARD_SMELTABLE, RecipeCategory.MISC,
                ModItems.ORIGINIUM_SHARD, 0.25f, 100, "originium_shard");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.ORIGINIUM_SHARD, RecipeCategory.DECORATIONS, ModBlocks.ORIGINIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.ORUNDUM, RecipeCategory.DECORATIONS, ModBlocks.ORUNDUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ORUNDUM, 2)
                .pattern("sos")
                .pattern("oRo")
                .pattern("sos")
                .input('s', Items.STICK)
                .input('o', ModItems.ORIGINIUM_SHARD)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.ORIGINIUM_SHARD), conditionsFromItem(ModItems.ORIGINIUM_SHARD))
                .offerTo(recipeExporter, Identifier.of(ArknightsCraft.MOD_ID, "orundum_from_shards"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ORIGINITE_PRIME)
                .pattern("ggg")
                .pattern("gsg")
                .pattern("ggg")
                .input('g', Items.RAW_GOLD)
                .input('s', ModItems.ORUNDUM)
                .criterion(hasItem(ModItems.ORUNDUM), conditionsFromItem(ModItems.ORUNDUM))
                .offerTo(recipeExporter);

    }
}
