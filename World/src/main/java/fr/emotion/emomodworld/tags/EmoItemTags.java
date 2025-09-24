package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class EmoItemTags {
    public static final TagKey<Item> PEAR_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_logs"));
    public static final TagKey<Item> ORANGE_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_logs"));
    public static final TagKey<Item> ATLAS_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_logs"));
    public static final TagKey<Item> PINE_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_logs"));
    public static final TagKey<Item> COCO_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_logs"));
    public static final TagKey<Item> DREAM_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_logs"));
}
