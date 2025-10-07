package fr.emotion.emomodfurniture.datagen;

import fr.emotion.emomodfurniture.EmoMain;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = EmoMain.MODID)
public class EmoDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(EmoModelProvider::new);

        event.createProvider((packOutput, lookupProvider) -> new LootTableProvider(
                packOutput,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        event.createProvider(EmoModelProvider::new);

        event.createProvider((packOutput, lookupProvider) -> new LootTableProvider(
                packOutput,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }
}
