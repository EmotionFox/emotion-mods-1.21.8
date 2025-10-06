package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.components.EmoComponentCodecs;
import fr.emotion.emomodfood.components.PotRecord;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoComponents {
    private static final DeferredRegister.DataComponents DATA_COMPONENT_TYPE = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, EmoMain.MODID);

    public static final Supplier<DataComponentType<PotRecord>> POT = DATA_COMPONENT_TYPE.registerComponentType(
            "pot",
            builder -> builder
                    .persistent(EmoComponentCodecs.POT_CODEC)
                    .networkSynchronized(EmoComponentCodecs.POT_STREAM_CODEC)
    );

    public static void init(IEventBus event){
        DATA_COMPONENT_TYPE.register(event);
    }
}
