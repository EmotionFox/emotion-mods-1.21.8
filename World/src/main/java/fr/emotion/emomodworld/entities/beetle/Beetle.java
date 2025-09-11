package fr.emotion.emomodworld.entities.beetle;

import com.mojang.serialization.Codec;
import fr.emotion.emomodworld.init.EmoDataComponentType;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import io.netty.buffer.ByteBuf;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class Beetle extends PathfinderMob {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Beetle.class, EntityDataSerializers.INT);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();

    public Beetle(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        super.addAdditionalSaveData(valueOutput);
        valueOutput.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
        super.readAdditionalSaveData(valueInput);
        this.setTypeVariant(valueInput.getIntOr("Variant", 0));
    }

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public BeetleVariant getVariant() {
        return BeetleVariant.byId(this.getTypeVariant());
    }

    private void setVariant(BeetleVariant variant) {
        this.setTypeVariant(variant.getId());
    }

    @Nullable
    @Override
    public <T> T get(DataComponentType<? extends T> p_397746_) {
        return p_397746_==EmoDataComponentType.BEETLE_VARIANT ? castComponentValue((DataComponentType<T>) p_397746_, this.getVariant()):super.get(p_397746_);
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter p_397832_) {
        this.applyImplicitComponentIfPresent(p_397832_, EmoDataComponentType.BEETLE_VARIANT.get());
        super.applyImplicitComponents(p_397832_);
    }

    @Override
    protected <T> boolean applyImplicitComponent(DataComponentType<T> p_397458_, T p_397829_) {
        if (p_397458_==EmoDataComponentType.BEETLE_VARIANT) {
            this.setVariant(castComponentValue(EmoDataComponentType.BEETLE_VARIANT.get(), p_397829_));
            return true;
        } else {
            return super.applyImplicitComponent(p_397458_, p_397829_);
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, SpawnGroupData spawnGroupData) {
        RandomSource randomSource = level.getRandom();
        BeetleVariant variant;

        if (level.getBiome(this.blockPosition())==EmoBiomeKeys.ANCIENT_FOREST) {
            variant = BeetleVariant.BLUE;
        } else {
            variant = Util.getRandom(BeetleVariant.values(), randomSource);
        }

        this.setVariant(variant);
        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, Player.class, 1.5F, 1.0, 1.0));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.0F));
        this.goalSelector.addGoal(2, new BeetleGoToDirtGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 1.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 5.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.FOLLOW_RANGE, 10.0);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        Vec3 movement = this.getDeltaMovement();
        boolean isMoving = movement.horizontalDistanceSqr() > 0;

        if (isMoving) {
            this.idleAnimationState.stop();
            this.walkAnimationState.startIfStopped(this.tickCount);
        } else {
            this.walkAnimationState.stop();
            this.idleAnimationState.startIfStopped(this.tickCount);
        }
    }

    //@Override
    //protected void doPush(Entity entity) {
    //    if (entity.getDimensions(Pose.STANDING).height() > this.getDimensions(Pose.STANDING).height()) {
    //        this.hurt(this.damageSources().inWall(), 2.5F);
    //    } else {
    //        doPush(entity);
    //    }
    //}

    static class BeetleGoToDirtGoal extends MoveToBlockGoal {

        public BeetleGoToDirtGoal(Beetle beetle, double speedModifier) {
            super(beetle, speedModifier, 10);
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            BlockState state = level.getBlockState(pos.below());
            return state.is(Blocks.DIRT) || state.is(Blocks.MUD);
        }
    }

    public enum BeetleVariant implements StringRepresentable {
        BLUE(0, "blue"),
        BROWN(1, "brown"),
        GREEN(2, "green");

        public static final Codec<BeetleVariant> CODEC = StringRepresentable.fromEnum(BeetleVariant::values);
        private static final IntFunction<BeetleVariant> BY_ID = ByIdMap.continuous(BeetleVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        public static final StreamCodec<ByteBuf, BeetleVariant> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, BeetleVariant::getId);
        private final int id;
        private final String name;

        BeetleVariant(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public static BeetleVariant byId(int id) {
            return BY_ID.apply(id);
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
