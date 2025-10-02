package fr.emotion.emomoddimension.datagen;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.advancements.EmoAdvancements;
import net.minecraft.data.PackOutput;
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
        PackOutput output = event.getGenerator().getPackOutput();

        DatapackBuiltinEntriesProvider setBuilder = new DatapackBuiltinEntriesProvider(
                output,
                event.getLookupProvider(),
                EmoSetBuilder.createBuilder(),
                Set.of(EmoMain.MODID)
        );

        event.getGenerator().addProvider(true, setBuilder);

        event.createProvider(EmoBlockTagsProvider::new);
        event.createProvider(EmoItemTagsProvider::new);

        event.createProvider(EmoModelProvider::new);

        event.createProvider(((packOutput, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        )));

        event.createProvider((packOutput, lookupProvider) -> new AdvancementProvider(
                packOutput,
                lookupProvider,
                List.of(
                        new EmoAdvancements()
                )
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        PackOutput output = event.getGenerator().getPackOutput();

        DatapackBuiltinEntriesProvider setBuilder = new DatapackBuiltinEntriesProvider(
                output,
                event.getLookupProvider(),
                EmoSetBuilder.createBuilder(),
                Set.of(EmoMain.MODID)
        );

        event.getGenerator().addProvider(true, setBuilder);

        event.createProvider(EmoBlockTagsProvider::new);
        event.createProvider(EmoItemTagsProvider::new);

        event.createProvider(EmoModelProvider::new);

        event.createProvider(((output1, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        )));

        event.createProvider((packOutput, lookupProvider) -> new AdvancementProvider(
                packOutput,
                lookupProvider,
                List.of(
                        new EmoAdvancements()
                )
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }
}
