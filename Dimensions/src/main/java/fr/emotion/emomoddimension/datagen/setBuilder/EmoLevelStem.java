package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.world.biome.EmoBiomeKeys;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

public class EmoLevelStem {
    public static final ResourceKey<LevelStem> DREAM = ResourceKey.create(
            Registries.LEVEL_STEM,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );

    public static void init(BootstrapContext<LevelStem> context) {
        HolderGetter<DimensionType> dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
        Holder<NoiseGeneratorSettings> floatingIslands = noiseSettings.getOrThrow(EmoNoiseGeneratorSettings.DREAM_FLOATING_ISLANDS);

        LevelStem dreamLevelStem = new LevelStem(dimensionTypes.getOrThrow(EmoDimensionType.DREAM), new NoiseBasedChunkGenerator(new FixedBiomeSource(biomeRegistry.getOrThrow(EmoBiomeKeys.DREAM_PLAINS)), floatingIslands));

        context.register(
                DREAM,
                dreamLevelStem
        );
    }
}
