package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.datagen.setBuilder.tree.EmoTreePlacedFeature;
import fr.emotion.emomodworld.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class EmoPlacedFeature {
    public static final ResourceKey<PlacedFeature> BUSH = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "bush")
    );

    public static final ResourceKey<PlacedFeature> BLUE_MUSHROOM_NORMAL = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "blue_mushroom_normal")
    );

    public static final ResourceKey<PlacedFeature> GREEN_MUSHROOM_NORMAL = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "green_mushroom_normal")
    );

    public static void init(BootstrapContext<PlacedFeature> context) {
        EmoTreePlacedFeature.init(context);
        EmoVegetationPlacedFeature.init(context);

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                BUSH,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                BLUE_MUSHROOM_NORMAL,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.PATCH_BLUE_MUSHROOM), List.of(
                        RarityFilter.onAverageOnceEvery(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ))
        );
        context.register(
                GREEN_MUSHROOM_NORMAL,
                new PlacedFeature(configuredFeatures.getOrThrow(EmoConfiguredFeature.PATCH_GREEN_MUSHROOM), List.of(
                        RarityFilter.onAverageOnceEvery(64),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                ))
        );
    }
}
