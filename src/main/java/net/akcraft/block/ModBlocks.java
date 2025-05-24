package net.akcraft.block;

import net.akcraft.ArknightsCraft;
import net.akcraft.block.custom.OriginiumBlock;
import net.akcraft.block.custom.Recruiter;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block ORUNDUM_BLOCK = registerBlock("orundum_block",
            new Block(AbstractBlock.Settings.create().strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.NETHERITE)));

    public static final Block ORIGINIUM_ORE = registerBlock("originium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 8),
                    AbstractBlock.Settings.create().strength(5f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block ORIGINIUM_BLOCK = registerBlock("originium_block",
            new OriginiumBlock(AbstractBlock.Settings.create().requiresTool()
                    .strength(4f).sounds(BlockSoundGroup.NETHERITE)));

    public static final Block RECRUITER = registerBlock("recruiter",
            new Recruiter(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOL)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArknightsCraft.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ArknightsCraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        ArknightsCraft.LOGGER.info("Registering Mod blocks for " + ArknightsCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.ORIGINIUM_ORE);
            fabricItemGroupEntries.add(ModBlocks.ORIGINIUM_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.ORUNDUM_BLOCK);
        });
    }

}
