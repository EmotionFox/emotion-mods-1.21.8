package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class EmoBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = new HashMap<>();

    public static final BlockFamily PEAR_PLANKS = familyBuilder(EmoBlocks.PEAR_PLANKS.get())
            .button(EmoBlocks.PEAR_BUTTON.get())
            .fence(EmoBlocks.PEAR_FENCE.get())
            .fenceGate(EmoBlocks.PEAR_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.PEAR_PRESSURE_PLATE.get())
            .sign(EmoBlocks.PEAR_SIGN.get(), EmoBlocks.PEAR_WALL_SIGN.get())
            .slab(EmoBlocks.PEAR_SLAB.get())
            .stairs(EmoBlocks.PEAR_STAIRS.get())
            .door(EmoBlocks.PEAR_DOOR.get())
            .trapdoor(EmoBlocks.PEAR_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    private static BlockFamily.Builder familyBuilder(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily existing = MAP.put(baseBlock, builder.getFamily());
        if (existing!=null) {
            throw new IllegalStateException("Duplicate BlockFamily for block: " + baseBlock);
        }
        return builder;
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
