package fr.emotion.emomoddimension.init;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.blocks.DreamPortalBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Constructor;
import java.util.function.Function;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> DREAM_PORTAL = BLOCKS.registerBlock("dream_portal", props -> new DreamPortalBlock(props.noCollission().strength(-1.0F).sound(SoundType.GLASS).lightLevel(state -> 11).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> DREAM_STONE = addBlock("dream_stone", props -> new Block(props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> DREAM_GRASS_BLOCK = addBlock("dream_grass_block", props -> new GrassBlock(props.mapColor(MapColor.GRASS).randomTicks().strength(1.5F, 6.0F).sound(SoundType.STONE)));

    public static void init(IEventBus event) {
        BLOCKS.register(event);
    }

    public static DeferredRegister.Blocks getBlocks() {
        return BLOCKS;
    }

    private static <T extends net.minecraft.world.level.block.Block> DeferredBlock<T> addBlockTest(String name, Function<BlockBehaviour.Properties, T> func) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func, BlockBehaviour.Properties.of());
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends net.minecraft.world.level.block.Block> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends net.minecraft.world.level.block.Block, I extends BlockItem> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func, Class<I> blockItemClass) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock, blockItemClass);
        return returnBlock;
    }

    private static <T extends net.minecraft.world.level.block.Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        EmoItems.getItems().registerSimpleBlockItem(name, block);
    }

    private static <T extends net.minecraft.world.level.block.Block, I extends BlockItem> void registerBlockItem(String name, DeferredBlock<T> block, Class<I> blockItemClass) {
        EmoItems.getItems().register(name, key -> {
            Item.Properties properties = new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, key))
                    .useBlockDescriptionPrefix();

            try {
                Constructor<I> constructor = blockItemClass.getConstructor(Block.class, Item.Properties.class);
                return constructor.newInstance(block.get(), properties);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Could not instanciate BlockItem class: " + blockItemClass.getName(), e);
            }
        });
    }
}
