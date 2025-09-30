package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.items.ButterflyItem;
import fr.emotion.emomodworld.items.ButterflyNetItem;
import fr.emotion.emomodworld.items.EmoFoods;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
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

    public static final DeferredItem<Item> BUTTERFLY_NET_WHITE = ITEMS.registerItem("butterfly_net_white", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_ORANGE = ITEMS.registerItem("butterfly_net_orange", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_MAGENTA = ITEMS.registerItem("butterfly_net_magenta", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_LIGHT_BLUE = ITEMS.registerItem("butterfly_net_light_blue", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_YELLOW = ITEMS.registerItem("butterfly_net_yellow", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_LIME = ITEMS.registerItem("butterfly_net_lime", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_PINK = ITEMS.registerItem("butterfly_net_pink", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_GRAY = ITEMS.registerItem("butterfly_net_gray", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_LIGHT_GRAY = ITEMS.registerItem("butterfly_net_light_gray", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_CYAN = ITEMS.registerItem("butterfly_net_cyan", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_PURPLE = ITEMS.registerItem("butterfly_net_purple", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_BLUE = ITEMS.registerItem("butterfly_net_blue", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_BROWN = ITEMS.registerItem("butterfly_net_brown", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_GREEN = ITEMS.registerItem("butterfly_net_green", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_RED = ITEMS.registerItem("butterfly_net_red", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));
    public static final DeferredItem<Item> BUTTERFLY_NET_BLACK = ITEMS.registerItem("butterfly_net_black", props -> new ButterflyNetItem(props.stacksTo(1).durability(10)));

    public static final DeferredItem<Item> BUTTERFLY_BLUE = ITEMS.registerItem("butterfly_blue", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.BLUE));
    public static final DeferredItem<Item> BUTTERFLY_BROWN = ITEMS.registerItem("butterfly_brown", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.BROWN));
    public static final DeferredItem<Item> BUTTERFLY_GREEN = ITEMS.registerItem("butterfly_green", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.GREEN));
    public static final DeferredItem<Item> BUTTERFLY_PINK = ITEMS.registerItem("butterfly_pink", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.PINK));
    public static final DeferredItem<Item> BUTTERFLY_RED = ITEMS.registerItem("butterfly_red", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.RED));
    public static final DeferredItem<Item> BUTTERFLY_YELLOW = ITEMS.registerItem("butterfly_yellow", props -> new ButterflyItem(props, Butterfly.ButterflyVariant.YELLOW));

    public static final DeferredItem<Item> HALF_HAM = ITEMS.registerSimpleItem("half_ham", new Item.Properties().food(EmoFoods.HAM).usingConvertsTo(Items.BONE));
    public static final DeferredItem<Item> HAM = ITEMS.registerItem("ham", props -> new Item(props.food(EmoFoods.HAM).usingConvertsTo(HALF_HAM.get())));

    public static final DeferredItem<Item> COOKED_HALF_HAM = ITEMS.registerSimpleItem("half_cooked_ham", new Item.Properties().food(EmoFoods.COOKED_HAM).usingConvertsTo(Items.BONE));
    public static final DeferredItem<Item> COOKED_HAM = ITEMS.registerItem("cooked_ham", props -> new Item(props.food(EmoFoods.COOKED_HAM).usingConvertsTo(COOKED_HALF_HAM.get())));

    public static final DeferredItem<Item> BEETLE_SPAWN_EGG = ITEMS.registerItem("beetle_spawn_egg", props -> new SpawnEggItem(EmoEntityType.BEETLE.get(), props));
    public static final DeferredItem<Item> BOAR_SPAWN_EGG = ITEMS.registerItem("boar_spawn_egg", props -> new SpawnEggItem(EmoEntityType.BOAR.get(), props));
    public static final DeferredItem<Item> MOUSE_SPAWN_EGG = ITEMS.registerItem("mouse_spawn_egg", props -> new SpawnEggItem(EmoEntityType.MOUSE.get(), props));
    public static final DeferredItem<Item> JUMPING_SPIDER_SPAWN_EGG = ITEMS.registerItem("jumping_spider_spawn_egg", props -> new SpawnEggItem(EmoEntityType.JUMPING_SPIDER.get(), props));

    public static void init(IEventBus event) {
        ITEMS.register(event);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
