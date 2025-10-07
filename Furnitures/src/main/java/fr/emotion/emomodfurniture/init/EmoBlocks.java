package fr.emotion.emomodfurniture.init;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.TableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> TABLE_PEAR = addBlock("table_pear", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_ORANGE = addBlock("table_orange", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_ATLAS = addBlock("table_atlas", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_PINE = addBlock("table_pine", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_COCO = addBlock("table_coco", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_DREAM = addBlock("table_dream", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> TABLE_OAK = addBlock("table_oak", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_SPRUCE = addBlock("table_spruce", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_BIRCH = addBlock("table_birch", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_JUNGLE = addBlock("table_jungle", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_ACACIA = addBlock("table_acacia", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_CHERRY = addBlock("table_cherry", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_DARK_OAK = addBlock("table_dark_oak", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_PALE_OAK = addBlock("table_pale_oak", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_MANGROVE = addBlock("table_mangrove", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_BAMBOO = addBlock("table_bamboo", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_CRIMSON = addBlock("table_crimson", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> TABLE_WARPED = addBlock("table_warped", props -> new TableBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> TABLE_STONE = addBlock("table_stone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_SMOOTH_STONE = addBlock("table_smooth_stone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_COBBLESTONE = addBlock("table_cobblestone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_MOSSY_COBBLESTONE = addBlock("table_mossy_cobblestone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_GRANITE = addBlock("table_granite", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_DIORITE = addBlock("table_diorite", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_ANDESITE = addBlock("table_andesite", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_COBBLED_DEEPSLATE = addBlock("table_cobbled_deepslate", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_POLISHED_DEEPSLATE = addBlock("table_polished_deepslate", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_DEEPSLATE_TILE = addBlock("table_deepslate_tile", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_TUFF = addBlock("table_tuff", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_POLISHED_TUFF = addBlock("table_polished_tuff", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_SANDSTONE = addBlock("table_sandstone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_RED_SANDSTONE = addBlock("table_red_sandstone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_BLACKSTONE = addBlock("table_blackstone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_POLISHED_BLACKSTONE = addBlock("table_polished_blackstone", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_STONE_BRICKS = addBlock("table_stone_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_MOSSY_STONE_BRICKS = addBlock("table_mossy_stone_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_POLISHED_BLACKSTONE_BRICKS = addBlock("table_polished_blackstone_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_END_STONE_BRICKS = addBlock("table_end_stone_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_DEEPSLATE_BRICKS = addBlock("table_deepslate_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_TUFF_BRICKS = addBlock("table_tuff_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_BRICKS = addBlock("table_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_MUD_BRICKS = addBlock("table_mud_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_RESIN_BRICKS = addBlock("table_resin_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_PRISMARINE = addBlock("table_prismarine", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_NETHER_BRICKS = addBlock("table_nether_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TABLE_RED_NETHER_BRICKS = addBlock("table_red_nether_bricks", props -> new TableBlock(true, props.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).sound(SoundType.STONE)));

    public static void init(IEventBus event) {
        BLOCKS.register(event);
    }

    public static DeferredRegister.Blocks getBlocks() {
        return BLOCKS;
    }

    private static <T extends net.minecraft.world.level.block.Block> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        EmoItems.getItems().registerSimpleBlockItem(name, block);
    }
}
