package fr.emotion.emomodworld.datagen.setBuilder.vegetation;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EmoVegetationPlacedFeature {
    public static final ResourceKey<PlacedFeature> FLOWER_ORCHARD = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_orchard")
    );

    public static final ResourceKey<PlacedFeature> FLOWER_ANCIENT_FOREST = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_ancient_forest")
    );

    public static final ResourceKey<PlacedFeature> TREES_ORCHARD = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_orchard")
    );

    public static final ResourceKey<PlacedFeature> ANCIENT_FOREST_VEGETATION = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "ancient_forest_vegetation")
    );

    public static final ResourceKey<PlacedFeature> TREES_VERDANT_SLOPES = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_verdant_slopes")
    );

    public static final ResourceKey<PlacedFeature> TREES_DREAM_PLAINS = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_dream_plains")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                FLOWER_ORCHARD,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.FLOWER_ORCHARD), List.of(
                        CountPlacement.of(3),
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                FLOWER_ANCIENT_FOREST,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.FLOWER_ANCIENT_FOREST), List.of(
                        CountPlacement.of(3),
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                TREES_ORCHARD,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.TREES_ORCHARD),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.5F, 1)
                        ))
        );
        context.register(
                ANCIENT_FOREST_VEGETATION,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.ANCIENT_FOREST_VEGETATION), List.of(
                        CountPlacement.of(4),
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                TREES_VERDANT_SLOPES,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.TREES_VERDANT_SLOPES),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.5F, 2)
                        ))
        );
        context.register(
                TREES_DREAM_PLAINS,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.TREES_DREAM_PLAINS),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.5F, 2)
                        ))
        );
    }
}
