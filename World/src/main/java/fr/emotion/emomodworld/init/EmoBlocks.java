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
    public static final DeferredBlock<Block> ORANGE_PLANKS = addBlock("orange_planks", props -> new Block(props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_planks")))));
    public static final DeferredBlock<Block> ATLAS_PLANKS = addBlock("atlas_planks", props -> new Block(props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_planks")))));
    public static final DeferredBlock<Block> PINE_PLANKS = addBlock("pine_planks", props -> new Block(props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_planks")))));
    public static final DeferredBlock<Block> COCO_PLANKS = addBlock("coco_planks", props -> new Block(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_planks")))));
    public static final DeferredBlock<Block> DREAM_PLANKS = addBlock("dream_planks", props -> new Block(props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_planks")))));

    public static final DeferredBlock<Block> PEAR_SAPLING = addBlock("pear_sapling", props -> new SaplingBlock(EmoTreeGrower.PEAR, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_sapling")))));
    public static final DeferredBlock<Block> ORANGE_SAPLING = addBlock("orange_sapling", props -> new SaplingBlock(EmoTreeGrower.ORANGE, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_sapling")))));
    public static final DeferredBlock<Block> ATLAS_SAPLING = addBlock("atlas_sapling", props -> new SaplingBlock(EmoTreeGrower.ATLAS, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_sapling")))));
    public static final DeferredBlock<Block> PINE_SAPLING = addBlock("pine_sapling", props -> new SaplingBlock(EmoTreeGrower.PINE, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_sapling")))));
    public static final DeferredBlock<Block> COCO_SAPLING = addBlock("coco_sapling", props -> new SaplingBlock(EmoTreeGrower.COCO, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_sapling")))));
    public static final DeferredBlock<Block> DREAM_SAPLING = addBlock("dream_sapling", props -> new SaplingBlock(EmoTreeGrower.DREAM, props.mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_sapling")))));

    public static final DeferredBlock<Block> PEAR_LOG = addBlock("pear_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PEAR_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> ORANGE_LOG = addBlock("orange_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_ORANGE_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> ATLAS_LOG = addBlock("atlas_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_ATLAS_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> PINE_LOG = addBlock("pine_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PINE_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> COCO_LOG = addBlock("coco_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_COCO_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> DREAM_LOG = addBlock("dream_log", props -> new RotatedPillarBlock(props.mapColor(state -> state.getValue(RotatedPillarBlock.AXIS)==Direction.Axis.Y ? MapColor.WOOD:MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_log")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_DREAM_LOG.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });

    public static final DeferredBlock<Block> STRIPPED_PEAR_LOG = addBlock("stripped_pear_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pear_log")))));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_LOG = addBlock("stripped_orange_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_orange_log")))));
    public static final DeferredBlock<Block> STRIPPED_ATLAS_LOG = addBlock("stripped_atlas_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_atlas_log")))));
    public static final DeferredBlock<Block> STRIPPED_PINE_LOG = addBlock("stripped_pine_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pine_log")))));
    public static final DeferredBlock<Block> STRIPPED_COCO_LOG = addBlock("stripped_coco_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_coco_log")))));
    public static final DeferredBlock<Block> STRIPPED_DREAM_LOG = addBlock("stripped_dream_log", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_dream_log")))));

    public static final DeferredBlock<Block> PEAR_WOOD = addBlock("pear_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PEAR_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> ORANGE_WOOD = addBlock("orange_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_ORANGE_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> ATLAS_WOOD = addBlock("atlas_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_ATLAS_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> PINE_WOOD = addBlock("pine_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_PINE_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> COCO_WOOD = addBlock("coco_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_COCO_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });
    public static final DeferredBlock<Block> DREAM_WOOD = addBlock("dream_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_wood")))) {
        @Override
        public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
            if (ItemAbilities.AXE_STRIP==itemAbility) return STRIPPED_DREAM_WOOD.get().defaultBlockState();
            else return super.getToolModifiedState(state, context, itemAbility, simulate);
        }
    });

    public static final DeferredBlock<Block> STRIPPED_PEAR_WOOD = addBlock("stripped_pear_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pear_wood")))));
    public static final DeferredBlock<Block> STRIPPED_ORANGE_WOOD = addBlock("stripped_orange_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_orange_wood")))));
    public static final DeferredBlock<Block> STRIPPED_ATLAS_WOOD = addBlock("stripped_atlas_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_atlas_wood")))));
    public static final DeferredBlock<Block> STRIPPED_PINE_WOOD = addBlock("stripped_pine_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_pine_wood")))));
    public static final DeferredBlock<Block> STRIPPED_COCO_WOOD = addBlock("stripped_coco_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_coco_wood")))));
    public static final DeferredBlock<Block> STRIPPED_DREAM_WOOD = addBlock("stripped_dream_wood", props -> new RotatedPillarBlock(props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "stripped_dream_wood")))));

    public static final DeferredBlock<Block> PEAR_LEAVES = addBlock("pear_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_leaves")))));
    public static final DeferredBlock<Block> ORANGE_LEAVES = addBlock("orange_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_leaves")))));
    public static final DeferredBlock<Block> ATLAS_LEAVES = addBlock("atlas_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_leaves")))));
    public static final DeferredBlock<Block> PINE_LEAVES = addBlock("pine_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_leaves")))));
    public static final DeferredBlock<Block> COCO_LEAVES = addBlock("coco_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_leaves")))));
    public static final DeferredBlock<Block> DREAM_LEAVES = addBlock("dream_leaves", props -> new TintedParticleLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_leaves")))));

    public static final DeferredBlock<Block> PEAR_SIGN = addBlock("pear_sign", props -> new StandingSignBlock(EmoWoodType.PEAR, props.mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_sign")))), SignItem.class);
    public static final DeferredBlock<Block> ORANGE_SIGN = addBlock("orange_sign", props -> new StandingSignBlock(EmoWoodType.ORANGE, props.mapColor(ORANGE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_sign")))), SignItem.class);
    public static final DeferredBlock<Block> ATLAS_SIGN = addBlock("atlas_sign", props -> new StandingSignBlock(EmoWoodType.ATLAS, props.mapColor(ATLAS_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_sign")))), SignItem.class);
    public static final DeferredBlock<Block> PINE_SIGN = addBlock("pine_sign", props -> new StandingSignBlock(EmoWoodType.PINE, props.mapColor(PINE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_sign")))), SignItem.class);
    public static final DeferredBlock<Block> COCO_SIGN = addBlock("coco_sign", props -> new StandingSignBlock(EmoWoodType.COCO, props.mapColor(COCO_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_sign")))), SignItem.class);
    public static final DeferredBlock<Block> DREAM_SIGN = addBlock("dream_sign", props -> new StandingSignBlock(EmoWoodType.DREAM, props.mapColor(DREAM_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_sign")))), SignItem.class);

    public static final DeferredBlock<Block> PEAR_WALL_SIGN = BLOCKS.registerBlock("pear_wall_sign", props -> new WallSignBlock(EmoWoodType.PEAR, wallVariant(PEAR_SIGN.get(), true).mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wall_sign")))));
    public static final DeferredBlock<Block> ORANGE_WALL_SIGN = BLOCKS.registerBlock("orange_wall_sign", props -> new WallSignBlock(EmoWoodType.ORANGE, wallVariant(ORANGE_SIGN.get(), true).mapColor(ORANGE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_wall_sign")))));
    public static final DeferredBlock<Block> ATLAS_WALL_SIGN = BLOCKS.registerBlock("atlas_wall_sign", props -> new WallSignBlock(EmoWoodType.ATLAS, wallVariant(ATLAS_SIGN.get(), true).mapColor(ATLAS_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_wall_sign")))));
    public static final DeferredBlock<Block> PINE_WALL_SIGN = BLOCKS.registerBlock("pine_wall_sign", props -> new WallSignBlock(EmoWoodType.PINE, wallVariant(PINE_SIGN.get(), true).mapColor(PINE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_wall_sign")))));
    public static final DeferredBlock<Block> COCO_WALL_SIGN = BLOCKS.registerBlock("coco_wall_sign", props -> new WallSignBlock(EmoWoodType.COCO, wallVariant(COCO_SIGN.get(), true).mapColor(COCO_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_wall_sign")))));
    public static final DeferredBlock<Block> DREAM_WALL_SIGN = BLOCKS.registerBlock("dream_wall_sign", props -> new WallSignBlock(EmoWoodType.DREAM, wallVariant(DREAM_SIGN.get(), true).mapColor(DREAM_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_wall_sign")))));

    public static final DeferredBlock<Block> PEAR_HANGING_SIGN = addBlock("pear_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.PEAR, props.mapColor(PEAR_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_hanging_sign")))), HangingSignItem.class);
    public static final DeferredBlock<Block> ORANGE_HANGING_SIGN = addBlock("orange_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.ORANGE, props.mapColor(ORANGE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_hanging_sign")))), HangingSignItem.class);
    public static final DeferredBlock<Block> ATLAS_HANGING_SIGN = addBlock("atlas_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.ATLAS, props.mapColor(ATLAS_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_hanging_sign")))), HangingSignItem.class);
    public static final DeferredBlock<Block> PINE_HANGING_SIGN = addBlock("pine_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.PINE, props.mapColor(PINE_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_hanging_sign")))), HangingSignItem.class);
    public static final DeferredBlock<Block> COCO_HANGING_SIGN = addBlock("coco_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.COCO, props.mapColor(COCO_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_hanging_sign")))), HangingSignItem.class);
    public static final DeferredBlock<Block> DREAM_HANGING_SIGN = addBlock("dream_hanging_sign", props -> new CeilingHangingSignBlock(EmoWoodType.DREAM, props.mapColor(DREAM_LOG.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_hanging_sign")))), HangingSignItem.class);

    public static final DeferredBlock<Block> PEAR_WALL_HANGING_SIGN = BLOCKS.registerBlock("pear_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.PEAR, wallVariant(PEAR_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_wall_hanging_sign")))));
    public static final DeferredBlock<Block> ORANGE_WALL_HANGING_SIGN = BLOCKS.registerBlock("orange_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.ORANGE, wallVariant(ORANGE_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_wall_hanging_sign")))));
    public static final DeferredBlock<Block> ATLAS_WALL_HANGING_SIGN = BLOCKS.registerBlock("atlas_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.ATLAS, wallVariant(ATLAS_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_wall_hanging_sign")))));
    public static final DeferredBlock<Block> PINE_WALL_HANGING_SIGN = BLOCKS.registerBlock("pine_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.PINE, wallVariant(PINE_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_wall_hanging_sign")))));
    public static final DeferredBlock<Block> COCO_WALL_HANGING_SIGN = BLOCKS.registerBlock("coco_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.COCO, wallVariant(COCO_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_wall_hanging_sign")))));
    public static final DeferredBlock<Block> DREAM_WALL_HANGING_SIGN = BLOCKS.registerBlock("dream_wall_hanging_sign", props -> new WallHangingSignBlock(EmoWoodType.DREAM, wallVariant(DREAM_HANGING_SIGN.get(), true).mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_wall_hanging_sign")))));

    public static final DeferredBlock<Block> PEAR_PRESSURE_PLATE = addBlock("pear_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_pressure_plate")))));
    public static final DeferredBlock<Block> ORANGE_PRESSURE_PLATE = addBlock("orange_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.ORANGE, props.mapColor(ORANGE_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_pressure_plate")))));
    public static final DeferredBlock<Block> ATLAS_PRESSURE_PLATE = addBlock("atlas_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.ATLAS, props.mapColor(ATLAS_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_pressure_plate")))));
    public static final DeferredBlock<Block> PINE_PRESSURE_PLATE = addBlock("pine_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.PINE, props.mapColor(PINE_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_pressure_plate")))));
    public static final DeferredBlock<Block> COCO_PRESSURE_PLATE = addBlock("coco_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.COCO, props.mapColor(COCO_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_pressure_plate")))));
    public static final DeferredBlock<Block> DREAM_PRESSURE_PLATE = addBlock("dream_pressure_plate", props -> new PressurePlateBlock(EmoBlockSetType.DREAM, props.mapColor(DREAM_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_pressure_plate")))));

    public static final DeferredBlock<Block> PEAR_TRAPDOOR = addBlock("pear_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.PEAR, props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_trapdoor")))));
    public static final DeferredBlock<Block> ORANGE_TRAPDOOR = addBlock("orange_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.ORANGE, props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_trapdoor")))));
    public static final DeferredBlock<Block> ATLAS_TRAPDOOR = addBlock("atlas_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.ATLAS, props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_trapdoor")))));
    public static final DeferredBlock<Block> PINE_TRAPDOOR = addBlock("pine_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.PINE, props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_trapdoor")))));
    public static final DeferredBlock<Block> COCO_TRAPDOOR = addBlock("coco_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.COCO, props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_trapdoor")))));
    public static final DeferredBlock<Block> DREAM_TRAPDOOR = addBlock("dream_trapdoor", props -> new TrapDoorBlock(EmoBlockSetType.DREAM, props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_trapdoor")))));

    public static final DeferredBlock<Block> PEAR_STAIRS = addBlock("pear_stairs", props -> new StairBlock(PEAR_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PEAR_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_stairs")))));
    public static final DeferredBlock<Block> ORANGE_STAIRS = addBlock("orange_stairs", props -> new StairBlock(ORANGE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ORANGE_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_stairs")))));
    public static final DeferredBlock<Block> ATLAS_STAIRS = addBlock("atlas_stairs", props -> new StairBlock(ATLAS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ATLAS_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_stairs")))));
    public static final DeferredBlock<Block> PINE_STAIRS = addBlock("pine_stairs", props -> new StairBlock(PINE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PINE_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_stairs")))));
    public static final DeferredBlock<Block> COCO_STAIRS = addBlock("coco_stairs", props -> new StairBlock(COCO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(COCO_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_stairs")))));
    public static final DeferredBlock<Block> DREAM_STAIRS = addBlock("dream_stairs", props -> new StairBlock(DREAM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(DREAM_PLANKS.get()).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_stairs")))));

    public static final DeferredBlock<Block> POTTED_PEAR_SAPLING = addBlock("potted_pear_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PEAR_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_pear_sapling")))));
    public static final DeferredBlock<Block> POTTED_ORANGE_SAPLING = addBlock("potted_orange_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ORANGE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_orange_sapling")))));
    public static final DeferredBlock<Block> POTTED_ATLAS_SAPLING = addBlock("potted_atlas_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ATLAS_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_atlas_sapling")))));
    public static final DeferredBlock<Block> POTTED_PINE_SAPLING = addBlock("potted_pine_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINE_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_pine_sapling")))));
    public static final DeferredBlock<Block> POTTED_COCO_SAPLING = addBlock("potted_coco_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, COCO_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_coco_sapling")))));
    public static final DeferredBlock<Block> POTTED_DREAM_SAPLING = addBlock("potted_dream_sapling", props -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DREAM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "potted_dream_sapling")))));

    public static final DeferredBlock<Block> PEAR_BUTTON = addBlock("pear_button", props -> new ButtonBlock(EmoBlockSetType.PEAR, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_button")))));
    public static final DeferredBlock<Block> ORANGE_BUTTON = addBlock("orange_button", props -> new ButtonBlock(EmoBlockSetType.ORANGE, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_button")))));
    public static final DeferredBlock<Block> ATLAS_BUTTON = addBlock("atlas_button", props -> new ButtonBlock(EmoBlockSetType.ATLAS, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_button")))));
    public static final DeferredBlock<Block> PINE_BUTTON = addBlock("pine_button", props -> new ButtonBlock(EmoBlockSetType.PINE, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_button")))));
    public static final DeferredBlock<Block> COCO_BUTTON = addBlock("coco_button", props -> new ButtonBlock(EmoBlockSetType.COCO, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_button")))));
    public static final DeferredBlock<Block> DREAM_BUTTON = addBlock("dream_button", props -> new ButtonBlock(EmoBlockSetType.DREAM, 30, props.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_button")))));

    public static final DeferredBlock<Block> PEAR_SLAB = addBlock("pear_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_slab")))));
    public static final DeferredBlock<Block> ORANGE_SLAB = addBlock("orange_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_slab")))));
    public static final DeferredBlock<Block> ATLAS_SLAB = addBlock("atlas_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_slab")))));
    public static final DeferredBlock<Block> PINE_SLAB = addBlock("pine_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_slab")))));
    public static final DeferredBlock<Block> COCO_SLAB = addBlock("coco_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_slab")))));
    public static final DeferredBlock<Block> DREAM_SLAB = addBlock("dream_slab", props -> new SlabBlock(props.mapColor(MapColor.COLOR_LIGHT_GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_slab")))));

    public static final DeferredBlock<Block> PEAR_FENCE_GATE = addBlock("pear_fence_gate", props -> new FenceGateBlock(EmoWoodType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_fence_gate")))));
    public static final DeferredBlock<Block> ORANGE_FENCE_GATE = addBlock("orange_fence_gate", props -> new FenceGateBlock(EmoWoodType.ORANGE, props.mapColor(ORANGE_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_fence_gate")))));
    public static final DeferredBlock<Block> ATLAS_FENCE_GATE = addBlock("atlas_fence_gate", props -> new FenceGateBlock(EmoWoodType.ATLAS, props.mapColor(ATLAS_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_fence_gate")))));
    public static final DeferredBlock<Block> PINE_FENCE_GATE = addBlock("pine_fence_gate", props -> new FenceGateBlock(EmoWoodType.PINE, props.mapColor(PINE_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_fence_gate")))));
    public static final DeferredBlock<Block> COCO_FENCE_GATE = addBlock("coco_fence_gate", props -> new FenceGateBlock(EmoWoodType.COCO, props.mapColor(COCO_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_fence_gate")))));
    public static final DeferredBlock<Block> DREAM_FENCE_GATE = addBlock("dream_fence_gate", props -> new FenceGateBlock(EmoWoodType.DREAM, props.mapColor(DREAM_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_fence_gate")))));

    public static final DeferredBlock<Block> PEAR_FENCE = addBlock("pear_fence", props -> new FenceBlock(props.mapColor(PEAR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_fence")))));
    public static final DeferredBlock<Block> ORANGE_FENCE = addBlock("orange_fence", props -> new FenceBlock(props.mapColor(ORANGE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_fence")))));
    public static final DeferredBlock<Block> ATLAS_FENCE = addBlock("atlas_fence", props -> new FenceBlock(props.mapColor(ATLAS_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_fence")))));
    public static final DeferredBlock<Block> PINE_FENCE = addBlock("pine_fence", props -> new FenceBlock(props.mapColor(PINE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_fence")))));
    public static final DeferredBlock<Block> COCO_FENCE = addBlock("coco_fence", props -> new FenceBlock(props.mapColor(COCO_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_fence")))));
    public static final DeferredBlock<Block> DREAM_FENCE = addBlock("dream_fence", props -> new FenceBlock(props.mapColor(DREAM_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava().sound(SoundType.WOOD).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_fence")))));

    public static final DeferredBlock<Block> PEAR_DOOR = addBlock("pear_door", props -> new DoorBlock(EmoBlockSetType.PEAR, props.mapColor(PEAR_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pear_door")))), DoubleHighBlockItem.class);
    public static final DeferredBlock<Block> ORANGE_DOOR = addBlock("orange_door", props -> new DoorBlock(EmoBlockSetType.ORANGE, props.mapColor(ORANGE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "orange_door")))), DoubleHighBlockItem.class);
    public static final DeferredBlock<Block> ATLAS_DOOR = addBlock("atlas_door", props -> new DoorBlock(EmoBlockSetType.ATLAS, props.mapColor(ATLAS_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "atlas_door")))), DoubleHighBlockItem.class);
    public static final DeferredBlock<Block> PINE_DOOR = addBlock("pine_door", props -> new DoorBlock(EmoBlockSetType.PINE, props.mapColor(PINE_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "pine_door")))), DoubleHighBlockItem.class);
    public static final DeferredBlock<Block> COCO_DOOR = addBlock("coco_door", props -> new DoorBlock(EmoBlockSetType.COCO, props.mapColor(COCO_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "coco_door")))), DoubleHighBlockItem.class);
    public static final DeferredBlock<Block> DREAM_DOOR = addBlock("dream_door", props -> new DoorBlock(EmoBlockSetType.DREAM, props.mapColor(DREAM_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "dream_door")))), DoubleHighBlockItem.class);

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

            if (blockItemClass==SignItem.class || blockItemClass==HangingSignItem.class) properties.stacksTo(16);

            try {
                if (blockItemClass==SignItem.class || blockItemClass==HangingSignItem.class) {
                    Constructor<I> constructor = blockItemClass.getConstructor(Block.class, Block.class, Item.Properties.class);

                    Block wallSign = WallSign.getWallBlockByKey(name);

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

    public enum WallSign {
        PEAR("pear_sign", EmoBlocks.PEAR_WALL_SIGN.get()),
        PEAR_HANGING("pear_hanging_sign", EmoBlocks.PEAR_WALL_HANGING_SIGN.get()),
        ORANGE("orange_sign", EmoBlocks.ORANGE_WALL_SIGN.get()),
        ORANGE_HANGING("orange_hanging_sign", EmoBlocks.ORANGE_WALL_HANGING_SIGN.get()),
        ATLAS("atlas_sign", EmoBlocks.ATLAS_WALL_SIGN.get()),
        ATLAS_HANGING("atlas_hanging_sign", EmoBlocks.ATLAS_WALL_HANGING_SIGN.get()),
        PINE("pine_sign", EmoBlocks.PINE_WALL_SIGN.get()),
        PINE_HANGING("pine_hanging_sign", EmoBlocks.PINE_WALL_HANGING_SIGN.get()),
        COCO("coco_sign", EmoBlocks.COCO_WALL_SIGN.get()),
        COCO_HANGING("coco_hanging_sign", EmoBlocks.COCO_WALL_HANGING_SIGN.get()),
        DREAM("dream_sign", EmoBlocks.DREAM_WALL_SIGN.get()),
        DREAM_HANGING("dream_hanging_sign", EmoBlocks.DREAM_WALL_HANGING_SIGN.get());

        private final String key;
        private final Block wallBlock;

        WallSign(String key, Block wallBlock) {
            this.key = key;
            this.wallBlock = wallBlock;
        }

        public String getKey() {
            return key;
        }

        public static Block getWallBlockByKey(String key) {
            for (WallSign wallSign : values()) {
                if (wallSign.key.equals(key)) return wallSign.wallBlock;
            }

            return WallSign.PEAR.wallBlock;
        }
    }
}
