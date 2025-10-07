package fr.emotion.emomodfurniture.datagen;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.TableBlock;
import fr.emotion.emomodfurniture.init.EmoBlocks;
import fr.emotion.emomodfurniture.models.EmoModelTemplate;
import fr.emotion.emomodfurniture.models.EmoTextureMapping;
import fr.emotion.emomodfurniture.models.EmoTextureSlot;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        createTableBlock(blockModels, EmoBlocks.TABLE_PEAR.get(), fr.emotion.emomodworld.init.EmoBlocks.PEAR_PLANKS.get());
        createTableBlock(blockModels, EmoBlocks.TABLE_ORANGE.get(), fr.emotion.emomodworld.init.EmoBlocks.ORANGE_PLANKS.get());
        createTableBlock(blockModels, EmoBlocks.TABLE_ATLAS.get(), fr.emotion.emomodworld.init.EmoBlocks.ATLAS_PLANKS.get());
        createTableBlock(blockModels, EmoBlocks.TABLE_PINE.get(), fr.emotion.emomodworld.init.EmoBlocks.PINE_PLANKS.get());
        createTableBlock(blockModels, EmoBlocks.TABLE_COCO.get(), fr.emotion.emomodworld.init.EmoBlocks.COCO_PLANKS.get());
        createTableBlock(blockModels, EmoBlocks.TABLE_DREAM.get(), fr.emotion.emomodworld.init.EmoBlocks.DREAM_PLANKS.get());

        createTableBlock(blockModels, EmoBlocks.TABLE_OAK.get(), Blocks.OAK_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_SPRUCE.get(), Blocks.SPRUCE_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_BIRCH.get(), Blocks.BIRCH_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_JUNGLE.get(), Blocks.JUNGLE_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_ACACIA.get(), Blocks.ACACIA_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_CHERRY.get(), Blocks.CHERRY_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_DARK_OAK.get(), Blocks.DARK_OAK_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_PALE_OAK.get(), Blocks.PALE_OAK_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_MANGROVE.get(), Blocks.MANGROVE_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_BAMBOO.get(), Blocks.BAMBOO_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_CRIMSON.get(), Blocks.CRIMSON_PLANKS);
        createTableBlock(blockModels, EmoBlocks.TABLE_WARPED.get(), Blocks.WARPED_PLANKS);

        createTableBlock(blockModels, true, EmoBlocks.TABLE_STONE.get(), Blocks.STONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_SMOOTH_STONE.get(), Blocks.SMOOTH_STONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_COBBLESTONE.get(), Blocks.COBBLESTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_MOSSY_COBBLESTONE.get(), Blocks.MOSSY_COBBLESTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_GRANITE.get(), Blocks.GRANITE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_DIORITE.get(), Blocks.DIORITE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_ANDESITE.get(), Blocks.ANDESITE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_COBBLED_DEEPSLATE.get(), Blocks.COBBLED_DEEPSLATE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_POLISHED_DEEPSLATE.get(), Blocks.POLISHED_DEEPSLATE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_DEEPSLATE_TILE.get(), Blocks.DEEPSLATE_TILES);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_TUFF.get(), Blocks.TUFF);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_POLISHED_TUFF.get(), Blocks.POLISHED_TUFF);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_SANDSTONE.get(), Blocks.SANDSTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_RED_SANDSTONE.get(), Blocks.RED_SANDSTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_BLACKSTONE.get(), Blocks.BLACKSTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_POLISHED_BLACKSTONE.get(), Blocks.POLISHED_BLACKSTONE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_STONE_BRICKS.get(), Blocks.STONE_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_MOSSY_STONE_BRICKS.get(), Blocks.MOSSY_STONE_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_POLISHED_BLACKSTONE_BRICKS.get(), Blocks.POLISHED_BLACKSTONE_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_END_STONE_BRICKS.get(), Blocks.END_STONE_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_DEEPSLATE_BRICKS.get(), Blocks.DEEPSLATE_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_TUFF_BRICKS.get(), Blocks.TUFF_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_BRICKS.get(), Blocks.BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_MUD_BRICKS.get(), Blocks.MUD_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_RESIN_BRICKS.get(), Blocks.RESIN_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_PRISMARINE.get(), Blocks.PRISMARINE);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_NETHER_BRICKS.get(), Blocks.NETHER_BRICKS);
        createTableBlock(blockModels, true, EmoBlocks.TABLE_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS);
    }

    protected void createTableBlock(BlockModelGenerators blockModels, Block table, Block textureBlock) {
        createTableBlock(blockModels, false, table, textureBlock);
    }

    protected void createTableBlock(BlockModelGenerators blockModels, boolean isStone, Block table, Block textureBlock) {
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(table)
                        .with(
                                PropertyDispatch.initial(TableBlock.DIR)
                                        .generate(
                                                tableDir -> {
                                                    String dir = tableDir.getSerializedName();
                                                    boolean flag = dir.equals(TableBlock.TableDir.NORMAL.getSerializedName());

                                                    ModelTemplate template;

                                                    if (!isStone) {
                                                        template = switch (tableDir) {
                                                            case STRAIGHT_NS -> EmoModelTemplate.WOOD_TABLE_NS;
                                                            case STRAIGHT_EW -> EmoModelTemplate.WOOD_TABLE_EW;
                                                            case FULL -> EmoModelTemplate.WOOD_TABLE_FULL;
                                                            default -> EmoModelTemplate.WOOD_TABLE;
                                                        };
                                                    } else {
                                                        template = switch (tableDir) {
                                                            case STRAIGHT_NS -> EmoModelTemplate.STONE_TABLE_NS;
                                                            case STRAIGHT_EW -> EmoModelTemplate.STONE_TABLE_EW;
                                                            case FULL -> EmoModelTemplate.STONE_TABLE_FULL;
                                                            default -> EmoModelTemplate.STONE_TABLE;
                                                        };
                                                    }

                                                    return BlockModelGenerators.plainVariant(
                                                            blockModels.createSuffixedVariant(table, flag ? "":"_" + dir, template, rl -> EmoTextureMapping.table(!isStone ? EmoTextureSlot.WOOD:EmoTextureSlot.STONE, textureBlock))
                                                    );
                                                }
                                        )
                        )
        );
    }
}
