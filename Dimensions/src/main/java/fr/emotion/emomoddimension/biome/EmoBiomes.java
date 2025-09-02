package fr.emotion.emomoddimension.biome;

import fr.emotion.emomoddimension.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature;
import fr.emotion.emomodworld.datagen.setBuilder.EmoPlacedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EmoBiomes {
    public static Biome createDreamPlains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0xFFFFFF)
                .waterColor(0x38ccc4)
                .waterFogColor(0x38ccc4)
                .skyColor(0xFFFFFF)
                .grassColorOverride(0x38cc7a)
                .foliageColorOverride(0x38cc7a)
                .dryFoliageColorOverride(0xE1E1E1)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.GAME)
                .build();

        MobSpawnSettings.Builder spawn = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawn);

        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        addDreamVegetation(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(1.0f)
                .downfall(0.0f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(builder.build())
                .build();
    }

    public static void addDreamVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.PATCH_BUSH_DREAMCURRANT);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.GREEN_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.PATCH_DREAM_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.PATCH_TALL_DREAM_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, fr.emotion.emomodworld.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature.TREES_DREAM_PLAINS);
    }
}
