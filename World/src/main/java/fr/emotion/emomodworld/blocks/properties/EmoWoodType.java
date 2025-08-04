package fr.emotion.emomodworld.blocks.properties;

import net.minecraft.world.level.block.state.properties.WoodType;

public class EmoWoodType {
    public static final WoodType PEAR = WoodType.register(
            new WoodType("pear", EmoBlockSetType.PEAR)
    );
}
