package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.datagen.setBuilder.*;
import fr.emotion.emomodworld.datagen.setBuilder.dimension.EmoDimensionType;
import fr.emotion.emomodworld.datagen.setBuilder.dimension.EmoLevelStem;
import fr.emotion.emomodworld.datagen.setBuilder.dimension.EmoNoiseGeneratorSettings;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class EmoSetBuilder {
    public static RegistrySetBuilder createBuilder() {
        return new RegistrySetBuilder()
                .add(Registries.BIOME, EmoBiome::init)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, EmoBiomeModifier::init)
                .add(Registries.WORLD_PRESET, EmoWorldPreset::init)
                .add(Registries.CONFIGURED_FEATURE, EmoConfiguredFeature::init)
                .add(Registries.PLACED_FEATURE, EmoPlacedFeature::init)
                .add(Registries.DIMENSION_TYPE, EmoDimensionType::init)
                .add(Registries.LEVEL_STEM, EmoLevelStem::init)
                .add(Registries.NOISE_SETTINGS, EmoNoiseGeneratorSettings::init);
    }
}
