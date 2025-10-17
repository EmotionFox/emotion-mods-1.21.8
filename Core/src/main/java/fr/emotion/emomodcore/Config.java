package fr.emotion.emomodcore;

import net.minecraft.util.StringRepresentable;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue GUI_HEALTH = BUILDER
            .comment("Show entities health on GUI")
            .define("guiHealth", true);

    public static final ModConfigSpec.EnumValue<GuiPosition> GUI_POSITION = BUILDER
            .comment("Choose GUI position")
            .defineEnum("guiPosition", GuiPosition.LEFT_RIGHT);

    static final ModConfigSpec SPEC = BUILDER.build();

    public enum GuiPosition implements StringRepresentable {
        LEFT_RIGHT("left_right"),
        FULL_RIGHT("full_right"),
        BOTTOM_LEFT("bottom_left"),
        BOTTOM_RIGHT("bottom_right");

        private final String name;

        GuiPosition(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
