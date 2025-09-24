package fr.emotion.emomodworld.items;

import net.minecraft.world.food.FoodProperties;

public class EmoFoods {
    public static final FoodProperties BLACKCURRANT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties DREAMCURRANT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();

    public static final FoodProperties PEAR = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodProperties CHERRY = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodProperties ORANGE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();

    public static final FoodProperties COOKED_HAM = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
    public static final FoodProperties HAM = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
}
