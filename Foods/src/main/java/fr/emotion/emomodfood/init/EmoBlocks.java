package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.HoleCandleCakeBlock;
import fr.emotion.emomodfood.blocks.PotBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.ToIntFunction;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> CAKE_CHOCOLATE = BLOCKS.registerBlock("cake_chocolate", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> WHITE_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("white_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> ORANGE_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("orange_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> MAGENTA_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("magenta_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_BLUE_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("light_blue_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> YELLOW_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("yellow_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIME_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("lime_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PINK_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("pink_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GRAY_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("gray_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_GRAY_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("light_gray_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> CYAN_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("cyan_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PURPLE_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("purple_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLUE_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("blue_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BROWN_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("brown_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GREEN_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("green_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> RED_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("red_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLACK_CANDLE_CAKE_CHOCOLATE = BLOCKS.registerBlock("black_candle_cake_chocolate", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));

    public static final DeferredBlock<Block> CAKE_FRUIT = BLOCKS.registerBlock("cake_fruit", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> WHITE_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("white_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> ORANGE_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("orange_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> MAGENTA_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("magenta_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_BLUE_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("light_blue_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> YELLOW_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("yellow_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIME_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("lime_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PINK_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("pink_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GRAY_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("gray_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_GRAY_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("light_gray_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> CYAN_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("cyan_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PURPLE_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("purple_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLUE_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("blue_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BROWN_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("brown_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GREEN_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("green_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> RED_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("red_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLACK_CANDLE_CAKE_FRUIT = BLOCKS.registerBlock("black_candle_cake_fruit", props -> new HoleCandleCakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));

    public static final DeferredBlock<Block> CAKE_TOFFEE = BLOCKS.registerBlock("cake_toffee", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> WHITE_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("white_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> ORANGE_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("orange_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> MAGENTA_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("magenta_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_BLUE_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("light_blue_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> YELLOW_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("yellow_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIME_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("lime_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PINK_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("pink_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GRAY_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("gray_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_GRAY_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("light_gray_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> CYAN_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("cyan_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PURPLE_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("purple_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLUE_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("blue_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BROWN_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("brown_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GREEN_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("green_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> RED_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("red_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLACK_CANDLE_CAKE_TOFFEE = BLOCKS.registerBlock("black_candle_cake_toffee", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));

    public static final DeferredBlock<Block> CAKE_STRAWBERRY = BLOCKS.registerBlock("cake_strawberry", props -> new CakeBlock(props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> WHITE_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("white_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> ORANGE_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("orange_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> MAGENTA_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("magenta_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_BLUE_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("light_blue_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> YELLOW_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("yellow_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIME_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("lime_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PINK_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("pink_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GRAY_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("gray_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> LIGHT_GRAY_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("light_gray_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> CYAN_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("cyan_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> PURPLE_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("purple_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLUE_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("blue_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BROWN_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("brown_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> GREEN_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("green_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> RED_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("red_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));
    public static final DeferredBlock<Block> BLACK_CANDLE_CAKE_STRAWBERRY = BLOCKS.registerBlock("black_candle_cake_strawberry", props -> new CandleCakeBlock(Blocks.CANDLE, props.forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel(litBlockEmission(3))));

    public static final DeferredBlock<Block> TOMATOES = BLOCKS.registerBlock("tomatoes", props -> new CropBlock(props.mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)){
        @Override
        protected ItemLike getBaseSeedId() {
            return EmoItems.TOMATO.get();
        }

        @Override
        protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return Block.column(16.0, 0.0, 15);
        }
    });

    public static final DeferredBlock<Block> POT = BLOCKS.registerBlock("pot", props -> new PotBlock(props.mapColor(MapColor.WOOD).sound(SoundType.GLASS)));

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static DeferredRegister.Blocks getBlocks() {
        return BLOCKS;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return p_50763_ -> p_50763_.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
