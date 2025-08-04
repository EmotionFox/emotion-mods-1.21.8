package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class EmoBlockTags {
    public static final TagKey<Block> PEAR_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_logs"));
}
