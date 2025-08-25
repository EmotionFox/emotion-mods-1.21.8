package fr.emotion.emomodworld.datagen.setBuilder;

import com.google.common.collect.ImmutableList;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.tree.*;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLogsDecorator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class EmoConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_ORCHARD = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_orchard")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_STONY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "trees_stony")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> ATLAS = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fallen_pine_tree")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> COCO = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> DREAM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    private static TreeConfiguration.TreeConfigurationBuilder createFruitTree(Block logBlock, Block leavesBlock) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new CrossTrunkPlacer(6, 2, 0, false, false),
                BlockStateProvider.simple(leavesBlock),
                new FruitTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPineTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EmoBlocks.PINE_LOG.get()),
                new CrossTrunkPlacer(10, 2, 0, true, false),
                BlockStateProvider.simple(EmoBlocks.PINE_LEAVES.get()),
                new PineTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenPine() {
        return createFallenTrees(EmoBlocks.PINE_LOG.get(), 8, 10);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createAtlasTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EmoBlocks.ATLAS_LOG.get()),
                new CrossTrunkPlacer(8, 2, 0, false, true),
                BlockStateProvider.simple(EmoBlocks.ATLAS_LEAVES.get()),
                new AtlasTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createDreamTree() {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(EmoBlocks.DREAM_LOG.get()),
                new CrossTrunkPlacer(16, 2, 0, true, true),
                BlockStateProvider.simple(EmoBlocks.DREAM_LEAVES.get()),
                new DreamTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenTrees(Block logBlock, int minLength, int maxLength) {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder(BlockStateProvider.simple(logBlock), UniformInt.of(minLength, maxLength))
                .logDecorators(ImmutableList.of(
                                new AttachedToLogsDecorator(
                                        0.1F,
                                        new WeightedStateProvider(
                                                WeightedList.<BlockState>builder()
                                                        .add(Blocks.MOSS_CARPET.defaultBlockState(), 3)
                                                        .add(Blocks.RED_MUSHROOM.defaultBlockState(), 2)
                                                        .add(Blocks.BROWN_MUSHROOM.defaultBlockState(), 1)
                                        ),
                                        List.of(Direction.UP)
                                )
                        )
                );
    }

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(
                TREES_ORCHARD,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.PEAR), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.ORANGE), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.ATLAS), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.PINE), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.COCO), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.DREAM), 0.5F),
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.FALLEN_PINE_TREE), 1.0F)
                                ),
                                placedFeatures.getOrThrow(EmoPlacedFeature.PEAR)
                        )
                )
        );
        context.register(
                TREES_STONY,
                new ConfiguredFeature<>(
                        Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(
                                List.of(
                                        new WeightedPlacedFeature(placedFeatures.getOrThrow(EmoPlacedFeature.PINE), 0.75F)
                                ),
                                placedFeatures.getOrThrow(EmoPlacedFeature.PINE)
                        )
                )
        );
        context.register(
                PEAR,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createFruitTree(EmoBlocks.PEAR_LOG.get(), EmoBlocks.PEAR_LEAVES.get()).build()
                )
        );
        context.register(
                ORANGE,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createFruitTree(EmoBlocks.ORANGE_LOG.get(), EmoBlocks.ORANGE_LEAVES.get()).build()
                )
        );
        context.register(
                ATLAS,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createAtlasTree().build()
                )
        );
        context.register(
                PINE,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createPineTree().build()
                )
        );
        context.register(
                FALLEN_PINE_TREE,
                new ConfiguredFeature<>(
                        Feature.FALLEN_TREE,
                        createFallenPine().build()
                )
        );
        context.register(
                COCO,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createFruitTree(EmoBlocks.COCO_LOG.get(), EmoBlocks.COCO_LEAVES.get()).build()
                )
        );
        context.register(
                DREAM,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createDreamTree().build()
                )
        );
        context.register(
                BUSH,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(
                                64,
                                6,
                                2,
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new NoiseThresholdProvider(
                                                        1995L,
                                                        new NormalNoise.NoiseParameters(0, 1.0),
                                                        0.005F,
                                                        -0.8F,
                                                        0.33333334F,
                                                        EmoBlocks.BUSH_BLACKCURRANT.get().defaultBlockState().setValue(EmoBushBlock.AGE, 0).setValue(EmoBushBlock.MOISTURE, 7),
                                                        List.of(
                                                                EmoBlocks.BUSH_BLACKCURRANT.get().defaultBlockState().setValue(EmoBushBlock.AGE, 0).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_BLUEBERRY.get().defaultBlockState().setValue(EmoBushBlock.AGE, 0).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_SWEET.get().defaultBlockState().setValue(EmoBushBlock.AGE, 0).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_STRAWBERRY.get().defaultBlockState().setValue(EmoBushBlock.AGE, 0).setValue(EmoBushBlock.MOISTURE, 7)
                                                        ),
                                                        List.of(
                                                                EmoBlocks.BUSH_BLACKCURRANT.get().defaultBlockState().setValue(EmoBushBlock.AGE, 3).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_BLUEBERRY.get().defaultBlockState().setValue(EmoBushBlock.AGE, 3).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_SWEET.get().defaultBlockState().setValue(EmoBushBlock.AGE, 3).setValue(EmoBushBlock.MOISTURE, 7),
                                                                EmoBlocks.BUSH_STRAWBERRY.get().defaultBlockState().setValue(EmoBushBlock.AGE, 3).setValue(EmoBushBlock.MOISTURE, 7)
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
