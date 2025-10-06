package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.components.PotsPredicate;
import net.minecraft.core.component.predicates.DataComponentPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoDataComponentPredicates {
    private static final DeferredRegister<DataComponentPredicate.Type<?>> DATA_COMPONENT_PREDICATE_TYPE = DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_PREDICATE_TYPE, EmoMain.MODID);

    public static final DeferredHolder<DataComponentPredicate.Type<?>, DataComponentPredicate.Type<PotsPredicate>> POTS = DATA_COMPONENT_PREDICATE_TYPE.register(
            "pot",
            resourceLocation -> new DataComponentPredicate.Type<>(PotsPredicate.CODEC)
    );

    public static void init(IEventBus event) {
        DATA_COMPONENT_PREDICATE_TYPE.register(event);
    }

}
