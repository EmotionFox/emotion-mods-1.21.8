package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.items.EmoFoods;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmoMain.MODID);

    public static final DeferredItem<Item> PEAR_BOAT = ITEMS.registerItem("pear_boat", props -> new BoatItem(EmoEntityType.PEAR_BOAT.get(), props.stacksTo(1)));

    public static final DeferredItem<Item> PEAR_CHEST_BOAT = ITEMS.registerItem("pear_chest_boat", props -> new BoatItem(EmoEntityType.PEAR_CHEST_BOAT.get(), props.stacksTo(1)));

    public static final DeferredItem<Item> BLACKCURRANT = ITEMS.registerSimpleItem("blackcurrant", new Item.Properties().food(EmoFoods.BLACKCURRANT));
    public static final DeferredItem<Item> BLUEBERRY = ITEMS.registerSimpleItem("blueberry", new Item.Properties().food(EmoFoods.BLUEBERRY));
    public static final DeferredItem<Item> DREAMCURRANT = ITEMS.registerSimpleItem("dreamcurrant", new Item.Properties().food(EmoFoods.DREAMCURRANT));
    public static final DeferredItem<Item> STRAWBERRY = ITEMS.registerSimpleItem("strawberry", new Item.Properties().food(EmoFoods.STRAWBERRY));

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
