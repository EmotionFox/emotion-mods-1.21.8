package fr.emotion.emomodore.tags;

import fr.emotion.emomodore.EmoMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BlockTags {
    public static final TagKey<Block> NEEDS_FOSSIL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "needs_fossil_tool"));
    public static final TagKey<Block> INCORRECT_FOR_FOSSIL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "incorrect_for_fossil_tool"));
    public static final TagKey<Block> NEEDS_PURPURA_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "needs_purpura_tool"));
    public static final TagKey<Block> INCORRECT_FOR_PURPURA_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "incorrect_for_purpura_tool"));
}
