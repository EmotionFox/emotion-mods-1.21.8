package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.world.InGridPlacement;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EmoPlacedFeature {
    public static final ResourceKey<PlacedFeature> PEAR = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear")
    );

    public static final ResourceKey<PlacedFeature> BUSH = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                PEAR,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.PEAR), List.of(
                        InGridPlacement.spread(),
                        SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                        BiomeFilter.biome(),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(EmoBlocks.PEAR_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
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
