package fr.emotion.emomodcore.datagen;

import fr.emotion.emomodcore.EmoMain;
import fr.emotion.emomodcore.advancements.EmoAdvancements;
import net.minecraft.data.advancements.AdvancementProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;

@EventBusSubscriber(modid = EmoMain.MODID)
public class EmoDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider((packOutput, lookupProvider) -> new AdvancementProvider(
                packOutput,
                lookupProvider,
                List.of(
                        new EmoAdvancements()
                )
        ));
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        event.createProvider((packOutput, lookupProvider) -> new AdvancementProvider(
                packOutput,
                lookupProvider,
                List.of(
                        new EmoAdvancements()
                )
        ));
    }
}
