package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.items.EmoFoods;
import fr.emotion.emomodfood.items.PotBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoItems {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmoMain.MODID);

    public static final DeferredItem<Item> SLICE_BREAD = ITEMS.registerItem("slice_bread", props -> new Item(props.food(EmoFoods.SLICE_PLAIN)));
    public static final DeferredItem<Item> SLICE_PEAR = ITEMS.registerItem("slice_pear", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_CHERRY = ITEMS.registerItem("slice_cherry", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_ORANGE = ITEMS.registerItem("slice_orange", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_APPLE = ITEMS.registerItem("slice_apple", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_BLACKCURRANT = ITEMS.registerItem("slice_blackcurrant", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_BLUEBERRY = ITEMS.registerItem("slice_blueberry", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_DREAMCURRANT = ITEMS.registerItem("slice_dreamcurrant", props -> new Item(props.food(EmoFoods.SLICE_SPECIAL)));
    public static final DeferredItem<Item> SLICE_STRAWBERRY = ITEMS.registerItem("slice_strawberry", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_SWEETBERRY = ITEMS.registerItem("slice_sweetberry", props -> new Item(props.food(EmoFoods.SLICE)));
    public static final DeferredItem<Item> SLICE_CHOCOLATE = ITEMS.registerItem("slice_chocolate", props -> new Item(props.food(EmoFoods.SLICE)));

    public static final DeferredItem<Item> CAKE_CHOCOLATE = ITEMS.registerItem("cake_chocolate", props -> new BlockItem(EmoBlocks.CAKE_CHOCOLATE.get(), props.stacksTo(1)));
    public static final DeferredItem<Item> CAKE_FRUIT = ITEMS.registerItem("cake_fruit", props -> new BlockItem(EmoBlocks.CAKE_FRUIT.get(), props.stacksTo(1)));
    public static final DeferredItem<Item> CAKE_TOFFEE = ITEMS.registerItem("cake_toffee", props -> new BlockItem(EmoBlocks.CAKE_TOFFEE.get(), props.stacksTo(1)));
    public static final DeferredItem<Item> CAKE_STRAWBERRY = ITEMS.registerItem("cake_strawberry", props -> new BlockItem(EmoBlocks.CAKE_STRAWBERRY.get(), props.stacksTo(1)));

    public static final DeferredItem<Item> GLASS_BOWL = ITEMS.registerSimpleItem("glass_bowl");
    public static final DeferredItem<Item> JUICE_PEAR = ITEMS.registerItem("juice_pear", props -> new Item(props.food(EmoFoods.JUICE_PEAR)));
    public static final DeferredItem<Item> JUICE_CHERRY = ITEMS.registerItem("juice_cherry", props -> new Item(props.food(EmoFoods.JUICE_CHERRY)));
    public static final DeferredItem<Item> JUICE_ORANGE = ITEMS.registerItem("juice_orange", props -> new Item(props.food(EmoFoods.JUICE_ORANGE)));
    public static final DeferredItem<Item> JUICE_TOMATO = ITEMS.registerItem("juice_tomato", props -> new Item(props.food(EmoFoods.JUICE_TOMATO)));
    public static final DeferredItem<Item> JUICE_APPLE = ITEMS.registerItem("juice_apple", props -> new Item(props.food(EmoFoods.JUICE_APPLE)));

    public static final DeferredItem<Item> PIE_PEAR = ITEMS.registerItem("pie_pear", props -> new Item(props.food(EmoFoods.PIE_PEAR)));
    public static final DeferredItem<Item> PIE_CHERRY = ITEMS.registerItem("pie_cherry", props -> new Item(props.food(EmoFoods.PIE_CHERRY)));
    public static final DeferredItem<Item> PIE_ORANGE = ITEMS.registerItem("pie_orange", props -> new Item(props.food(EmoFoods.PIE_ORANGE)));
    public static final DeferredItem<Item> PIE_APPLE = ITEMS.registerItem("pie_apple", props -> new Item(props.food(EmoFoods.PIE_APPLE)));
    public static final DeferredItem<Item> PIE_MELON = ITEMS.registerItem("pie_melon", props -> new Item(props.food(EmoFoods.PIE_MELON)));

    public static final DeferredItem<Item> MUFFIN_PEAR = ITEMS.registerItem("muffin_pear", props -> new Item(props.food(EmoFoods.MUFFIN_PEAR)));
    public static final DeferredItem<Item> MUFFIN_CHERRY = ITEMS.registerItem("muffin_cherry", props -> new Item(props.food(EmoFoods.MUFFIN_CHERRY)));
    public static final DeferredItem<Item> MUFFIN_ORANGE = ITEMS.registerItem("muffin_orange", props -> new Item(props.food(EmoFoods.MUFFIN_ORANGE)));
    public static final DeferredItem<Item> MUFFIN_APPLE = ITEMS.registerItem("muffin_apple", props -> new Item(props.food(EmoFoods.MUFFIN_APPLE)));
    public static final DeferredItem<Item> MUFFIN_BLACKCURRANT = ITEMS.registerItem("muffin_blackcurrant", props -> new Item(props.food(EmoFoods.MUFFIN_BLACKCURRANT)));
    public static final DeferredItem<Item> MUFFIN_BLUEBERRY = ITEMS.registerItem("muffin_blueberry", props -> new Item(props.food(EmoFoods.MUFFIN_BLUEBERRY)));
    public static final DeferredItem<Item> MUFFIN_DREAMCURRANT = ITEMS.registerItem("muffin_dreamcurrant", props -> new Item(props.food(EmoFoods.MUFFIN_DREAMCURRANT)));
    public static final DeferredItem<Item> MUFFIN_STRAWBERRY = ITEMS.registerItem("muffin_strawberry", props -> new Item(props.food(EmoFoods.MUFFIN_STRAWBERRY)));
    public static final DeferredItem<Item> MUFFIN_SWEETBERRY = ITEMS.registerItem("muffin_sweetberry", props -> new Item(props.food(EmoFoods.MUFFIN_SWEETBERRY)));

    public static final DeferredItem<Item> TOFFEE = ITEMS.registerItem("toffee", props -> new Item(props.food(EmoFoods.TOFFEE)));
    public static final DeferredItem<Item> TOFFEE_APPLE = ITEMS.registerItem("toffee_apple", props -> new Item(props.food(EmoFoods.TOFFEE_APPLE)));

    public static final DeferredItem<Item> TOMATO = ITEMS.registerItem("tomato", props -> new BlockItem(EmoBlocks.TOMATOES.get(), props.useItemDescriptionPrefix().food(EmoFoods.TOMATO)));

    public static final DeferredItem<Item> POT = ITEMS.registerItem("pot", props -> new PotBlockItem(EmoBlocks.POT.get(), props));

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static DeferredRegister.Items getItems() {
        return ITEMS;
    }
}
