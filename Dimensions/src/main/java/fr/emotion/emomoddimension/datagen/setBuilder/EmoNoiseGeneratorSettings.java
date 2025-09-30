package fr.emotion.emomoddimension.datagen.setBuilder;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlocks;
import fr.emotion.emomoddimension.world.biome.EmoBiomeKeys;
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
    public static final ResourceKey<NoiseGeneratorSettings> DREAM_FLOATING_ISLANDS = ResourceKey.create(
            Registries.NOISE_SETTINGS,
            ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_floating_islands")
    );

    public static void init(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctions = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);

        DensityFunction shiftX = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(EmoDensityFunction.SHIFT_X_KEY));
        DensityFunction shiftZ = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(EmoDensityFunction.SHIFT_Z_KEY));

        DensityFunction temperature = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction vegetation = DensityFunctions.shiftedNoise2d(shiftX, shiftZ, 0.25, noiseParameters.getOrThrow(Noises.VEGETATION));

        DensityFunction base3dNoise = new DensityFunctions.HolderHolder(densityFunctions.getOrThrow(EmoDensityFunction.BASE_3D_NOISE_END_KEY));

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
                        new NoiseSettings(0, 256, 2, 1),
                        EmoBlocks.DREAM_STONE.get().defaultBlockState(),
                        Blocks.AIR.defaultBlockState(),
                        floatingIslands(densityFunctions, noiseParameters),
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
                                        SurfaceRules.state(EmoBlocks.DREAM_GRASS_BLOCK.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING,
                                        SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                        SurfaceRules.state(EmoBlocks.DREAM_STONE.get().defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR,
                                        SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
                                )
                        )
                ),

                SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())
        );
    }

    protected static NoiseRouter floatingIslands(HolderGetter<DensityFunction> densityFunction, HolderGetter<NormalNoise.NoiseParameters> noiseParameters) {
        return noNewCaves(densityFunction, noiseParameters, slideEndLike(getFunction(densityFunction, EmoDensityFunction.BASE_3D_NOISE_END_KEY), 0, 256));
    }

    private static DensityFunction slideEndLike(DensityFunction densityFunction, int minY, int height) {
        return slide(densityFunction, minY, height, 72, -184, -23.4375, 4, 32, -0.234375);
    }

    private static DensityFunction slide(
            DensityFunction input, int minY, int height, int topStartOffset, int topEndOffset, double topDelta, int bottomStartOffset, int bottomEndOffset, double bottomDelta
    ) {
        DensityFunction densityfunction1 = DensityFunctions.yClampedGradient(minY + height - topStartOffset, minY + height - topEndOffset, 1.0, 0.0);
        DensityFunction $$9 = DensityFunctions.lerp(densityfunction1, topDelta, input);
        DensityFunction densityfunction2 = DensityFunctions.yClampedGradient(minY + bottomStartOffset, minY + bottomEndOffset, 0.0, 1.0);
        return DensityFunctions.lerp(densityfunction2, bottomDelta, $$9);
    }

    private static NoiseRouter noNewCaves(
            HolderGetter<DensityFunction> densityFunctions, HolderGetter<NormalNoise.NoiseParameters> noiseParameters, DensityFunction postProcessor
    ) {
        DensityFunction densityfunction = getFunction(densityFunctions, EmoDensityFunction.SHIFT_X_KEY);
        DensityFunction densityfunction1 = getFunction(densityFunctions, EmoDensityFunction.SHIFT_Z_KEY);
        DensityFunction densityfunction2 = DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25, noiseParameters.getOrThrow(Noises.TEMPERATURE));
        DensityFunction densityfunction3 = DensityFunctions.shiftedNoise2d(densityfunction, densityfunction1, 0.25, noiseParameters.getOrThrow(Noises.VEGETATION));
        DensityFunction densityfunction4 = postProcess(postProcessor);
        return new NoiseRouter(
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                densityfunction2,
                densityfunction3,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                densityfunction4,
                DensityFunctions.zero(),
                DensityFunctions.zero(),
                DensityFunctions.zero()
        );
    }

    private static DensityFunction postProcess(DensityFunction densityFunction) {
        DensityFunction densityfunction = DensityFunctions.blendDensity(densityFunction);
        return DensityFunctions.mul(DensityFunctions.interpolated(densityfunction), DensityFunctions.constant(0.64)).squeeze();
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> densityFunctionRegistry, ResourceKey<DensityFunction> key) {
        return new DensityFunctions.HolderHolder(densityFunctionRegistry.getOrThrow(key));
    }
}
