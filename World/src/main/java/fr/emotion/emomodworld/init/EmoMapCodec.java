package fr.emotion.emomodworld.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.biome.OrchardBiomeModifier;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import fr.emotion.emomodworld.world.biome.ParcelBiomeSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class EmoMapCodec {
    private static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER = DeferredRegister.create(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS, EmoMain.MODID);

    public static final Supplier<MapCodec<OrchardBiomeModifier>> ORCHARD_BIOME_MODIFIER = BIOME_MODIFIER.register("orchard_biome_modifier", () -> RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(OrchardBiomeModifier::biomes),
                    Codec.INT.fieldOf("value").forGetter(OrchardBiomeModifier::value)
            ).apply(instance, OrchardBiomeModifier::new)
    ));

    private static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(Registries.BIOME_SOURCE, EmoMain.MODID);

    public static final Supplier<MapCodec<ParcelBiomeSource>> PARCEL_BIOME_SOURCE = BIOME_SOURCE.register("parcel_biome_source", () -> RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    RegistryOps.retrieveElement(Biomes.PLAINS),
                    RegistryOps.retrieveElement(EmoBiomeKeys.ORCHARD),
                    RegistryOps.retrieveElement(EmoBiomeKeys.ANCIENT_FOREST),
                    RegistryOps.retrieveElement(EmoBiomeKeys.VERDANT_SLOPES)
            ).apply(instance, ParcelBiomeSource::new)
    ));

    public static void init(IEventBus event) {
        BIOME_MODIFIER.register(event);
        BIOME_SOURCE.register(event);
    }
}
