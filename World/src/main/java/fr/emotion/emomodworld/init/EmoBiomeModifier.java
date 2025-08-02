package fr.emotion.emomodworld.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.biome.OrchardBiomeModifier;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class EmoBiomeModifier {
    private static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER = DeferredRegister.create(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS, EmoMain.MODID);

    public static final Supplier<MapCodec<OrchardBiomeModifier>> ORCHARD_BIOME_MODIFIER = BIOME_MODIFIER.register("orchard_biome_modifier", () -> RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(OrchardBiomeModifier::biomes),
                    Codec.INT.fieldOf("value").forGetter(OrchardBiomeModifier::value)
            ).apply(instance, OrchardBiomeModifier::new)
    ));

    public static void init(IEventBus event) {
        BIOME_MODIFIER.register(event);
    }
}
