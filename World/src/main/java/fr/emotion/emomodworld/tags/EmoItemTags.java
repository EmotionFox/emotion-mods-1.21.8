package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class EmoItemTags {
    public static final TagKey<Item> PEAR_LOGS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_logs"));
}
