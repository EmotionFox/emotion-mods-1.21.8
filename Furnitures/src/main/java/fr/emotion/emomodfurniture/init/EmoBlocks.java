package fr.emotion.emomodfurniture.init;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.NightstandBlock;
import fr.emotion.emomodfurniture.blocks.StoolBlock;
import fr.emotion.emomodfurniture.blocks.TableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> TABLE_PEAR = addFurniture("table_pear", false, fr.emotion.emomodworld.init.EmoBlocks.PEAR_PLANKS);
    public static final DeferredBlock<Block> TABLE_ORANGE = addFurniture("table_orange", false, fr.emotion.emomodworld.init.EmoBlocks.ORANGE_PLANKS);
    public static final DeferredBlock<Block> TABLE_ATLAS = addFurniture("table_atlas", false, fr.emotion.emomodworld.init.EmoBlocks.ATLAS_PLANKS);
    public static final DeferredBlock<Block> TABLE_PINE = addFurniture("table_pine", false, fr.emotion.emomodworld.init.EmoBlocks.PINE_PLANKS);
    public static final DeferredBlock<Block> TABLE_COCO = addFurniture("table_coco", false, fr.emotion.emomodworld.init.EmoBlocks.COCO_PLANKS);
    public static final DeferredBlock<Block> TABLE_DREAM = addFurniture("table_dream", false, fr.emotion.emomodworld.init.EmoBlocks.DREAM_PLANKS);

    public static final DeferredBlock<Block> TABLE_OAK = addFurniture("table_oak", false, () -> Blocks.OAK_PLANKS);
    public static final DeferredBlock<Block> TABLE_SPRUCE = addFurniture("table_spruce", false, () -> Blocks.SPRUCE_PLANKS);
    public static final DeferredBlock<Block> TABLE_BIRCH = addFurniture("table_birch", false, () -> Blocks.BIRCH_PLANKS);
    public static final DeferredBlock<Block> TABLE_JUNGLE = addFurniture("table_jungle", false, () -> Blocks.JUNGLE_PLANKS);
    public static final DeferredBlock<Block> TABLE_ACACIA = addFurniture("table_acacia", false, () -> Blocks.ACACIA_PLANKS);
    public static final DeferredBlock<Block> TABLE_CHERRY = addFurniture("table_cherry", false, () -> Blocks.CHERRY_PLANKS);
    public static final DeferredBlock<Block> TABLE_DARK_OAK = addFurniture("table_dark_oak", false, () -> Blocks.DARK_OAK_PLANKS);
    public static final DeferredBlock<Block> TABLE_PALE_OAK = addFurniture("table_pale_oak", false, () -> Blocks.PALE_OAK_PLANKS);
    public static final DeferredBlock<Block> TABLE_MANGROVE = addFurniture("table_mangrove", false, () -> Blocks.MANGROVE_PLANKS);
    public static final DeferredBlock<Block> TABLE_BAMBOO = addFurniture("table_bamboo", false, () -> Blocks.BAMBOO_PLANKS);
    public static final DeferredBlock<Block> TABLE_CRIMSON = addFurniture("table_crimson", false, () -> Blocks.CRIMSON_PLANKS);
    public static final DeferredBlock<Block> TABLE_WARPED = addFurniture("table_warped", false, () -> Blocks.WARPED_PLANKS);

    public static final DeferredBlock<Block> NIGHTSTAND_PEAR = addBlock("nightstand_pear", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.PEAR_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_ORANGE = addBlock("nightstand_orange", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.ORANGE_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_ATLAS = addBlock("nightstand_atlas", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.ATLAS_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_PINE = addBlock("nightstand_pine", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.PINE_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_COCO = addBlock("nightstand_coco", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.COCO_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_DREAM = addBlock("nightstand_dream", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), fr.emotion.emomodworld.init.EmoBlocks.DREAM_PLANKS));

    public static final DeferredBlock<Block> NIGHTSTAND_OAK = addBlock("nightstand_oak", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_SPRUCE = addBlock("nightstand_spruce", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.SPRUCE_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_BIRCH = addBlock("nightstand_birch", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.BIRCH_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_JUNGLE = addBlock("nightstand_jungle", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.JUNGLE_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_ACACIA = addBlock("nightstand_acacia", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.ACACIA_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_CHERRY = addBlock("nightstand_cherry", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.CHERRY_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_DARK_OAK = addBlock("nightstand_dark_oak", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.DARK_OAK_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_PALE_OAK = addBlock("nightstand_pale_oak", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.PALE_OAK_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_MANGROVE = addBlock("nightstand_mangrove", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.MANGROVE_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_BAMBOO = addBlock("nightstand_bamboo", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.BAMBOO_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_CRIMSON = addBlock("nightstand_crimson", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.CRIMSON_PLANKS));
    public static final DeferredBlock<Block> NIGHTSTAND_WARPED = addBlock("nightstand_warped", props -> new NightstandBlock(props.mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 5.0F).sound(SoundType.WOOD), () -> Blocks.WARPED_PLANKS));

    public static final DeferredBlock<Block> TABLE_STONE = addFurniture("table_stone", true, () -> Blocks.STONE);
    public static final DeferredBlock<Block> TABLE_SMOOTH_STONE = addFurniture("table_smooth_stone", true, () -> Blocks.SMOOTH_STONE);
    public static final DeferredBlock<Block> TABLE_COBBLESTONE = addFurniture("table_cobblestone", true, () -> Blocks.COBBLESTONE);
    public static final DeferredBlock<Block> TABLE_MOSSY_COBBLESTONE = addFurniture("table_mossy_cobblestone", true, () -> Blocks.MOSSY_COBBLESTONE);
    public static final DeferredBlock<Block> TABLE_GRANITE = addFurniture("table_granite", true, () -> Blocks.GRANITE);
    public static final DeferredBlock<Block> TABLE_DIORITE = addFurniture("table_diorite", true, () -> Blocks.DIORITE);
    public static final DeferredBlock<Block> TABLE_ANDESITE = addFurniture("table_andesite", true, () -> Blocks.ANDESITE);
    public static final DeferredBlock<Block> TABLE_COBBLED_DEEPSLATE = addFurniture("table_cobbled_deepslate", true, () -> Blocks.COBBLED_DEEPSLATE);
    public static final DeferredBlock<Block> TABLE_POLISHED_DEEPSLATE = addFurniture("table_polished_deepslate", true, () -> Blocks.POLISHED_DEEPSLATE);
    public static final DeferredBlock<Block> TABLE_DEEPSLATE_TILE = addFurniture("table_deepslate_tile", true, () -> Blocks.DEEPSLATE_TILES);
    public static final DeferredBlock<Block> TABLE_TUFF = addFurniture("table_tuff", true, () -> Blocks.TUFF);
    public static final DeferredBlock<Block> TABLE_POLISHED_TUFF = addFurniture("table_polished_tuff", true, () -> Blocks.POLISHED_TUFF);
    public static final DeferredBlock<Block> TABLE_SANDSTONE = addFurniture("table_sandstone", true, () -> Blocks.SANDSTONE);
    public static final DeferredBlock<Block> TABLE_RED_SANDSTONE = addFurniture("table_red_sandstone", true, () -> Blocks.RED_SANDSTONE);
    public static final DeferredBlock<Block> TABLE_BLACKSTONE = addFurniture("table_blackstone", true, () -> Blocks.BLACKSTONE);
    public static final DeferredBlock<Block> TABLE_POLISHED_BLACKSTONE = addFurniture("table_polished_blackstone", true, () -> Blocks.POLISHED_BLACKSTONE);
    public static final DeferredBlock<Block> TABLE_STONE_BRICKS = addFurniture("table_stone_bricks", true, () -> Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> TABLE_MOSSY_STONE_BRICKS = addFurniture("table_mossy_stone_bricks", true, () -> Blocks.MOSSY_STONE_BRICKS);
    public static final DeferredBlock<Block> TABLE_POLISHED_BLACKSTONE_BRICKS = addFurniture("table_polished_blackstone_bricks", true, () -> Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final DeferredBlock<Block> TABLE_END_STONE_BRICKS = addFurniture("table_end_stone_bricks", true, () -> Blocks.END_STONE_BRICKS);
    public static final DeferredBlock<Block> TABLE_DEEPSLATE_BRICKS = addFurniture("table_deepslate_bricks", true, () -> Blocks.DEEPSLATE_BRICKS);
    public static final DeferredBlock<Block> TABLE_TUFF_BRICKS = addFurniture("table_tuff_bricks", true, () -> Blocks.TUFF_BRICKS);
    public static final DeferredBlock<Block> TABLE_BRICKS = addFurniture("table_bricks", true, () -> Blocks.BRICKS);
    public static final DeferredBlock<Block> TABLE_MUD_BRICKS = addFurniture("table_mud_bricks", true, () -> Blocks.MUD_BRICKS);
    public static final DeferredBlock<Block> TABLE_RESIN_BRICKS = addFurniture("table_resin_bricks", true, () -> Blocks.RESIN_BRICKS);
    public static final DeferredBlock<Block> TABLE_PRISMARINE = addFurniture("table_prismarine", true, () -> Blocks.PRISMARINE);
    public static final DeferredBlock<Block> TABLE_NETHER_BRICKS = addFurniture("table_nether_bricks", true, () -> Blocks.NETHER_BRICKS);
    public static final DeferredBlock<Block> TABLE_RED_NETHER_BRICKS = addFurniture("table_red_nether_bricks", true, () -> Blocks.RED_NETHER_BRICKS);

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

    private static DeferredBlock<Block> addFurniture(String name, boolean isStone, Supplier<Block> texture) {
        addBlock(name.replace("table", "stool"), props -> new StoolBlock(isStone, props.mapColor(isStone ? MapColor.STONE:MapColor.WOOD).instrument(isStone ? NoteBlockInstrument.BASEDRUM:NoteBlockInstrument.BASS).strength(2.0F, isStone ? 10.0F:5.0F).sound(isStone ? SoundType.STONE:SoundType.WOOD), texture));
        return addBlock(name, props -> new TableBlock(isStone, props.mapColor(isStone ? MapColor.STONE:MapColor.WOOD).instrument(isStone ? NoteBlockInstrument.BASEDRUM:NoteBlockInstrument.BASS).strength(2.0F, isStone ? 10.0F:5.0F).sound(isStone ? SoundType.STONE:SoundType.WOOD), texture));
    }
}
