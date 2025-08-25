package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.tree.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoFoliagePlacerType {
    private static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPE = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, EmoMain.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<FruitTreeFoliagePlacer>> FRUIT_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPE.register("fruit_tree_foliage_placer", () -> new FoliagePlacerType<>(FruitTreeFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<PineTreeFoliagePlacer>> PINE_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPE.register("pine_tree_foliage_placer", () -> new FoliagePlacerType<>(PineTreeFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<AtlasTreeFoliagePlacer>> ATLAS_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPE.register("atlas_tree_foliage_placer", () -> new FoliagePlacerType<>(AtlasTreeFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<DreamTreeFoliagePlacer>> DREAM_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPE.register("dream_tree_foliage_placer", () -> new FoliagePlacerType<>(DreamTreeFoliagePlacer.CODEC));
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<CocoTreeFoliagePlacer>> COCO_TREE_FOLIAGE_PLACER = FOLIAGE_PLACER_TYPE.register("coco_tree_foliage_placer", () -> new FoliagePlacerType<>(CocoTreeFoliagePlacer.CODEC));

    public static void init(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPE.register(eventBus);
    }
}
