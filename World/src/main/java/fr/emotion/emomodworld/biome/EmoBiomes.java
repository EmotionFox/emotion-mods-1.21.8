package fr.emotion.emomodworld.biome;

import fr.emotion.emomodworld.datagen.setBuilder.EmoPlacedFeature;
import fr.emotion.emomodworld.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature;
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
                .dryFoliageColorOverride(0x9dcc42)
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

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8f)
                .downfall(0.8f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(builder.build())
                .build();
    }

    public static Biome createAncientForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0x7244c4)
                .waterColor(0x4456c4)
                .waterFogColor(0x4456c4)
                .skyColor(0x7244c4)
                .grassColorOverride(0x4496c4)
                .foliageColorOverride(0x4496c4)
                .dryFoliageColorOverride(0x4496c4)
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
        BiomeDefaultFeatures.addForestGrass(builder);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.ANCIENT_FOREST_VEGETATION);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        addAncientForestVegetation(builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder, true);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.8f)
                .downfall(0.0f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(builder.build())
                .build();
    }

    public static Biome createVerdantSlopes(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0x7244c4)
                .waterColor(0x48696e)
                .waterFogColor(0x48696e)
                .skyColor(0x7244c4)
                .grassColorOverride(0x376f4a)
                .foliageColorOverride(0x6e6048)
                .dryFoliageColorOverride(0x6e6048)
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
        BiomeDefaultFeatures.addTaigaGrass(builder);
        addVerdantSlopesVegetation(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.8f)
                .downfall(0.2f)
                .specialEffects(effects)
                .mobSpawnSettings(spawn.build())
                .generationSettings(builder.build())
                .build();
    }

    public static void addOrchardVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_MEADOW);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.PATCH_BUSH_STRAWBERRY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.TREES_ORCHARD);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.FLOWER_ORCHARD);
    }

    public static void addAncientForestVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.PATCH_BUSH_BLUEBERRY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.BLUE_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.FLOWER_ANCIENT_FOREST);
    }

    public static void addVerdantSlopesVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoPlacedFeature.PATCH_BUSH_BLACKCURRANT);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EmoVegetationPlacedFeature.TREES_VERDANT_SLOPES);
    }
}
