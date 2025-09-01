package fr.emotion.emomoddimension.datagen.setBuilder;

import com.google.common.collect.ImmutableList;
import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class EmoNoiseParameters {
    public static final ResourceKey<NormalNoise.NoiseParameters> SMALL_NOISE = ResourceKey.create(
            Registries.NOISE,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "small_noise")
    );

    public static void init(BootstrapContext<NormalNoise.NoiseParameters> context) {
        context.register(
                SMALL_NOISE,
                new NormalNoise.NoiseParameters(-8, ImmutableList.of(0.5, 0.5, 0.5))
        );
    }
}
