package fr.emotion.emomodworld.datagen.setBuilder.vegetation;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.datagen.setBuilder.EmoConfiguredFeature;
import fr.emotion.emomodworld.datagen.setBuilder.tree.EmoTreePlacedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class EmoVegetationConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ORCHARD = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_orchard")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_VERDANT_SLOPES = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_verdant_slopes")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_FOREST_VEGETATION = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "ancient_forest_vegetation")
    );

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(
                TREES_ORCHARD,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.PEAR), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ORANGE), 0.5F)
                                ),
                                placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER)
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
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(TreePlacements.FALLEN_SPRUCE_TREE), 0.25F)
                                ),
                                placedFeatures.getOrThrow(TreePlacements.PINE_CHECKED)
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
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoTreePlacedFeature.ATLAS), 0.1F),
                                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(EmoConfiguredFeature.HUGE_BLUE_MUSHROOM)), 0.025F),
                                        new WeightedPlacedFeature(PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(EmoConfiguredFeature.HUGE_GREEN_MUSHROOM)), 0.01F)
                                ),
                                placedFeatures.getOrThrow(TreePlacements.OAK_CHECKED)
                        )
                )
        );
    }
}
