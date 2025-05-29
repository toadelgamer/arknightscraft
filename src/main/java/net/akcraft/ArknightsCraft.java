package net.akcraft;

import net.akcraft.block.ModBlocks;
import net.akcraft.block.entity.ModBlockEntities;
import net.akcraft.entity.ModEntities;
import net.akcraft.entity.custom.EurekaEntity;
import net.akcraft.entity.custom.SkalterEntity;
import net.akcraft.entity.custom.SlugEntity;
import net.akcraft.entity.custom.SoraEntity;
import net.akcraft.item.ModItemGroups;
import net.akcraft.item.ModItems;
import net.akcraft.sound.ModSounds;
import net.akcraft.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArknightsCraft implements ModInitializer {
	public static final String MOD_ID = "arknightscraft";

	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModWorldGeneration.generateModWorldGen();
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();
		ModBlockEntities.registerBlockEntities();
		ModSounds.registerSounds();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FabricDefaultAttributeRegistry.register(ModEntities.U_OFFICIAL, EurekaEntity.createEurekaAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SKADI_ALTER, SkalterEntity.createSkalterAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SORA, SoraEntity.createSoraAttributes());


		FabricDefaultAttributeRegistry.register(ModEntities.ORIGINIUM_SLUG, SlugEntity.createSlugAttributes());
	}
}