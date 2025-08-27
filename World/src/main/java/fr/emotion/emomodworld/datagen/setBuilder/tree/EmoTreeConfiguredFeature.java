package fr.emotion.emomodworld.datagen.setBuilder.tree;

import com.google.common.collect.ImmutableList;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.tree.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
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
import net.minecraft.world.level.levelgen.feature.configurations.FallenTreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLogsDecorator;

import java.util.List;

public class EmoTreeConfiguredFeature {
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

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
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
    }

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
}
