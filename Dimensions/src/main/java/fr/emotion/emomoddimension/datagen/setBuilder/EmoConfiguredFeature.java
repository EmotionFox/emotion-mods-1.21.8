package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomoddimension.datagen.setBuilder.vegetation.EmoVegetationConfiguredFeature;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EmoConfiguredFeature {
    public static void init(BootstrapContext<ConfiguredFeature<?, ?>> context){
        EmoVegetationConfiguredFeature.init(context);
    }
}
