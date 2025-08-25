package fr.emotion.emomodworld.datagen;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = EmoMain.MODID)
public class EmoDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();

        DatapackBuiltinEntriesProvider biomeProvider = new DatapackBuiltinEntriesProvider(
                output,
                event.getLookupProvider(),
                EmoSetBuilder.createBuilder(),
                Set.of(EmoMain.MODID)
        );

        event.getGenerator().addProvider(true, biomeProvider);
        event.getGenerator().addProvider(true, new EmoWorldPresetTagsProvider(output, biomeProvider.getRegistryProvider()));
        event.getGenerator().addProvider(true, new EmoBiomeTagsProvider(output, biomeProvider.getRegistryProvider()));

        event.createProvider(EmoBlockTagsProvider::new);
        event.createProvider(EmoItemTagsProvider::new);
        event.createProvider(EmoEntityTypeTagsProvider::new);

        event.createProvider(EmoModelProvider::new);

        event.createProvider(((output1, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        )));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        PackOutput output = event.getGenerator().getPackOutput();

        DatapackBuiltinEntriesProvider biomeProvider = new DatapackBuiltinEntriesProvider(
                output,
                event.getLookupProvider(),
                EmoSetBuilder.createBuilder(),
                Set.of(EmoMain.MODID)
        );

        event.getGenerator().addProvider(true, biomeProvider);
        event.getGenerator().addProvider(true, new EmoWorldPresetTagsProvider(output, biomeProvider.getRegistryProvider()));
        event.getGenerator().addProvider(true, new EmoBiomeTagsProvider(output, biomeProvider.getRegistryProvider()));

        event.createProvider(EmoBlockTagsProvider::new);
        event.createProvider(EmoItemTagsProvider::new);
        event.createProvider(EmoEntityTypeTagsProvider::new);

        event.createProvider(EmoModelProvider::new);

        event.createProvider(((output1, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        )));

        event.createProvider(EmoRecipeProvider.Runner::new);
    }

    @SubscribeEvent
    public static void onAddBlocksToBlockEntityType(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.SIGN, EmoBlocks.PEAR_SIGN.get(), EmoBlocks.PEAR_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.PEAR_HANGING_SIGN.get(), EmoBlocks.PEAR_WALL_HANGING_SIGN.get());
        event.modify(BlockEntityType.SIGN, EmoBlocks.ORANGE_SIGN.get(), EmoBlocks.ORANGE_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.ORANGE_HANGING_SIGN.get(), EmoBlocks.ORANGE_WALL_HANGING_SIGN.get());
        event.modify(BlockEntityType.SIGN, EmoBlocks.ATLAS_SIGN.get(), EmoBlocks.ATLAS_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.ATLAS_HANGING_SIGN.get(), EmoBlocks.ATLAS_WALL_HANGING_SIGN.get());
        event.modify(BlockEntityType.SIGN, EmoBlocks.PINE_SIGN.get(), EmoBlocks.PINE_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.PINE_HANGING_SIGN.get(), EmoBlocks.PINE_WALL_HANGING_SIGN.get());
        event.modify(BlockEntityType.SIGN, EmoBlocks.COCO_SIGN.get(), EmoBlocks.COCO_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.COCO_HANGING_SIGN.get(), EmoBlocks.COCO_WALL_HANGING_SIGN.get());
        event.modify(BlockEntityType.SIGN, EmoBlocks.DREAM_SIGN.get(), EmoBlocks.DREAM_WALL_SIGN.get());
        event.modify(BlockEntityType.HANGING_SIGN, EmoBlocks.DREAM_HANGING_SIGN.get(), EmoBlocks.DREAM_WALL_HANGING_SIGN.get());
    }
}
