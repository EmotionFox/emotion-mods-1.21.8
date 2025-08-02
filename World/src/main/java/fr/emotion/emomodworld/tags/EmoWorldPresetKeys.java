package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

public class EmoWorldPresetKeys {
    public static final ResourceKey<WorldPreset> PARCEL = register("parcel");

    private static ResourceKey<WorldPreset> register(String key) {
        return ResourceKey.create(Registries.WORLD_PRESET, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, key));
    }
}
