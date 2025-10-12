package fr.emotion.emomoddimension.init;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.blocks.DreamCatcher;
import fr.emotion.emomoddimension.blocks.DreamGrassBlock;
import fr.emotion.emomoddimension.blocks.DreamPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final DeferredBlock<Block> DREAM_SHORT_GRASS = addBlock("dream_short_grass", props -> new TallGrassBlock(props.mapColor(MapColor.PLANT).replaceable().noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(fr.emotion.emomodworld.EmoMain.MODID, "flower_tallgrass")))) {
        @Override
        public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state) {
            return getEmoGrownBlock(state).defaultBlockState().canSurvive(levelReader, pos) && levelReader.isEmptyBlock(pos.above());
        }

        @Override
        public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
            DoublePlantBlock.placeAt(level, getEmoGrownBlock(state).defaultBlockState(), pos, 2);
        }

        private static DoublePlantBlock getEmoGrownBlock(BlockState state) {
            return (DoublePlantBlock) DREAM_TALL_GRASS.get();
        }
    });

    public static final DeferredBlock<Block> DREAM_TALL_GRASS = addBlock("dream_tall_grass", props -> new DoublePlantBlock(props.mapColor(MapColor.PLANT).replaceable().noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)), DoubleHighBlockItem.class);

    public static final DeferredBlock<Block> DREAM_PORTAL = BLOCKS.registerBlock("dream_portal", props -> new DreamPortalBlock(props.noCollision().strength(-1.0F).sound(SoundType.GLASS).lightLevel(state -> 11).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> DREAM_STONE = addBlock("dream_stone", props -> new Block(props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final DeferredBlock<Block> DREAM_COBBLESTONE = addBlock("dream_cobblestone", props -> new Block(props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F)));
    public static final DeferredBlock<Block> DREAM_GRASS_BLOCK = addBlock("dream_grass_block", props -> new DreamGrassBlock(props.mapColor(MapColor.GRASS).randomTicks().strength(1.5F, 6.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DREAM_CATCHER = addBlock("dream_catcher", props -> new DreamCatcher(props.mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

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
