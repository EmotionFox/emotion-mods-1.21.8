package fr.emotion.emomodfood.tags;

import fr.emotion.emomodfood.EmoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class EmoItemTags {
    public static final TagKey<Item> MUFFIN = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "muffin"));
    public static final TagKey<Item> JUICE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "juice"));
}
