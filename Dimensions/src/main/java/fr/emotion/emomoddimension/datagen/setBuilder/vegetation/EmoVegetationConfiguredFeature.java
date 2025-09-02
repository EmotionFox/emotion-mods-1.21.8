package fr.emotion.emomoddimension.datagen.setBuilder.vegetation;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class EmoVegetationConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DREAM_GRASS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_dream_grass")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAM_GRASS_BONEMEAL = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_grass_bonemeal")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DREAM_GRASS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_tall_dream_grass")
    );

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
                PATCH_DREAM_GRASS,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        FeatureUtils.simpleRandomPatchConfiguration(
                                32,
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(BlockStateProvider.simple(EmoBlocks.DREAM_SHORT_GRASS.get()))
                                )
                        )
                )
        );
        context.register(
                DREAM_GRASS_BONEMEAL,
                new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(EmoBlocks.DREAM_SHORT_GRASS.get().defaultBlockState()))
                )
        );
        context.register(
                PATCH_TALL_DREAM_GRASS,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(EmoBlocks.DREAM_TALL_GRASS.get()))
                        )
                )
        );
    }
}
