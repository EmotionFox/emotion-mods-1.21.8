package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.world.EmoWorldPresetKeys;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import fr.emotion.emomodworld.world.biome.ParcelBiomeSource;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

import java.util.Map;

public class EmoWorldPreset {
    public static void init(BootstrapContext<WorldPreset> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
        Holder<NoiseGeneratorSettings> overworldSettings = noiseSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD);
        HolderGetter<DimensionType> dimType = context.lookup(Registries.DIMENSION_TYPE);
        Holder<DimensionType> dimensionType = dimType.getOrThrow(BuiltinDimensionTypes.OVERWORLD);

        ParcelBiomeSource source = ParcelBiomeSource.create(biomeRegistry);

        context.register(EmoWorldPresetKeys.PARCEL, new WorldPreset(Map.of(LevelStem.OVERWORLD,
                        new LevelStem(dimensionType, new NoiseBasedChunkGenerator(source, overworldSettings))
                ))
        );
    }
}
