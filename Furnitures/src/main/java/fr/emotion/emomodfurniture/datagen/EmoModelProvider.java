package fr.emotion.emomodfurniture.datagen;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.NightstandBlock;
import fr.emotion.emomodfurniture.blocks.StoolBlock;
import fr.emotion.emomodfurniture.blocks.TableBlock;
import fr.emotion.emomodfurniture.init.EmoBlocks;
import fr.emotion.emomodfurniture.models.EmoModelTemplate;
import fr.emotion.emomodfurniture.models.EmoTextureMapping;
import fr.emotion.emomodfurniture.models.EmoTextureSlot;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        for (DeferredHolder<Block, ? extends Block> block : EmoBlocks.getBlocks().getEntries()) {
            if (block.get() instanceof TableBlock table) {
                createTableBlock(blockModels, table.isStone, table, table.texture.get());
            } else if (block.get() instanceof StoolBlock stool) {
                createStoolBlock(blockModels, stool.isStone, stool, stool.texture.get());
            } else if(block.get() instanceof NightstandBlock nightstand){
                createNightstand(blockModels, nightstand, nightstand.texture.get());
            }
        }
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
                                                            blockModels.createSuffixedVariant(table, flag ? "":"_" + dir, template, rl -> EmoTextureMapping.furniture(!isStone ? EmoTextureSlot.WOOD:EmoTextureSlot.STONE, textureBlock))
                                                    );
                                                }
                                        )
                        )
        );
    }

    protected void createStoolBlock(BlockModelGenerators blockModels, boolean isStone, Block stool, Block texture) {
        ModelTemplate template = isStone ? EmoModelTemplate.STONE_STOOL:EmoModelTemplate.WOOD_STOOL;
        MultiVariant variant = BlockModelGenerators.plainVariant(template.create(stool, EmoTextureMapping.furniture(isStone ? EmoTextureSlot.STONE:EmoTextureSlot.WOOD, texture), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(stool, variant));
    }

    protected void createNightstand(BlockModelGenerators blockModels, Block nightstand, Block texture) {
        MultiVariant variant = BlockModelGenerators.plainVariant(EmoModelTemplate.NIGHT_STAND.create(nightstand, EmoTextureMapping.furniture(EmoTextureSlot.WOOD, texture), blockModels.modelOutput));
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(nightstand, variant).with(BlockModelGenerators.ROTATION_HORIZONTAL_FACING));
    }
}
