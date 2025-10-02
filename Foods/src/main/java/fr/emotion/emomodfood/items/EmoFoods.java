package fr.emotion.emomodfood.items;

import net.minecraft.world.food.FoodProperties;

public class EmoFoods {
    public static final FoodProperties CHOCOLATE_STRAWBERRY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).build();

    public static final FoodProperties SLICE_PLAIN = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).build();
    public static final FoodProperties SLICE = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build();
    public static final FoodProperties SLICE_SPECIAL = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7F).build();

    public static final FoodProperties JUICE_PEAR = juice(4).build();
    public static final FoodProperties JUICE_CHERRY = juice(3).build();
    public static final FoodProperties JUICE_ORANGE = juice(5).build();
    public static final FoodProperties JUICE_APPLE = juice(4).build();
    public static final FoodProperties JUICE_TOMATO = juice(5).build();

    public static final FoodProperties PIE_PEAR = pieAndMuffin(0.4F).build();
    public static final FoodProperties PIE_CHERRY = pieAndMuffin(0.3F).build();
    public static final FoodProperties PIE_ORANGE = pieAndMuffin(0.5F).build();
    public static final FoodProperties PIE_APPLE = pieAndMuffin(0.4F).build();
    public static final FoodProperties PIE_MELON = pieAndMuffin(0.3F).build();

    public static final FoodProperties MUFFIN_PEAR = pieAndMuffin(0.3F).build();
    public static final FoodProperties MUFFIN_CHERRY = pieAndMuffin(0.2F).build();
    public static final FoodProperties MUFFIN_ORANGE = pieAndMuffin(0.4F).build();
    public static final FoodProperties MUFFIN_APPLE = pieAndMuffin(0.3F).build();
    public static final FoodProperties MUFFIN_BLACKCURRANT = pieAndMuffin(0.2F).build();
    public static final FoodProperties MUFFIN_BLUEBERRY = pieAndMuffin(0.2F).build();
    public static final FoodProperties MUFFIN_DREAMCURRANT = pieAndMuffin(0.5F).build();
    public static final FoodProperties MUFFIN_STRAWBERRY = pieAndMuffin(0.2F).build();
    public static final FoodProperties MUFFIN_SWEETBERRY = pieAndMuffin(0.2F).build();

    public static final FoodProperties TOFFEE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build();
    public static final FoodProperties TOFFEE_APPLE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build();

    private static FoodProperties.Builder juice(int nutrition) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(0.6F);
    }

    private static FoodProperties.Builder pieAndMuffin(float saturation) {
        return new FoodProperties.Builder().nutrition(8).saturationModifier(saturation);
    }
}
