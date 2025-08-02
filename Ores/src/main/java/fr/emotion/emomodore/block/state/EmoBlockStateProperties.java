package fr.emotion.emomodore.block.state;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class EmoBlockStateProperties {
    public static final Property<Integer> PHASE = IntegerProperty.create("phase", 0, 4);
}
