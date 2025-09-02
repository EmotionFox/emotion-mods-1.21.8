package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomoddimension.datagen.setBuilder.vegetation.EmoVegetationPlacedFeature;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class EmoPlacedFeature {
    public static void init(BootstrapContext<PlacedFeature> context){
        EmoVegetationPlacedFeature.init(context);
    }
}
