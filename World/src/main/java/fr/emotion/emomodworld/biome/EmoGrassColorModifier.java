package fr.emotion.emomodworld.biome;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import static fr.emotion.emomodworld.utils.EmoColor.blendColorsByHeight;

public class EmoGrassColorModifier {
    private static final PerlinSimplexNoise HEIGHT_NOISE = new PerlinSimplexNoise(new WorldgenRandom(new LegacyRandomSource(2345L)), ImmutableList.of(0));

    public static final EnumProxy<BiomeSpecialEffects.GrassColorModifier> VERDANT_SLOPES = new EnumProxy<>(BiomeSpecialEffects.GrassColorModifier.class,
            "emomodworld:verdant_slopes",
            new BiomeSpecialEffects.GrassColorModifier.ColorModifier() {
                @Override
                public int modifyGrassColor(double x, double z, int color) {
                    float simulatedHeight = (float) HEIGHT_NOISE.getValue(x * 0.02, z * 0.02, false);
                    float max = 319;
                    float min = 68;
                    float y = (float) (-64 + ((simulatedHeight - -1.0) / (1.0 - -1.0)) * (319 - -64));

                    int colorTop = 0x6e6048;
                    int colorBottom = 0x376f4a;

                    if (y > max)
                        return colorBottom;
                    else if (y < min)
                        return colorTop;
                    else
                        return blendColorsByHeight(colorTop, colorBottom, y, max - min, min);
                }
            });
}
