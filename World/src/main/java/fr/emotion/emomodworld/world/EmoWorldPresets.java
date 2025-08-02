package fr.emotion.emomodworld.world;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

public class EmoWorldPresets {
    public static final ResourceKey<WorldPreset> PARCEL = register("parcel");

    private static ResourceKey<WorldPreset> register(String name) {
        return ResourceKey.create(Registries.WORLD_PRESET, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, name));
    }
}
