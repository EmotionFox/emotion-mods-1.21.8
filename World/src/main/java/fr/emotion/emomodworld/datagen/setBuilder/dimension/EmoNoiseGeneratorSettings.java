package fr.emotion.emomodworld.datagen.setBuilder.dimension;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class EmoNoiseGeneratorSettings {
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

    public static final ResourceKey<NoiseGeneratorSettings> DREAM_FLOATING_ISLANDS = ResourceKey.create(
            Registries.NOISE_SETTINGS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_floating_islands")
    );

    public static void init(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);

        DensityFunction shiftX = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(SHIFT_X_KEY));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(SHIFT_Z_KEY));

        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noiseParameters.getOrThrow(Noises.VEGETATION));

        DensityFunction base3dNoise = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(BASE_3D_NOISE_END_KEY));

        DensityFunction topGradient = DensityFunctions.yClampedGradient(256 - 72, 256 - 184, 1.0, 0.0);
        DensityFunction slidedTop = DensityFunctions.lerp(topGradient, -23.4375, base3dNoise);
        DensityFunction bottomGradient = DensityFunctions.yClampedGradient(4, 32, 0.0, 1.0);
        DensityFunction slided = DensityFunctions.lerp(bottomGradient, -0.234375, slidedTop);

        DensityFunction blended = DensityFunctions.blendDensity(slided);
        DensityFunction densityfunction4 = DensityFunctions
                .mul(DensityFunctions.interpolated(blended), DensityFunctions.constant(0.64))
                .squeeze();

        context.register(
                DREAM_FLOATING_ISLANDS,
                new NoiseGeneratorSettings(
                        new NoiseSettings(0, 256, 1, 1),
                        Blocks.DEEPSLATE.defaultBlockState(),
                        Blocks.WATER.defaultBlockState(),
                        new NoiseRouter(
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                temperature,
                                vegetation,
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                densityfunction4,
                                DensityFunctions.zero(),
                                DensityFunctions.zero(),
                                DensityFunctions.zero()
                        ),
                        dreamLike(),
                        List.of(),
                        -64,
                        false,
                        true,
                        true,
                        false
                )
        );
    }

    public static SurfaceRules.RuleSource dreamLike() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(EmoBiomeKeys.DREAM_PLAINS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.state(Blocks.MYCELIUM.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING,
                                        SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
                                )
                        )
                ),

                SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
        );
    }
}
