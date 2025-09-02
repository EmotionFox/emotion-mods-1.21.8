package fr.emotion.emomoddimension.datagen.setBuilder.vegetation;

import fr.emotion.emomoddimension.EmoMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class EmoVegetationPlacedFeature {
    public static final ResourceKey<PlacedFeature> PATCH_DREAM_GRASS = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_dream_grass")
    );

    public static final ResourceKey<PlacedFeature> DREAM_GRASS_BONEMEAL = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_grass_bonemeal")
    );

    public static final ResourceKey<PlacedFeature> PATCH_TALL_DREAM_GRASS = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "patch_tall_dream_grass")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                PATCH_DREAM_GRASS,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.PATCH_DREAM_GRASS), List.of(
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                DREAM_GRASS_BONEMEAL,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.DREAM_GRASS_BONEMEAL), List.of(
                        PlacementUtils.isEmpty()
                ))
        );
        context.register(
                PATCH_TALL_DREAM_GRASS,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoVegetationConfiguredFeature.PATCH_TALL_DREAM_GRASS), List.of(
                        NoiseThresholdCountPlacement.of(-0.8, 0, 7),
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ))
        );
    }
}
