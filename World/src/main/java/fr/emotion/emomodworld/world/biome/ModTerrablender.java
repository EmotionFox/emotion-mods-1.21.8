package fr.emotion.emomodworld.world.biome;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "overworld"), 20));
    }
}
