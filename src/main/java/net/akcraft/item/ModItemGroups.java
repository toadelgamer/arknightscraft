package net.akcraft.item;

import net.akcraft.ArknightsCraft;
import net.akcraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ORIGINIUM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArknightsCraft.MOD_ID, "originium"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ORIGINIUM_SHARD))
                    .displayName(Text.translatable("itemgroup.arknightscraft.originium"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ORUNDUM);
                        entries.add(ModItems.ORIGINITE_PRIME);
                        entries.add(ModItems.ORIGINIUM_SHARD);
                        entries.add(ModBlocks.ORUNDUM_BLOCK);
                        entries.add(ModBlocks.ORIGINIUM_BLOCK);
                        entries.add(ModBlocks.ORIGINIUM_ORE);

                    })
                    .build());

    public static final ItemGroup DISKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArknightsCraft.MOD_ID, "discs"),
            FabricItemGroup.builder().icon(() -> new ItemStack(Items.MUSIC_DISC_CAT))
                    .displayName(Text.translatable("itemgroup.arknightscraft.discs"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SCIENCE_DISK);

                    })
                    .build());

    public static final ItemGroup OPERATORS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArknightsCraft.MOD_ID, "operators"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.U_OFFICIAL_EGG))
                    .displayName(Text.translatable("itemgroup.arknightscraft.operators"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SKALTER_EGG);
                        entries.add(ModItems.PLUME_EGG);
                        entries.add(ModItems.SORA_EGG);
                        entries.add(ModItems.U_OFFICIAL_EGG);
                        entries.add(ModItems.SLUG_EGG);

                    })
                    .build());

    public static final ItemGroup MISC_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArknightsCraft.MOD_ID, "misc_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RECRUITER))
                    .displayName(Text.translatable("itemgroup.arknightscraft.misc_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RECRUITER);

                    })
                    .build());

    public static void registerItemGroups() {
        ArknightsCraft.LOGGER.info("Registering Item Groups for " + ArknightsCraft.MOD_ID);
    }
}
