package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class EmoBiomeTags {
    public static final TagKey<Biome> IS_ANCIENT_FOREST = create("is_ancient_forest");
    public static final TagKey<Biome> HAS_DREAM_DUNGEON = create("has_dream_dungeon");

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, name));
    }
}
