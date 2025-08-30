package fr.emotion.emomodworld.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import fr.emotion.emomodworld.world.biome.ParcelBiomeSource;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.biome.BiomeSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoMapCodec {
    private static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOME_SOURCE = DeferredRegister.create(Registries.BIOME_SOURCE, EmoMain.MODID);

    public static final Supplier<MapCodec<ParcelBiomeSource>> PARCEL_BIOME_SOURCE = BIOME_SOURCE.register("parcel_biome_source", () -> RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    RegistryOps.retrieveElement(EmoBiomeKeys.DREAM_PLAINS),
                    RegistryOps.retrieveElement(EmoBiomeKeys.ORCHARD),
                    RegistryOps.retrieveElement(EmoBiomeKeys.ANCIENT_FOREST),
                    RegistryOps.retrieveElement(EmoBiomeKeys.VERDANT_SLOPES)
            ).apply(instance, ParcelBiomeSource::new)
    ));

    public static void init(IEventBus event) {
        BIOME_SOURCE.register(event);
    }
}
