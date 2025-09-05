package fr.emotion.emomodcore;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue GUI_HEALTH = BUILDER
            .comment("Show entities health on GUI")
            .define("guiHealth", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
