package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.datagen.setBuilder.tree.EmoTreeConfiguredFeature;
import fr.emotion.emomodworld.datagen.setBuilder.vegetation.EmoVegetationConfiguredFeature;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class EmoConfiguredFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLUE_MUSHROOM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_blue_mushroom")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GREEN_MUSHROOM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_green_mushroom")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_BLUE_MUSHROOM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "huge_blue_mushroom")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_GREEN_MUSHROOM = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "huge_green_mushroom")
    );

    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        EmoTreeConfiguredFeature.init(context);
        EmoVegetationConfiguredFeature.init(context);

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
        context.register(
                EmoConfiguredFeature.PATCH_BLUE_MUSHROOM,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EmoBlocks.BLUE_MUSHROOM.get())))
                )
        );
        context.register(
                EmoConfiguredFeature.PATCH_GREEN_MUSHROOM,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(EmoBlocks.GREEN_MUSHROOM.get())))
                )
        );
        context.register(
                EmoConfiguredFeature.HUGE_BLUE_MUSHROOM,
                new ConfiguredFeature<>(
                        EmoFeature.HUGE_BLUE_MUSHROOM.get(),
                        new HugeMushroomFeatureConfiguration(
                                BlockStateProvider.simple(
                                        EmoBlocks.BLUE_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, true).setValue(HugeMushroomBlock.DOWN, false)
                                ),
                                BlockStateProvider.simple(
                                        Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false)
                                ),
                                3
                        )
                )
        );
        context.register(
                EmoConfiguredFeature.HUGE_GREEN_MUSHROOM,
                new ConfiguredFeature<>(
                        EmoFeature.HUGE_GREEN_MUSHROOM.get(),
                        new HugeMushroomFeatureConfiguration(
                                BlockStateProvider.simple(
                                        EmoBlocks.GREEN_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.UP, true).setValue(HugeMushroomBlock.DOWN, false)
                                ),
                                BlockStateProvider.simple(
                                        Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, false).setValue(HugeMushroomBlock.DOWN, false)
                                ),
                                3
                        )
                )
        );
    }
}
