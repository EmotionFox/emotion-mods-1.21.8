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

    public static final DeferredItem<Item> PEAR_BOAT = ITEMS.registerItem(
            "pear_boat", props -> new BoatItem(EmoEntityType.PEAR_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> ORANGE_BOAT = ITEMS.registerItem(
            "orange_boat", props -> new BoatItem(EmoEntityType.ORANGE_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> ATLAS_BOAT = ITEMS.registerItem(
            "atlas_boat", props -> new BoatItem(EmoEntityType.ATLAS_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> PINE_BOAT = ITEMS.registerItem(
            "pine_boat", props -> new BoatItem(EmoEntityType.PINE_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> COCO_BOAT = ITEMS.registerItem(
            "coco_boat", props -> new BoatItem(EmoEntityType.COCO_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> DREAM_BOAT = ITEMS.registerItem(
            "dream_boat", props -> new BoatItem(EmoEntityType.DREAM_BOAT.get(), props.stacksTo(1))
    );

    public static final DeferredItem<Item> PEAR_CHEST_BOAT = ITEMS.registerItem(
            "pear_chest_boat", props -> new BoatItem(EmoEntityType.PEAR_CHEST_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> ORANGE_CHEST_BOAT = ITEMS.registerItem(
            "orange_chest_boat", props -> new BoatItem(EmoEntityType.ORANGE_CHEST_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> ATLAS_CHEST_BOAT = ITEMS.registerItem(
            "atlas_chest_boat", props -> new BoatItem(EmoEntityType.ATLAS_CHEST_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> PINE_CHEST_BOAT = ITEMS.registerItem(
            "pine_chest_boat", props -> new BoatItem(EmoEntityType.PINE_CHEST_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> COCO_CHEST_BOAT = ITEMS.registerItem(
            "coco_chest_boat", props -> new BoatItem(EmoEntityType.COCO_CHEST_BOAT.get(), props.stacksTo(1))
    );
    public static final DeferredItem<Item> DREAM_CHEST_BOAT = ITEMS.registerItem(
            "dream_chest_boat", props -> new BoatItem(EmoEntityType.DREAM_CHEST_BOAT.get(), props.stacksTo(1))
    );

    public static final DeferredItem<Item> BLACKCURRANT = ITEMS.registerSimpleItem("blackcurrant", new Item.Properties().food(EmoFoods.BLACKCURRANT));
    public static final DeferredItem<Item> BLUEBERRY = ITEMS.registerSimpleItem("blueberry", new Item.Properties().food(EmoFoods.BLUEBERRY));
    public static final DeferredItem<Item> DREAMCURRANT = ITEMS.registerSimpleItem("dreamcurrant", new Item.Properties().food(EmoFoods.DREAMCURRANT));
    public static final DeferredItem<Item> STRAWBERRY = ITEMS.registerSimpleItem("strawberry", new Item.Properties().food(EmoFoods.STRAWBERRY));

    public static final DeferredItem<Item> PEAR = ITEMS.registerSimpleItem("pear", new Item.Properties().food(EmoFoods.PEAR));
    public static final DeferredItem<Item> CHERRY = ITEMS.registerSimpleItem("cherry", new Item.Properties().food(EmoFoods.CHERRY));
    public static final DeferredItem<Item> ORANGE = ITEMS.registerSimpleItem("orange", new Item.Properties().food(EmoFoods.ORANGE));

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
