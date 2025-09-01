package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomoddimension.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class EmoDimension {
    public static final ResourceKey<Level> DREAM = ResourceKey.create(
            Registries.DIMENSION,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream")
    );
}
