package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.advancements.MinePurpura;
import fr.emotion.emomodore.advancements.MineViridis;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = EmoMain.MODID)
public class EmoDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(EmoModelProvider::new);

        event.createProvider((output, lookupProvider) -> new AdvancementProvider(
                output,
                lookupProvider,
                List.of(MinePurpura::generate, MineViridis::generate)
        ));

        event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);

        event.createProvider((output, lookupProvider) ->
                new DatapackBuiltinEntriesProvider(
                        output,
                        lookupProvider,
                        EmoSetBuilder.createBuilder(),
                        Set.of(EmoMain.MODID))
        );
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        event.createProvider((output, lookupProvider) -> new AdvancementProvider(
                output,
                lookupProvider,
                List.of(MinePurpura::generate, MineViridis::generate)
        ));

        event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);

        event.createProvider((output, lookupProvider) ->
                new DatapackBuiltinEntriesProvider(
                        output,
                        lookupProvider,
                        EmoSetBuilder.createBuilder(),
                        Set.of(EmoMain.MODID))
        );
    }
}
