package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmoMain.MODID);

    public static final DeferredItem<Item> PEAR_BOAT = ITEMS.registerItem("pear_boat", props -> new BoatItem(EmoEntityType.PEAR_BOAT.get(), props.stacksTo(1)));

    public static final DeferredItem<Item> PEAR_CHEST_BOAT = ITEMS.registerItem("pear_chest_boat", props -> new BoatItem(EmoEntityType.PEAR_CHEST_BOAT.get(), props.stacksTo(1)));

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
