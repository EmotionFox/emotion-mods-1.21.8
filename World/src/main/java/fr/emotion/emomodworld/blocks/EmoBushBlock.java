package fr.emotion.emomodworld.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;

import java.util.function.Supplier;

public class EmoBushBlock extends VegetationBlock implements BonemealableBlock {
    public static final MapCodec<EmoBushBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec()
                    .fieldOf("berry")
                    .forGetter(bush -> bush.berry.get()),

            Properties.CODEC
                    .fieldOf("properties")
                    .forGetter(bush -> bush.properties)
    ).apply(instance, EmoBushBlock::new));

    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<Item> berry;

    @Override
    protected MapCodec<? extends VegetationBlock> codec() {
        return CODEC;
    }

    public EmoBushBlock(Item berry, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0).setValue(AGE, 0));
        this.berry = () -> berry;
    }

    public EmoBushBlock(Supplier<Item> berry, Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0).setValue(AGE, 0));
        this.berry = berry;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource random) {
        int moisture = state.getValue(MOISTURE);
        int age = state.getValue(AGE);

        BlockState newState = state;

        if (moisture > 0) {
            if (random.nextInt(14 - moisture)==0)
                newState = state.setValue(MOISTURE, moisture - 1);

            if (age < 3 && serverLevel.getRawBrightness(pos.above(), 0) >= 5 && CommonHooks.canCropGrow(serverLevel, pos, state, random.nextInt(5)==0))
                newState = state.setValue(AGE, age + 1);
        } else if (age > 0 && moisture==0 && random.nextInt(4)==0) {
            newState = state.setValue(AGE, age - 1);
        }

        if (newState!=state) {
            serverLevel.setBlock(pos, newState, 2);
            CommonHooks.fireCropGrowPost(serverLevel, pos, state);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
        }
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
        if (entity instanceof LivingEntity && entity.getType()!=EntityType.FOX && entity.getType()!=EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.4F, 0.375F, 0.4F));
        }
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int moisture = state.getValue(MOISTURE);
        boolean flag = moisture==7;

        if (stack.is(Items.WATER_BUCKET) && !flag) {
            if (!player.isCreative()) {
                player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            BlockState newState = state.setValue(MOISTURE, 7);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

            return InteractionResult.CONSUME;
        }

        return (InteractionResult) (stack.is(Items.BONE_MEAL) ? InteractionResult.PASS:super.useItemOn(stack, state, level, pos, player, hand, hitResult));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int age = state.getValue(AGE);
        boolean flag = age==3;

        if (flag) {
            int amount = 1 + level.random.nextInt(2);
            BlockState newState = state.setValue(AGE, 0);

            popResource(level, pos, new ItemStack(berry.get(), amount));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE, AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return state.getValue(MOISTURE) > 0;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return random.nextInt(4)==0;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        popResource(level, pos, new ItemStack(this.asItem()));
    }
}
