package fr.emotion.emomodworld.world.biome;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.init.EmoMapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

public class ParcelBiomeSource extends BiomeSource {
    private final Holder<Biome> b1;
    private final Holder<Biome> b2;
    private final Holder<Biome> b3;
    private final Holder<Biome> b4;

    public static ParcelBiomeSource create(HolderGetter<Biome> biomeGetter) {
        return new ParcelBiomeSource(
                biomeGetter.getOrThrow(Biomes.PLAINS),
                biomeGetter.getOrThrow(EmoBiomeKeys.ORCHARD),
                biomeGetter.getOrThrow(EmoBiomeKeys.ANCIENT_FOREST),
                biomeGetter.getOrThrow(EmoBiomeKeys.VERDANT_SLOPES)
        );
    }

    public ParcelBiomeSource(Holder<Biome> b1, Holder<Biome> b2, Holder<Biome> b3, Holder<Biome> b4) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
    }

    @Override
    protected MapCodec<? extends BiomeSource> codec() {
        return EmoMapCodec.PARCEL_BIOME_SOURCE.get();
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.of(this.b1, this.b2, this.b3, this.b4);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler climateSampler) {
        if (x >= 0 && z >= 0) {
            return b1;
        } else if (x < 0 && z < 0) {
            return b2;
        } else if (x >= 0) {
            return b3;
        } else {
            return b4;
        }
    }
}
