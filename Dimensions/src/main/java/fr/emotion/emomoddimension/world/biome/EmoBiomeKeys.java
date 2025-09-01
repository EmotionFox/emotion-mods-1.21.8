package fr.emotion.emomoddimension.world.biome;

import fr.emotion.emomoddimension.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class EmoBiomeKeys {
    public static final ResourceKey<Biome> DREAM_PLAINS = register("dream_plains");

    private static ResourceKey<Biome> register(String key) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, key));
    }
}
