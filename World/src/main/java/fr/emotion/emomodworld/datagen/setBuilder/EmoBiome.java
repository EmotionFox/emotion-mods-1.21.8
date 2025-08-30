package fr.emotion.emomodworld.datagen.setBuilder;

import fr.emotion.emomodworld.biome.EmoBiomes;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EmoBiome {
    public static void init(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(EmoBiomeKeys.ORCHARD, EmoBiomes.createOrchard(placedFeatures, configuredCarvers));
        context.register(EmoBiomeKeys.ANCIENT_FOREST, EmoBiomes.createAncientForest(placedFeatures, configuredCarvers));
        context.register(EmoBiomeKeys.VERDANT_SLOPES, EmoBiomes.createVerdantSlopes(placedFeatures, configuredCarvers));
        context.register(EmoBiomeKeys.DREAM_PLAINS, EmoBiomes.createDreamPlains(placedFeatures, configuredCarvers));
    }
}
