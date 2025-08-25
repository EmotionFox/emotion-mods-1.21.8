package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.InGridPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EmoPlacedFeature {
    public static final ResourceKey<PlacedFeature> TREES_ORCHARD = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_orchard")
    );

    public static final ResourceKey<PlacedFeature> TREES_STONY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_stony")
    );

    public static final ResourceKey<PlacedFeature> PEAR = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear")
    );

    public static final ResourceKey<PlacedFeature> ORANGE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange")
    );

    public static final ResourceKey<PlacedFeature> ATLAS = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas")
    );

    public static final ResourceKey<PlacedFeature> PINE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine")
    );

    public static final ResourceKey<PlacedFeature> FALLEN_PINE_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_pine_tree")
    );

    public static final ResourceKey<PlacedFeature> COCO = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco")
    );

    public static final ResourceKey<PlacedFeature> DREAM = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );

    public static final ResourceKey<PlacedFeature> BUSH = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                TREES_ORCHARD,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.TREES_ORCHARD), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                TREES_STONY,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.TREES_STONY), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                PEAR,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.PEAR), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PEAR_SAPLING.get())
                ))
        );
        context.register(
                ORANGE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.ORANGE), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ORANGE_SAPLING.get())
                ))
        );
        context.register(
                ATLAS,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.ATLAS), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ATLAS_SAPLING.get())
                ))
        );
        context.register(
                PINE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.PINE), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PINE_SAPLING.get())
                ))
        );
        context.register(
                FALLEN_PINE_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.FALLEN_PINE_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PINE_SAPLING.get())
                ))
        );
        context.register(
                COCO,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.COCO), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.COCO_SAPLING.get())
                ))
        );
        context.register(
                DREAM,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.DREAM), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.DREAM_SAPLING.get())
                ))
        );
        context.register(
                BUSH,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ))
        );
    }
}
