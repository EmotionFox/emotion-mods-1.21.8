package fr.emotion.emomoddimension.init;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.utils.DreamLossCriterion;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoCriteriaTriggers {
    private static final DeferredRegister<CriterionTrigger<?>> CRITERIA_TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, EmoMain.MODID);

    public static final DeferredHolder<CriterionTrigger<?>, DreamLossCriterion> DREAM_LOSS = CRITERIA_TRIGGERS.register(
            "dream_loss",
            DreamLossCriterion::new
    );

    public static void init(IEventBus eventBus) {
        CRITERIA_TRIGGERS.register(eventBus);
    }
}
