package fr.emotion.emomodworld.blocks.properties;

import net.minecraft.world.level.block.state.properties.WoodType;

public class EmoWoodType {
    public static final WoodType PEAR = WoodType.register(
            new WoodType("pear", EmoBlockSetType.PEAR)
    );
    public static final WoodType ORANGE = WoodType.register(
            new WoodType("orange", EmoBlockSetType.ORANGE)
    );
    public static final WoodType ATLAS = WoodType.register(
            new WoodType("atlas", EmoBlockSetType.ATLAS)
    );
    public static final WoodType PINE = WoodType.register(
            new WoodType("pine", EmoBlockSetType.PINE)
    );
    public static final WoodType COCO = WoodType.register(
            new WoodType("coco", EmoBlockSetType.COCO)
    );
    public static final WoodType DREAM = WoodType.register(
            new WoodType("dream", EmoBlockSetType.DREAM)
    );
}
