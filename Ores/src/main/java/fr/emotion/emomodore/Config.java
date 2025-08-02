package fr.emotion.emomodore;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue FADING_CHANCE_VIRIDIS_CRYSTAL = BUILDER
            .comment("Viridis crystal fading chance")
            .defineInRange("fadingChanceViridisCrystal", 6, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue FADING_CHANCE_NETHER_LUME_ORE = BUILDER
            .comment("Nether lume ore fading chance")
            .defineInRange("fadingChanceNetherLumeOre", 4, 0, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
