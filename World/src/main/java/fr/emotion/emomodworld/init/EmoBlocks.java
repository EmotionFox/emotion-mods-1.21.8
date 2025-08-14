package fr.emotion.emomodworld.init;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.EmoBushBlock;
import fr.emotion.emomodworld.blocks.ThornyFlowerBlock;
import fr.emotion.emomodworld.blocks.properties.EmoBlockSetType;
import fr.emotion.emomodworld.blocks.properties.EmoWoodType;
import fr.emotion.emomodworld.world.tree.EmoTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.util.function.Function;

public class EmoBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);

    // FLOWER
    public static final DeferredBlock<Block> FLOWER_KITTY = addBlock("flower_kitty", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_kitty")))));
    public static final DeferredBlock<Block> FLOWER_NOX = addBlock("flower_nox", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_nox")))));
    public static final DeferredBlock<Block> FLOWER_DELY = addBlock("flower_dely", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_dely")))));
    public static final DeferredBlock<Block> FLOWER_GNON = addBlock("flower_gnon", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_gnon")))));
    public static final DeferredBlock<Block> FLOWER_THORNY = addBlock("flower_thorny", props -> new ThornyFlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_thorny")))));
    public static final DeferredBlock<Block> FLOWER_CENTUS = addBlock("flower_centus", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_centus")))));
    public static final DeferredBlock<Block> FLOWER_NEBULA = addBlock("flower_nebula", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_nebula")))));

    public static final DeferredBlock<Block> FLOWER_NARCOTA = addBlock("flower_narcota", props -> new FlowerBlock(MobEffects.SATURATION, 0.33f, BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_narcota")))) {
        VoxelShape shape = Block.column(16.0, 0.0, 2.0);

        @Override
        protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return shape;
        }
    });

    public static final DeferredBlock<Block> DREAM_SHORT_GRASS = addBlock("dream_short_grass", props -> new TallGrassBlock(props.mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "flower_tallgrass")))) {
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

    public static final DeferredBlock<Block> DREAM_TALL_GRASS = addBlock("dream_tall_grass", props -> new DoublePlantBlock(props.mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)), DoubleHighBlockItem.class);

    // POTTED FLOWER
    public static final DeferredBlock<Block> POTTED_FLOWER_KITTY = BLOCKS.registerBlock("potted_flower_kitty", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_KITTY, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_kitty")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_NOX = BLOCKS.registerBlock("potted_flower_nox", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_NOX, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_nox")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_DELY = BLOCKS.registerBlock("potted_flower_dely", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_DELY, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_dely")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_GNON = BLOCKS.registerBlock("potted_flower_gnon", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_GNON, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_gnon")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_THORNY = BLOCKS.registerBlock("potted_flower_thorny", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_THORNY, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_thorny")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_CENTUS = BLOCKS.registerBlock("potted_flower_centus", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_CENTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_centus")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_NEBULA = BLOCKS.registerBlock("potted_flower_nebula", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_NEBULA, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_nebula")))));
    public static final DeferredBlock<Block> POTTED_FLOWER_NARCOTA = BLOCKS.registerBlock("potted_flower_narcota", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLOWER_NARCOTA, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_flower_narcota")))));

    // WOOD
    public static final DeferredBlock<Block> PEAR_PLANKS = addBlock("pear_planks", props -> new Block(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_planks")))));

    public static final DeferredBlock<Block> PEAR_SAPLING = addBlock("pear_sapling", props -> new SaplingBlock(EmoTreeGrower.PEAR, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_sapling")))));

    public static final DeferredBlock<Block> PEAR_LOG = addBlock("pear_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PEAR_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });

    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG = addBlock("stripped_pear_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pear_log")))));

    public static final DeferredBlock<Block> PEAR_WOOD = addBlock("pear_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PEAR_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });

    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD = addBlock("stripped_pear_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pear_wood")))));

    public static final DeferredBlock<Block> PEAR_LEAVES = addBlock("pear_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_leaves")))));

    public static final DeferredBlock<Block> PEAR_SIGN = addBlock("pear_sign", props -> new StandingSignBlock(EmoWoodType.PEAR, props.mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_sign")))), SignItem.class);

    public static final DeferredBlock<Block> PEAR_WALL_SIGN = BLOCKS.registerBlock("pear_wall_sign", props -> new WallSignBlock(EmoWoodType.PEAR, wallVariant(PEAR_SIGN.get(), true).mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wall_sign")))));

    public static final DeferredBlock<Block> PEAR_HANGING_SIGN = addBlock("pear_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.PEAR, props.mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_hanging_sign")))), HangingSignItem.class);

    public static final DeferredBlock<Block> PEAR_WALL_HANGING_SIGN = BLOCKS.registerBlock("pear_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.PEAR, wallVariant(PEAR_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wall_hanging_sign")))));

    public static final DeferredBlock<Block> PEAR_PRESSURE_PLATE = addBlock("pear_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_pressure_plate")))));

    public static final DeferredBlock<Block> PEAR_TRAPDOOR = addBlock("pear_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.PEAR, props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_trapdoor")))));

    public static final DeferredBlock<Block> PEAR_STAIRS = addBlock("pear_stairs", props -> new StairBlock(PEAR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_stairs")))));

    public static final DeferredBlock<Block> POTTED_PEAR_SAPLING = addBlock("potted_pear_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEAR_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_pear_sapling")))));

    public static final DeferredBlock<Block> PEAR_BUTTON = addBlock("pear_button", props -> new ButtonBlock(EmoBlockSetType.PEAR, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_button")))));

    public static final DeferredBlock<Block> PEAR_SLAB = addBlock("pear_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_slab")))));

    public static final DeferredBlock<Block> PEAR_FENCE_GATE = addBlock("pear_fence_gate", props -> new FenceGateBlock(EmoWoodType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_fence_gate")))));

    public static final DeferredBlock<Block> PEAR_FENCE = addBlock("pear_fence", props -> new FenceBlock(props.mapColor(PEAR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_fence")))));

    public static final DeferredBlock<Block> PEAR_DOOR = addBlock("pear_door", props -> new DoorBlock(EmoBlockSetType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_door")))), DoubleHighBlockItem.class);

    // BUSH
    public static final DeferredBlock<Block> BUSH_BLACKCURRANT = addBlock("bush_blackcurrant", props -> new EmoBushBlock(EmoItems.BLACKCURRANT, props.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> BUSH_BLUEBERRY = addBlock("bush_blueberry", props -> new EmoBushBlock(EmoItems.BLUEBERRY, props.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> BUSH_DREAMCURRANT = addBlock("bush_dreamcurrant", props -> new EmoBushBlock(EmoItems.DREAMCURRANT, props.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> BUSH_STRAWBERRY = addBlock("bush_strawberry", props -> new EmoBushBlock(EmoItems.STRAWBERRY, props.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> BUSH_SWEET = addBlock("bush_sweet", props -> new EmoBushBlock(Items.SWEET_BERRIES, props.mapColor(MapColor.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));

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

            if (blockItemClass==SignItem.class || blockItemClass==HangingSignItem.class) properties.stacksTo(16);

            try {
                if (blockItemClass==SignItem.class || blockItemClass==HangingSignItem.class) {
                    Constructor<I> constructor = blockItemClass.getConstructor(Block.class, Block.class, Item.Properties.class);

                    Block wallSign;

                    switch (name) {
                        case "pear_sign":
                            wallSign = PEAR_WALL_SIGN.get();
                            break;
                        case "pear_hanging_sign":
                            wallSign = PEAR_WALL_HANGING_SIGN.get();
                            break;
                        default:
                            wallSign = PEAR_WALL_SIGN.get();
                            break;
                    }

                    return constructor.newInstance(block.get(), wallSign, properties);
                } else {
                    Constructor<I> constructor = blockItemClass.getConstructor(Block.class, Item.Properties.class);
                    return constructor.newInstance(block.get(), properties);
                }
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Could not instanciate BlockItem class: " + blockItemClass.getName(), e);
            }
        });
    }

    private static BlockBehaviour.Properties wallVariant(Block baseBlock, boolean overrideDescription) {
        BlockBehaviour.Properties blockbehaviour$properties = baseBlock.properties();
        BlockBehaviour.Properties blockbehaviour$properties1 = BlockBehaviour.Properties.of().overrideLootTable(baseBlock.getLootTable());
        if (overrideDescription) {
            blockbehaviour$properties1 = blockbehaviour$properties1.overrideDescription(baseBlock.getDescriptionId());
        }

        return blockbehaviour$properties1;
    }
}
