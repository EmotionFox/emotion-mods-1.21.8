package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> CAKE_CHOCOLATE = BLOCKS.registerBlock("cake_chocolate", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CAKE_FRUIT = BLOCKS.registerBlock("cake_fruit", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CAKE_TOFFEE = BLOCKS.registerBlock("cake_toffee", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CAKE_STRAWBERRY = BLOCKS.registerBlock("cake_strawberry", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static DeferredRegister.Blocks getBlocks() {
        return BLOCKS;
    }
}
