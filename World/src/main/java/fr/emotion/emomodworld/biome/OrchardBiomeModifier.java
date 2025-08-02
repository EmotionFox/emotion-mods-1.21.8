package fr.emotion.emomodworld.biome;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.init.EmoBiomeModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

public record OrchardBiomeModifier(HolderSet<Biome> biomes, int value) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase==Phase.ADD) {
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return EmoBiomeModifier.ORCHARD_BIOME_MODIFIER.get();
    }
}
