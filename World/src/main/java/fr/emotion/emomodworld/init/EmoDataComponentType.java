package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.entities.beetle.Beetle;
import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoDataComponentType {
    private static final DeferredRegister.DataComponents REGISTER = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, EmoMain.MODID);

    public static final Supplier<DataComponentType<Beetle.BeetleVariant>> BEETLE_VARIANT = REGISTER.registerComponentType(
            "beetle/variant",
            builder -> builder.persistent(Beetle.BeetleVariant.CODEC).networkSynchronized(Beetle.BeetleVariant.STREAM_CODEC)
    );

    public static final Supplier<DataComponentType<Butterfly.ButterflyVariant>> BUTTERFLY_VARIANT = REGISTER.registerComponentType(
            "butterfly/variant",
            builder -> builder.persistent(Butterfly.ButterflyVariant.CODEC).networkSynchronized(Butterfly.ButterflyVariant.STREAM_CODEC)
    );

    public static void init(IEventBus event) {
        REGISTER.register(event);
    }
}
