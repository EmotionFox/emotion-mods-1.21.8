package fr.emotion.emomodworld.tags;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class EmoBlockTags {
    public static final TagKey<Block> PEAR_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_logs"));
    public static final TagKey<Block> ORANGE_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_logs"));
    public static final TagKey<Block> ATLAS_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_logs"));
    public static final TagKey<Block> PINE_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_logs"));
    public static final TagKey<Block> COCO_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_logs"));
    public static final TagKey<Block> DREAM_LOGS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_logs"));
}
