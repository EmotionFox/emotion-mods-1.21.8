package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.mushroom.HugeBlueMushroomFeature;
import fr.emotion.emomodworld.world.mushroom.HugeGreenMushroomFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoFeature {
    private static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(Registries.FEATURE, EmoMain.MODID);

    public static final DeferredHolder<Feature<?>, Feature<HugeMushroomFeatureConfiguration>> HUGE_BLUE_MUSHROOM = FEATURE.register(
            "huge_blue_mushroom",
            () -> new HugeBlueMushroomFeature(HugeMushroomFeatureConfiguration.CODEC)
    );

    public static final DeferredHolder<Feature<?>, Feature<HugeMushroomFeatureConfiguration>> HUGE_GREEN_MUSHROOM = FEATURE.register(
            "huge_green_mushroom",
            () -> new HugeGreenMushroomFeature(HugeMushroomFeatureConfiguration.CODEC)
    );

    public static void init(IEventBus eventBus) {
        FEATURE.register(eventBus);
    }
}
