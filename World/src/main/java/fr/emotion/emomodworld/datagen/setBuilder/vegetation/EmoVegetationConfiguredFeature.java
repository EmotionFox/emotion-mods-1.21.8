package fr.emotion.emomodworld.datagen.setBuilder.vegetation;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.datagen.setBuilder.EmoConfiguredFeature;
import fr.emotion.emomodworld.datagen.setBuilder.tree.EmoTreePlacedFeature;
import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class EmoVegetationConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_ORCHARD = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_orchard")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_ANCIENT_FOREST = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_ancient_forest")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ORCHARD = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_orchard")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_FOREST_VEGETATION = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "ancient_forest_vegetation")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_VERDANT_SLOPES = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_verdant_slopes")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_DREAM_PLAINS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_dream_plains")
    );

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(
                FLOWER_ORCHARD,
                new ConfiguredFeature<>(
                        Feature.FLOWER,
                        new RandomPatchConfiguration(
                                64,
                                6,
                                2,
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new NoiseProvider(
                                                        2345L,
                                                        new NormalNoise.NoiseParameters(0, 1.0),
                                                        0.020833334F,
                                                        List.of(
                                                                EmoBlocks.FLOWER_KITTY.get().defaultBlockState(),
                                                                EmoBlocks.FLOWER_DELY.get().defaultBlockState(),
                                                                EmoBlocks.FLOWER_GNON.get().defaultBlockState(),
                                                                EmoBlocks.FLOWER_NEBULA.get().defaultBlockState(),
                                                                Blocks.DANDELION.defaultBlockState(),
                                                                Blocks.POPPY.defaultBlockState()
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
        context.register(
                FLOWER_ANCIENT_FOREST,
                new ConfiguredFeature<>(
                        Feature.FLOWER,
                        new RandomPatchConfiguration(
                                64,
                                6,
                                2,
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new NoiseThresholdProvider(
                                                        2345L,
                                                        new NormalNoise.NoiseParameters(0, 1.0),
                                                        0.005F,
                                                        -0.8F,
                                                        0.33333334F,
                                                        EmoBlocks.FLOWER_NOX.get().defaultBlockState(),
                                                        List.of(
                                                                EmoBlocks.FLOWER_THORNY.get().defaultBlockState(),
                                                                EmoBlocks.FLOWER_CENTUS.get().defaultBlockState()
                                                        ),
                                                        List.of(
                                                                Blocks.CORNFLOWER.defaultBlockState(),
                                                                Blocks.BLUE_ORCHID.defaultBlockState(),
                                                                Blocks.AZURE_BLUET.defaultBlockState()
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
        context.register(
                TREES_ORCHARD,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.FALLEN_PEAR_TREE), 0.01F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.PEAR_BEEHIVE_002), 0.025F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.PEAR_SPIDER_NEST_005), 0.05F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ORANGE), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.FALLEN_ORANGE_TREE), 0.01F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ORANGE_BEEHIVE_002), 0.025F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ORANGE_SPIDER_NEST_005), 0.05F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.CHERRY), 0.3F)
                                ),
                                placedFeatures.getOrThrow(EmoTreePlacedFeature.PEAR)
                        )
                )
        );
        context.register(
                ANCIENT_FOREST_VEGETATION,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_BEES_002), 0.05F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_BEES_0002_LEAF_LITTER), 0.05F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER), 0.25F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ATLAS), 0.15F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.FALLEN_ATLAS_TREE), 0.015F),
                                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(EmoConfiguredFeature.HUGE_BLUE_MUSHROOM)), 0.025F),
                                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(EmoConfiguredFeature.HUGE_GREEN_MUSHROOM)), 0.015F)
                                ),
                                placedFeatures.getOrThrow(TreePlacements.OAK_CHECKED)
                        )
                )
        );
        context.register(
                TREES_VERDANT_SLOPES,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.PINE), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.FALLEN_PINE_TREE), 0.25F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.MEGA_PINE_CHECKED), 0.1F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.FALLEN_SPRUCE_TREE), 0.05F)
                                ),
                                placedFeatures.getOrThrow(TreePlacements.PINE_CHECKED)
                        )
                )
        );
        context.register(
                TREES_DREAM_PLAINS,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.FALLEN_DREAM_TREE), 0.05F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.DREAM_LEAF_LITTER), 0.25F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_CHECKED), 0.1F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.FALLEN_OAK_TREE), 0.025F)
                                ),
                                placedFeatures.getOrThrow(EmoTreePlacedFeature.DREAM)
                        )
                )
        );
    }
}
