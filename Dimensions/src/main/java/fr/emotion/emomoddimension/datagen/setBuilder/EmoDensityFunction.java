package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class EmoDensityFunction {
    public static final ResourceKey<DensityFunction> SHIFT_X_KEY = ResourceKey.create(
            Registries.DENSITY_FUNCTION,
            ResourceLocation.fromNamespaceAndPath("minecraft", "shift_x")
    );

    public static final ResourceKey<DensityFunction> SHIFT_Z_KEY = ResourceKey.create(
            Registries.DENSITY_FUNCTION,
            ResourceLocation.fromNamespaceAndPath("minecraft", "shift_z")
    );

    public static final ResourceKey<DensityFunction> BASE_3D_NOISE_END_KEY = ResourceKey.create(
            Registries.DENSITY_FUNCTION,
            ResourceLocation.fromNamespaceAndPath("minecraft", "end/base_3d_noise")
    );

    public static final ResourceKey<DensityFunction> SMALL_NOISE = ResourceKey.create(
            Registries.DENSITY_FUNCTION,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "small_noise")
    );

    public static void init(BootstrapContext<DensityFunction> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);
        DensityFunction shiftX = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(EmoDensityFunction.SHIFT_X_KEY));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(EmoDensityFunction.SHIFT_Z_KEY));

        context.register(
                SMALL_NOISE,
                DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noiseParameters.getOrThrow(EmoNoiseParameters.SMALL_NOISE))
        );
    }
}
