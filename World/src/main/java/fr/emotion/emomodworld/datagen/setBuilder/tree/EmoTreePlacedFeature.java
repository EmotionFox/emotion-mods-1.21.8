package fr.emotion.emomodworld.datagen.setBuilder.tree;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.InGridPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import java.util.List;

public class EmoTreePlacedFeature {
    public static final ResourceKey<PlacedFeature> PEAR = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear")
    );
    public static final ResourceKey<PlacedFeature> FALLEN_PEAR_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_pear_tree")
    );
    public static final ResourceKey<PlacedFeature> PEAR_BEEHIVE_002 = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_beehive_002")
    );
    public static final ResourceKey<PlacedFeature> PEAR_SPIDER_NEST_005 = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_spider_nest_005")
    );


    public static final ResourceKey<PlacedFeature> ORANGE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange")
    );
    public static final ResourceKey<PlacedFeature> FALLEN_ORANGE_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_orange_tree")
    );
    public static final ResourceKey<PlacedFeature> ORANGE_BEEHIVE_002 = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_beehive_002")
    );
    public static final ResourceKey<PlacedFeature> ORANGE_SPIDER_NEST_005 = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_spider_nest_005")
    );

    public static final ResourceKey<PlacedFeature> CHERRY = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "cherry")
    );

    public static final ResourceKey<PlacedFeature> ATLAS = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas")
    );
    public static final ResourceKey<PlacedFeature> FALLEN_ATLAS_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_atlas_tree")
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
    public static final ResourceKey<PlacedFeature> FALLEN_COCO_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_coco_tree")
    );

    public static final ResourceKey<PlacedFeature> DREAM = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );
    public static final ResourceKey<PlacedFeature> FALLEN_DREAM_TREE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_dream_tree")
    );
    public static final ResourceKey<PlacedFeature> DREAM_LEAF_LITTER = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_leaf_litter")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                PEAR,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.PEAR), orchardPlacement(EmoBlocks.PEAR_SAPLING.get()))
        );
        context.register(
                FALLEN_PEAR_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_PEAR_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PEAR_SAPLING.get())
                ))
        );
        context.register(
                PEAR_BEEHIVE_002,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.PEAR_BEES_002), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PEAR_SAPLING.get())
                ))
        );
        context.register(
                PEAR_SPIDER_NEST_005,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.PEAR_SPIDERS_005), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.PEAR_SAPLING.get())
                ))
        );
        context.register(
                ORANGE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.ORANGE), orchardPlacement(EmoBlocks.ORANGE_SAPLING.get()))
        );
        context.register(
                FALLEN_ORANGE_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_ORANGE_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ORANGE_SAPLING.get())
                ))
        );
        context.register(
                ORANGE_BEEHIVE_002,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.ORANGE_BEES_002), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ORANGE_SAPLING.get())
                ))
        );
        context.register(
                ORANGE_SPIDER_NEST_005,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.ORANGE_SPIDERS_005), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.ORANGE_SAPLING.get())
                ))
        );
        context.register(
                CHERRY,
                new PlacedFeature(configuredFeatures.getOrThrow(TreeFeatures.CHERRY), orchardPlacement(Blocks.CHERRY_SAPLING))
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
                FALLEN_ATLAS_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_ATLAS_TREE), List.of(
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
                FALLEN_COCO_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_COCO_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.COCO_SAPLING.get())
                ))
        );
        context.register(
                DREAM,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.DREAM), List.of(
                        InSquarePlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.DREAM_SAPLING.get())
                ))
        );
        context.register(
                FALLEN_DREAM_TREE,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.FALLEN_DREAM_TREE), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.DREAM_SAPLING.get())
                ))
        );

        context.register(
                DREAM_LEAF_LITTER,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoTreeConfiguredFeature.DREAM_LEAF_LITTER), List.of(
                        PlacementUtils.filteredByBlockSurvival(EmoBlocks.DREAM_SAPLING.get())
                ))
        );
    }

    private static List<PlacementModifier> orchardPlacement(Block sapling) {
        return List.of(
                InGridPlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                PlacementUtils.filteredByBlockSurvival(sapling)
        );
    }
}
