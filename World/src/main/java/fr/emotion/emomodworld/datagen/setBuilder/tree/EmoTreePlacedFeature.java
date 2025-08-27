package fr.emotion.emomodworld.datagen.setBuilder.tree;

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
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import java.util.List;

public class EmoTreePlacedFeature {
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

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                PEAR,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.PEAR), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PEAR_SAPLING.get())
                ))
        );
        context.register(
                ORANGE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.ORANGE), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ORANGE_SAPLING.get())
                ))
        );
        context.register(
                ATLAS,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.ATLAS), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ATLAS_SAPLING.get())
                ))
        );
        context.register(
                PINE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.PINE), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PINE_SAPLING.get())
                ))
        );
        context.register(
                FALLEN_PINE_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_PINE_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PINE_SAPLING.get())
                ))
        );
        context.register(
                COCO,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.COCO), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.COCO_SAPLING.get())
                ))
        );
        context.register(
                DREAM,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.DREAM), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.DREAM_SAPLING.get())
                ))
        );
    }
}
