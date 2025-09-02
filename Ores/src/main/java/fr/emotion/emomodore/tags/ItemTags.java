package fr.emotion.emomodore.tags;

import fr.emotion.emomodore.EmoMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ItemTags {
    public static final TagKey<Item> FOSSIL_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "fossil_tool_materials"));
    public static final TagKey<Item> PURPURA_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "purpura_tool_materials"));
    public static final TagKey<Item> REPAIRS_VIRIDIS_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "repairs_viridis_armor"));
}