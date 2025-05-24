package net.akcraft.world;

import net.akcraft.ArknightsCraft;
import net.akcraft.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORIGINIUM_ORE_KEY = registerKey("originium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest replaceDeepslate = new BlockMatchRuleTest(Blocks.DEEPSLATE); // What a pain in the ass this is. The fricking ore won't generate

        List<OreFeatureConfig.Target> originiumOres =
                List.of(OreFeatureConfig.createTarget(replaceDeepslate, ModBlocks.ORIGINIUM_ORE.getDefaultState()));

        register(context, ORIGINIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(originiumOres, 4)); //I guess I'll take the L and put a 4 here instead of 1

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ArknightsCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
