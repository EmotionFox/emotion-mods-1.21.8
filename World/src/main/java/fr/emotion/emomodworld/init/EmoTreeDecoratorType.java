package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.world.tree.SpiderNestDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoTreeDecoratorType {
    private static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPE = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, EmoMain.MODID);

    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<SpiderNestDecorator>> SPIDER_NEST = TREE_DECORATOR_TYPE.register("spider_nest", () -> new TreeDecoratorType<>(SpiderNestDecorator.CODEC));

    public static void init(IEventBus eventBus) {
        TREE_DECORATOR_TYPE.register(eventBus);
    }
}
