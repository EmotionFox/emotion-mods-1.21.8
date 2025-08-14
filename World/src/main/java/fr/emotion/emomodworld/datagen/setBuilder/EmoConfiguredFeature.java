package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.tree.CrossTrunkPlacer;
import fr.emotion.emomodworld.world.tree.FruitTreeFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class EmoConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    private static TreeConfiguration.TreeConfigurationBuilder createFruitTree(Block logBlock, Block leavesBlock) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new CrossTrunkPlacer(6, 2, 0),
                BlockStateProvider.simple(leavesBlock),
                new FruitTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPear() {
        return createFruitTree(EmoBlocks.PEAR_LOG.get(), EmoBlocks.PEAR_LEAVES.get());
    }

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(
                PEAR,
                new ConfiguredFeature<>(
                        Feature.TREE,
                        createPear().build()
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
