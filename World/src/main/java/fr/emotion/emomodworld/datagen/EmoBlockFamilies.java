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

    public static final BlockFamily ORANGE_PLANKS = familyBuilder(EmoBlocks.ORANGE_PLANKS.get())
            .button(EmoBlocks.ORANGE_BUTTON.get())
            .fence(EmoBlocks.ORANGE_FENCE.get())
            .fenceGate(EmoBlocks.ORANGE_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.ORANGE_PRESSURE_PLATE.get())
            .sign(EmoBlocks.ORANGE_SIGN.get(), EmoBlocks.ORANGE_WALL_SIGN.get())
            .slab(EmoBlocks.ORANGE_SLAB.get())
            .stairs(EmoBlocks.ORANGE_STAIRS.get())
            .door(EmoBlocks.ORANGE_DOOR.get())
            .trapdoor(EmoBlocks.ORANGE_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily ATLAS_PLANKS = familyBuilder(EmoBlocks.ATLAS_PLANKS.get())
            .button(EmoBlocks.ATLAS_BUTTON.get())
            .fence(EmoBlocks.ATLAS_FENCE.get())
            .fenceGate(EmoBlocks.ATLAS_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.ATLAS_PRESSURE_PLATE.get())
            .sign(EmoBlocks.ATLAS_SIGN.get(), EmoBlocks.ATLAS_WALL_SIGN.get())
            .slab(EmoBlocks.ATLAS_SLAB.get())
            .stairs(EmoBlocks.ATLAS_STAIRS.get())
            .door(EmoBlocks.ATLAS_DOOR.get())
            .trapdoor(EmoBlocks.ATLAS_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily PINE_PLANKS = familyBuilder(EmoBlocks.PINE_PLANKS.get())
            .button(EmoBlocks.PINE_BUTTON.get())
            .fence(EmoBlocks.PINE_FENCE.get())
            .fenceGate(EmoBlocks.PINE_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.PINE_PRESSURE_PLATE.get())
            .sign(EmoBlocks.PINE_SIGN.get(), EmoBlocks.PINE_WALL_SIGN.get())
            .slab(EmoBlocks.PINE_SLAB.get())
            .stairs(EmoBlocks.PINE_STAIRS.get())
            .door(EmoBlocks.PINE_DOOR.get())
            .trapdoor(EmoBlocks.PINE_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily COCO_PLANKS = familyBuilder(EmoBlocks.COCO_PLANKS.get())
            .button(EmoBlocks.COCO_BUTTON.get())
            .fence(EmoBlocks.COCO_FENCE.get())
            .fenceGate(EmoBlocks.COCO_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.COCO_PRESSURE_PLATE.get())
            .sign(EmoBlocks.COCO_SIGN.get(), EmoBlocks.COCO_WALL_SIGN.get())
            .slab(EmoBlocks.COCO_SLAB.get())
            .stairs(EmoBlocks.COCO_STAIRS.get())
            .door(EmoBlocks.COCO_DOOR.get())
            .trapdoor(EmoBlocks.COCO_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily DREAM_PLANKS = familyBuilder(EmoBlocks.DREAM_PLANKS.get())
            .button(EmoBlocks.DREAM_BUTTON.get())
            .fence(EmoBlocks.DREAM_FENCE.get())
            .fenceGate(EmoBlocks.DREAM_FENCE_GATE.get())
            .pressurePlate(EmoBlocks.DREAM_PRESSURE_PLATE.get())
            .sign(EmoBlocks.DREAM_SIGN.get(), EmoBlocks.DREAM_WALL_SIGN.get())
            .slab(EmoBlocks.DREAM_SLAB.get())
            .stairs(EmoBlocks.DREAM_STAIRS.get())
            .door(EmoBlocks.DREAM_DOOR.get())
            .trapdoor(EmoBlocks.DREAM_TRAPDOOR.get())
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
