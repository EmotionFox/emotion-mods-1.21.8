package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.datagen.setBuilder.*;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class EmoSetBuilder {
    public static RegistrySetBuilder createBuilder() {
        return new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, EmoConfiguredFeature::init)
                .add(Registries.PLACED_FEATURE, EmoPlacedFeature::init)
                .add(Registries.BIOME, EmoBiome::init)
                .add(Registries.DIMENSION_TYPE, EmoDimensionType::init)
                .add(Registries.LEVEL_STEM, EmoLevelStem::init)
                .add(Registries.NOISE_SETTINGS, EmoNoiseGeneratorSettings::init)
                .add(Registries.DENSITY_FUNCTION, EmoDensityFunction::init)
                .add(Registries.NOISE, EmoNoiseParameters::init);
    }
}
