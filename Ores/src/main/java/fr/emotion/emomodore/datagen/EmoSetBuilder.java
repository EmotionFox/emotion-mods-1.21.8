package fr.emotion.emomodore.datagen;

import com.google.common.collect.ImmutableList;
import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.init.EmoBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class EmoSetBuilder {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_ORE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fossil_ore")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_BURIED_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_buried")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_SMALL_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_small")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_MEDIUM_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_medium")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_LARGE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_large")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIRIDIS_ORE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "viridis_ore")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUME_NETHER_ORE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "lume_nether_ore")
    );

    public static final ResourceKey<PlacedFeature> FOSSIL_ORE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fossil_ore")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_BURIED_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_buried")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_SMALL_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_small")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_MEDIUM_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_medium")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_LARGE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore_large")
    );

    public static final ResourceKey<PlacedFeature> VIRIDIS_ORE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "viridis_ore")
    );

    public static final ResourceKey<PlacedFeature> LUME_NETHER_ORE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "lume_nether_ore")
    );

    public static final ResourceKey<BiomeModifier> FOSSIL_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fossil_ore")
    );

    public static final ResourceKey<BiomeModifier> PURPURA_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_ore")
    );

    public static final ResourceKey<BiomeModifier> VIRIDIS_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "viridis_ore")
    );

    public static final ResourceKey<BiomeModifier> LUME_NETHER_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "lume_nether_ore")
    );

    protected static RegistrySetBuilder createBuilder() {
        return new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, bootstrap -> {
                    bootstrap.register(
                            FOSSIL_ORE_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                                    new BlockMatchTest(Blocks.DIRT),
                                    EmoBlocks.FOSSIL_ORE.get().defaultBlockState(),
                                    4))
                    );
                    bootstrap.register(
                            PURPURA_ORE_BURIED_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ImmutableList.of(OreConfiguration.target(
                                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EmoBlocks.PURPURA_ORE.get().defaultBlockState()), OreConfiguration.target(
                                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EmoBlocks.DEEPSLATE_PURPURA_ORE.get().defaultBlockState())),
                                    8,
                                    1.0F))
                    );
                    bootstrap.register(
                            PURPURA_ORE_SMALL_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ImmutableList.of(OreConfiguration.target(
                                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EmoBlocks.PURPURA_ORE.get().defaultBlockState()), OreConfiguration.target(
                                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EmoBlocks.DEEPSLATE_PURPURA_ORE.get().defaultBlockState())),
                                    4,
                                    0.5F))
                    );
                    bootstrap.register(
                            PURPURA_ORE_MEDIUM_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ImmutableList.of(OreConfiguration.target(
                                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EmoBlocks.PURPURA_ORE.get().defaultBlockState()), OreConfiguration.target(
                                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EmoBlocks.DEEPSLATE_PURPURA_ORE.get().defaultBlockState())),
                                    8,
                                    0.5F))
                    );
                    bootstrap.register(
                            PURPURA_ORE_LARGE_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ImmutableList.of(OreConfiguration.target(
                                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), EmoBlocks.PURPURA_ORE.get().defaultBlockState()), OreConfiguration.target(
                                    new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), EmoBlocks.DEEPSLATE_PURPURA_ORE.get().defaultBlockState())),
                                    12,
                                    0.7F))
                    );
                    bootstrap.register(
                            VIRIDIS_ORE_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                                    new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                                    EmoBlocks.VIRIDIS_ORE.get().defaultBlockState(),
                                    4))
                    );
                    bootstrap.register(
                            LUME_NETHER_ORE_CONFIGURED_FEATURE,
                            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                                    new BlockMatchTest(Blocks.NETHERRACK),
                                    EmoBlocks.NETHER_LUME_ORE.get().defaultBlockState(),
                                    8))
                    );
                })
                .add(Registries.PLACED_FEATURE, bootstrap -> {
                    HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstrap.lookup(Registries.CONFIGURED_FEATURE);

                    bootstrap.register(
                            FOSSIL_ORE_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(FOSSIL_ORE_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(30),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.belowTop(192)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            PURPURA_ORE_BURIED_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(PURPURA_ORE_BURIED_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(4),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            PURPURA_ORE_SMALL_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(PURPURA_ORE_BURIED_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(7),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            PURPURA_ORE_MEDIUM_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(PURPURA_ORE_BURIED_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(2),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-4)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            PURPURA_ORE_LARGE_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(PURPURA_ORE_BURIED_CONFIGURED_FEATURE), List.of(
                                    RarityFilter.onAverageOnceEvery(9),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            VIRIDIS_ORE_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(VIRIDIS_ORE_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(4),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.belowTop(192)),
                                    BiomeFilter.biome()))
                    );
                    bootstrap.register(
                            LUME_NETHER_ORE_PLACED_FEATURE,
                            new PlacedFeature(configuredFeatures.getOrThrow(LUME_NETHER_ORE_CONFIGURED_FEATURE), List.of(
                                    CountPlacement.of(8),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10)),
                                    BiomeFilter.biome()))
                    );
                })
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, bootstrap -> {
                    HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
                    HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

                    bootstrap.register(
                            FOSSIL_ORE_BIOME_MODIFIER,
                            new BiomeModifiers.AddFeaturesBiomeModifier(
                                    biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                                    HolderSet.direct(placedFeatures.getOrThrow(FOSSIL_ORE_PLACED_FEATURE)),
                                    GenerationStep.Decoration.TOP_LAYER_MODIFICATION
                            )
                    );
                    bootstrap.register(
                            PURPURA_ORE_BIOME_MODIFIER,
                            new BiomeModifiers.AddFeaturesBiomeModifier(
                                    biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                                    HolderSet.direct(List.of(
                                            placedFeatures.getOrThrow(PURPURA_ORE_BURIED_PLACED_FEATURE),
                                            placedFeatures.getOrThrow(PURPURA_ORE_SMALL_PLACED_FEATURE),
                                            placedFeatures.getOrThrow(PURPURA_ORE_MEDIUM_PLACED_FEATURE),
                                            placedFeatures.getOrThrow(PURPURA_ORE_LARGE_PLACED_FEATURE))),
                                    GenerationStep.Decoration.UNDERGROUND_ORES
                            )
                    );
                    bootstrap.register(
                            VIRIDIS_ORE_BIOME_MODIFIER,
                            new BiomeModifiers.AddFeaturesBiomeModifier(
                                    biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                                    HolderSet.direct(placedFeatures.getOrThrow(VIRIDIS_ORE_PLACED_FEATURE)),
                                    GenerationStep.Decoration.UNDERGROUND_ORES
                            )
                    );
                    bootstrap.register(
                            LUME_NETHER_ORE_BIOME_MODIFIER,
                            new BiomeModifiers.AddFeaturesBiomeModifier(
                                    biomes.getOrThrow(BiomeTags.IS_NETHER),
                                    HolderSet.direct(placedFeatures.getOrThrow(LUME_NETHER_ORE_PLACED_FEATURE)),
                                    GenerationStep.Decoration.UNDERGROUND_ORES
                            )
                    );
                });
    }
}
