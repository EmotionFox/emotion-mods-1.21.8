package fr.emotion.emomoddimension.init;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.items.DreamCatcherBlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmoMain.MODID);

    public static final DeferredItem<Item> DREAM_CATCHER = ITEMS.registerItem("dream_catcher", props -> new DreamCatcherBlockItem(EmoBlocks.DREAM_CATCHER.get(), props));

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
