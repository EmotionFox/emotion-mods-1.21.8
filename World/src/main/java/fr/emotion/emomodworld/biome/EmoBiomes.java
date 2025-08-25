package fr.emotion.emomodworld.biome;

import fr.emotion.emomodworld.datagen.setBuilder.EmoPlacedFeature;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EmoBiomes {
    public static Biome createOrchard(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(329011)
                .waterColor(0x2f59d3)
                .waterFogColor(0x2f59d3)
                .skyColor(0xFFbcf2ff)
                .grassColorOverride(0x9dcc42)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.GAME)
                .build();

        MobSpawnSettings.Builder spawn = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(spawn);
        BiomeDefaultFeatures.commonSpawns(spawn);

        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addPlainGrass(builder);
        addOrchardVegetation(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        BiomeDefaultFeatures.addDefaultMushrooms(builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder, true);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8f)
                .downfall(0.7f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(builder.build())
                .build();
    }

    public static void addOrchardVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.BUSH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.TREES_ORCHARD);
    }
}
