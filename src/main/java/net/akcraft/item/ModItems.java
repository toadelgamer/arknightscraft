package net.akcraft.item;

import net.akcraft.ArknightsCraft;
import net.akcraft.entity.ModEntities;
import net.akcraft.item.custom.LapplandProjectile;
import net.akcraft.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ORIGINITE_PRIME = registerItem("originite_prime", new Item(new Item.Settings()));
    public static final Item ORIGINIUM_SHARD = registerItem("originium_shard", new Item(new Item.Settings()));
    public static final Item ORUNDUM = registerItem("orundum", new Item(new Item.Settings()));

    public static final Item LAPPLAND_P = registerItem("lappland_p", new LapplandProjectile(new Item.Settings()));


    public static final Item U_OFFICIAL_EGG = registerItem("u_official_spawn_egg",
            new SpawnEggItem(ModEntities.U_OFFICIAL, 0xff8aff, 0xce8aff, new Item.Settings()));
    public static final Item PLUME_EGG = registerItem("plume_spawn_egg",
            new SpawnEggItem(ModEntities.PLUME, 0x191919, 0x7F5428, new Item.Settings()));
    public static final Item SKALTER_EGG = registerItem("skalter_spawn_egg",
            new SpawnEggItem(ModEntities.SKADI_ALTER, 0xa02128, 0x2ba4a6, new Item.Settings()));
    public static final Item SORA_EGG = registerItem("sora_spawn_egg",
            new SpawnEggItem(ModEntities.SORA, 0xf9ce8e, 0xa74455, new Item.Settings()));
    public static final Item SLUG_EGG = registerItem("originium_slug_spawn_egg",
            new SpawnEggItem(ModEntities.ORIGINIUM_SLUG, 0x1f1e19, 0xb89a04, new Item.Settings()));

    public static final Item SCIENCE_DISK = registerItem("science_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.SCIENCE_KEY).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ArknightsCraft.MOD_ID, name), item);
    }

    public static void registerModItems(){
        ArknightsCraft.LOGGER.info("Registering items for " + ArknightsCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ORIGINIUM_SHARD);
            fabricItemGroupEntries.add(ORUNDUM);
            fabricItemGroupEntries.add(ORIGINITE_PRIME);
        });
    }
}
