package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.datagen.setBuilder.*;
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
                .add(Registries.PLACED_FEATURE, EmoPlacedFeature::init);
    }
}
