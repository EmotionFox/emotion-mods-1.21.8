package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.ThornyFlowerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Constructor;
import java.util.function.Function;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    public static final DeferredBlock<Block> FLOWER_1 = addBlock("flower_kitty", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_kitty")))));
    public static final DeferredBlock<Block> FLOWER_2 = addBlock("flower_nox", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_nox")))));
    public static final DeferredBlock<Block> FLOWER_3 = addBlock("flower_dely", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_dely")))));
    public static final DeferredBlock<Block> FLOWER_4 = addBlock("flower_gnon", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_gnon")))));
    public static final DeferredBlock<Block> FLOWER_5 = addBlock("flower_thorny", props -> new ThornyFlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_thorny")))));
    public static final DeferredBlock<Block> FLOWER_6 = addBlock("flower_centus", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_centus")))));
    public static final DeferredBlock<Block> FLOWER_7 = addBlock("flower_tallgrass", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_tallgrass")))));
    public static final DeferredBlock<Block> FLOWER_8 = addBlock("flower_nebula", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_nebula")))));

    public static final DeferredBlock<Block> FLOWER_9 = addBlock("flower_narcota", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_narcota")))) {
        VoxelShape shape = Block.column(16.0, 0.0, 2.0);

        @Override
        protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return shape;
        }
    });

    // POTTED FLOWER
    public static final DeferredBlock<Block> POTTED_FLOWER_1 = addBlock("potted_flower_kitty", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_1, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_kitty")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_2 = addBlock("potted_flower_nox", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_2, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_nox")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_3 = addBlock("potted_flower_dely", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_3, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_dely")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_4 = addBlock("potted_flower_gnon", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_4, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_gnon")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_5 = addBlock("potted_flower_thorny", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_5, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_thorny")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_6 = addBlock("potted_flower_centus", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_6, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_centus")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_7 = addBlock("potted_flower_tallgrass", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_7, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_tallgrass")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_8 = addBlock("potted_flower_nebula", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_8, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_nebula")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_9 = addBlock("potted_flower_narcota", props -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), FLOWER_9, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_narcota")))));

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
