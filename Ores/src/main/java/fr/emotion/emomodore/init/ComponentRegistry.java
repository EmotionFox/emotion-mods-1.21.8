package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.components.EmoComponentCodecs;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ComponentRegistry {
    public static final DeferredRegister.DataComponents REGISTER = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MainRegistry.MODID);

    public static final Supplier<DataComponentType<PhaseRecord>> PHASE = REGISTER.registerComponentType(
            "phase",
            builder -> builder
                    .persistent(EmoComponentCodecs.PHASE_CODEC)
                    .networkSynchronized(EmoComponentCodecs.PHASE_STREAM_CODEC)
    );

    public static void init(IEventBus event) {
        REGISTER.register(event);
    }
}
