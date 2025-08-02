package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.biome.EmoBiomes;
import fr.emotion.emomodworld.biome.OrchardBiomeModifier;
import fr.emotion.emomodworld.tags.EmoBiomeKeys;
import fr.emotion.emomodworld.tags.EmoWorldPresetKeys;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterLists;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Map;

public class EmoSetBuilder {
    public static final ResourceKey<BiomeModifier> ORCHARD_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orchard_modifier")
    );

    public static RegistrySetBuilder createBuilder() {
        return new RegistrySetBuilder()
                .add(Registries.BIOME, context -> {
                    HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
                    HolderGetter<ConfiguredWorldCarver<?>> holdergetter1 = context.lookup(Registries.CONFIGURED_CARVER);

                    context.register(EmoBiomeKeys.ORCHARD, EmoBiomes.createOrchard(holdergetter, holdergetter1));
                })
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
                    HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

                    context.register(ORCHARD_MODIFIER,
                            new OrchardBiomeModifier(
                                    biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                                    20
                            ));
                })
                .add(Registries.WORLD_PRESET, context -> {
                    HolderGetter<MultiNoiseBiomeSourceParameterList> paramList = context.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);
                    HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
                    Holder<NoiseGeneratorSettings> overworldSettings = noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);
                    HolderGetter<DimensionType> dimType = context.lookup(Registries.DIMENSION_TYPE);
                    Holder<DimensionType> dimensionType = dimType.getOrThrow(BuiltinDimensionTypes.OVERWORLD);
                    context.register(EmoWorldPresetKeys.PARCEL, new WorldPreset(Map.of(LevelStem.OVERWORLD,
                                    new LevelStem(dimensionType, new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromPreset(paramList.getOrThrow(MultiNoiseBiomeSourceParameterLists.OVERWORLD)), overworldSettings))
                            ))
                    );
                });
    }
}
