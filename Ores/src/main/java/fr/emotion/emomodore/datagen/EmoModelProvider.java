package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.EmoMain;
import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoItems;
import fr.emotion.emomodore.item.PhaseValue;
import fr.emotion.emomodore.tags.CustomModelTemplate;
import fr.emotion.emomodore.tags.CustomTextureSlot;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, EmoMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Items
        itemModels.generateFlatItem(EmoItems.FOSSIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.FOSSIL_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.FOSSIL_SHOVEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.FOSSIL_PICKAXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.FOSSIL_AXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.FOSSIL_HOE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PURPURA_SHARD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PURPURA_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_SHOVEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_PICKAXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_AXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_HOE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PURPURA_LUME_SWORD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.PURPURA_NETHERITE_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_DIAMOND_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_EMERALD_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_GOLD_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_IRON_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.PURPURA_COPPER_SWORD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.VIRIDIS_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.VIRIDIS_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.VIRIDIS_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(EmoItems.VIRIDIS_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(EmoItems.VIRIDIS_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        createFlatFadingItem(itemModels, EmoItems.LUME_STONE.get());

        // Blocks
        blockModels.createTrivialCube(EmoBlocks.FOSSIL_ORE.get());
        blockModels.createTrivialCube(EmoBlocks.FOSSIL_BLOCK.get());

        blockModels.createTrivialCube(EmoBlocks.PURPURA_ORE.get());
        blockModels.createTrivialCube(EmoBlocks.DEEPSLATE_PURPURA_ORE.get());
        blockModels.createTrivialCube(EmoBlocks.PURPURA_BLOCK.get());

        blockModels.createTrivialCube(EmoBlocks.VIRIDIS_ORE.get());

        createCrystalFadingBlock(blockModels, itemModels, EmoBlocks.VIRIDIS_CRYSTAL.get());

        blockModels.createTrivialCube(EmoBlocks.VIRIDIS_BLOCK.get());

        createFadingBlock(blockModels, itemModels, EmoBlocks.NETHER_LUME_ORE.get());
        createFadingBlock(blockModels, itemModels, EmoBlocks.LUME_BLOCK.get());
    }

    private static void createCrystalFadingBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block) {
        createFadingBlock(blockModels, itemModels, block, CustomModelTemplate.CRYSTAL, EmoModelProvider::crystal);
    }

    private static void createFadingBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block) {
        createFadingBlock(blockModels, itemModels, block, ModelTemplates.CUBE_ALL, TextureMapping::cube);
    }

    private static void createFadingBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, ModelTemplate modelTemplate, Function<ResourceLocation, TextureMapping> textureMappingGetter) {
        MultiVariant var0 = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_0", modelTemplate, textureMappingGetter));
        MultiVariant var1 = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_1", modelTemplate, textureMappingGetter));
        MultiVariant var2 = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_2", modelTemplate, textureMappingGetter));
        MultiVariant var3 = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_3", modelTemplate, textureMappingGetter));
        MultiVariant var4 = BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_4", modelTemplate, textureMappingGetter));

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(block)
                        .with(PropertyDispatch.initial(EmoBlockStateProperties.PHASE)
                                .select(0, var0)
                                .select(1, var1)
                                .select(2, var2)
                                .select(3, var3)
                                .select(4, var4)
                        )
        );

        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
        Item item = block.asItem();

        itemModels.itemModelOutput.accept(
                item,
                new RangeSelectItemModel.Unbaked(
                        new PhaseValue(),
                        1f,
                        List.of(
                                new RangeSelectItemModel.Entry(
                                        0f,
                                        new BlockModelWrapper.Unbaked(
                                                name.withSuffix("_0"),
                                                Collections.emptyList()
                                        )
                                ),
                                new RangeSelectItemModel.Entry(
                                        1f,
                                        new BlockModelWrapper.Unbaked(
                                                name.withSuffix("_1"),
                                                Collections.emptyList()
                                        )
                                ),
                                new RangeSelectItemModel.Entry(
                                        2f,
                                        new BlockModelWrapper.Unbaked(
                                                name.withSuffix("_2"),
                                                Collections.emptyList()
                                        )
                                ),
                                new RangeSelectItemModel.Entry(
                                        3f,
                                        new BlockModelWrapper.Unbaked(
                                                name.withSuffix("_3"),
                                                Collections.emptyList()
                                        )
                                ),
                                new RangeSelectItemModel.Entry(
                                        4f,
                                        new BlockModelWrapper.Unbaked(
                                                name.withSuffix("_4"),
                                                Collections.emptyList()
                                        )
                                )
                        ),
                        Optional.of(
                                new BlockModelWrapper.Unbaked(
                                        name,
                                        Collections.emptyList()
                                )
                        )
                )
        );
    }

    private static void createFlatFadingItem(ItemModelGenerators itemModels, Item item) {
        itemModels.itemModelOutput.accept(
                item,
                new RangeSelectItemModel.Unbaked(
                        new PhaseValue(),
                        1f,
                        List.of(
                                new RangeSelectItemModel.Entry(
                                        0f,
                                        ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_0", ModelTemplates.FLAT_ITEM))
                                ),
                                new RangeSelectItemModel.Entry(
                                        1f,
                                        ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_1", ModelTemplates.FLAT_ITEM))
                                ),
                                new RangeSelectItemModel.Entry(
                                        2f,
                                        ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_2", ModelTemplates.FLAT_ITEM))
                                ),
                                new RangeSelectItemModel.Entry(
                                        3f,
                                        ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_3", ModelTemplates.FLAT_ITEM))
                                ),
                                new RangeSelectItemModel.Entry(
                                        4f,
                                        ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_4", ModelTemplates.FLAT_ITEM))
                                )
                        ),
                        Optional.of(
                                ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM))
                        )
                )
        );
    }

    private static TextureMapping crystal(ResourceLocation resourceLocation) {
        return new TextureMapping().put(CustomTextureSlot.CRYSTAL, resourceLocation);
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return EmoBlocks.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return EmoItems.ITEMS.getEntries().stream();
    }
}
