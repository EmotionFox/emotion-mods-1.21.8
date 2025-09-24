package fr.emotion.emomodworld.entities.butterfly;

import com.mojang.serialization.Codec;
import fr.emotion.emomodworld.init.EmoDataComponentType;
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class Butterfly extends AmbientCreature {
    public static final int LAND_LENGTH_TICKS = 34;
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.INT);
    private static final TargetingConditions BUTTERFLY_RESTING_TARGETING = TargetingConditions.forNonCombat();
    public final AnimationState flyAnimationState = new AnimationState();
    public final AnimationState landAnimationState = new AnimationState();
    public final AnimationState restAnimationState = new AnimationState();
    @javax.annotation.Nullable
    private BlockPos targetPosition;

    public Butterfly(EntityType<? extends AmbientCreature> entityType, Level level) {
        super(entityType, level);

        if (!level.isClientSide()) {
            this.setResting(true);
        }

        this.moveControl = new FlyingMoveControl(this, 10, false);
        this.setNoGravity(true);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new FlyingPathNavigation(this, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_FLAGS, (byte) 0);
        builder.define(VARIANT, 0);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        super.addAdditionalSaveData(valueOutput);
        valueOutput.putByte("ButterflyFlags", this.entityData.get(DATA_ID_FLAGS));
        valueOutput.putInt("Variant", this.getTypeVariant());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
        super.readAdditionalSaveData(valueInput);
        this.entityData.set(DATA_ID_FLAGS, valueInput.getByteOr("ButterflyFlags", (byte) 0));
        this.setTypeVariant(valueInput.getIntOr("Variant", 0));
    }

    private void setTypeVariant(int typeVariant) {
        this.entityData.set(VARIANT, typeVariant);
    }

    private int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    public ButterflyVariant getVariant() {
        return ButterflyVariant.byId(this.getTypeVariant());
    }

    public void setVariant(ButterflyVariant variant) {
        this.setTypeVariant(variant.getId());
    }

    @Override
    public @Nullable <T> T get(@NotNull DataComponentType<? extends T> dataComponentType) {
        return dataComponentType==EmoDataComponentType.BUTTERFLY_VARIANT ? castComponentValue((DataComponentType<? extends T>) dataComponentType, this.getVariant()):super.get(dataComponentType);
    }

    @Override
    protected void applyImplicitComponents(@NotNull DataComponentGetter componentGetter) {
        this.applyImplicitComponentIfPresent(componentGetter, EmoDataComponentType.BUTTERFLY_VARIANT.get());
        super.applyImplicitComponents(componentGetter);
    }

    @Override
    protected <T> boolean applyImplicitComponent(@NotNull DataComponentType<T> component, @NotNull T value) {
        if (component==EmoDataComponentType.BUTTERFLY_VARIANT) {
            this.setVariant(castComponentValue(EmoDataComponentType.BUTTERFLY_VARIANT.get(), value));
            return true;
        } else {
            return super.applyImplicitComponent(component, value);
        }
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomSource = level.getRandom();
        this.setVariant(Util.getRandom(ButterflyVariant.values(), randomSource));
        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Override
    protected void pushEntities() {
    }

    public boolean isResting() {
        return (this.entityData.get(DATA_ID_FLAGS) & 1)!=0;
    }

    public void setResting(boolean isResting) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (isResting) {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 | 1));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 & -2));
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isResting()) {
            this.setDeltaMovement(Vec3.ZERO);
            this.setPosRaw(this.getX(), Mth.floor(this.getY()), this.getZ());
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.6, 1.0));
        }

        this.setupAnimationStates();
    }

    protected ArrayList<BlockPos> flowers = new ArrayList<>();

    @Override
    protected void customServerAiStep(ServerLevel serverLevel) {
        super.customServerAiStep(serverLevel);
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.below();
        boolean badWeather = serverLevel.isRaining() || serverLevel.isMoonVisible();

        if (this.isResting()) {
            boolean flag = this.isSilent();

            if (serverLevel.getBlockState(blockpos1).isRedstoneConductor(serverLevel, blockpos)) {
                if (this.random.nextInt(200)==0) {
                    this.yHeadRot = this.random.nextInt(180);
                }

                TargetingConditions restingTargeting = badWeather
                        ? BUTTERFLY_RESTING_TARGETING.range(4.0)
                        :BUTTERFLY_RESTING_TARGETING.range(6.0);

                if (serverLevel.getNearestPlayer(restingTargeting, this)!=null) {
                    this.setResting(false);

                    if (!flag) {
                        serverLevel.levelEvent(null, 1025, blockpos, 0);
                    }
                } else if (this.random.nextInt(badWeather ? 200:100)==0) {
                    this.setResting(false);

                    if (!flag) {
                        serverLevel.levelEvent(null, 1025, blockpos, 0);
                    }
                }
            } else {
                this.setResting(false);

                if (!flag) {
                    serverLevel.levelEvent(null, 1025, blockpos, 0);
                }
            }

        } else {
            if (this.targetPosition!=null && (serverLevel.getBlockState(this.targetPosition).isSolidRender() || this.targetPosition.getY() <= serverLevel.getMinY())) {
                this.targetPosition = null;
            }

            if (this.targetPosition==null || this.random.nextInt(40)==0 || this.targetPosition.closerToCenterThan(this.position(), 2.0) || this.getDeltaMovement().horizontalDistanceSqr() < 0.005) {
                this.flowers.clear();

                for (int x = -5; x <= 5; x++) {
                    for (int z = -5; z <= 5; z++) {
                        BlockPos newPos = new BlockPos(blockpos.offset(x, 0, z));
                        int y = (int) serverLevel.getBlockFloorHeight(newPos);
                        BlockPos canditate = newPos.offset(0, y, 0);
                        boolean flag = serverLevel.getBlockState(canditate).is(BlockTags.FLOWERS) || serverLevel.getBlockState(canditate).is(BlockTags.FLOWER_POTS);

                        if (flag) {
                            this.flowers.add(canditate);
                        }
                    }
                }

                if (!flowers.isEmpty() && this.random.nextInt(1)==0) {
                    this.targetPosition = flowers.get(this.random.nextInt(flowers.size())).above(badWeather ? 0:1);
                } else {
                    int x = this.random.nextInt(7) - this.random.nextInt(7);
                    int z = this.random.nextInt(7) - this.random.nextInt(7);
                    BlockPos newPos = new BlockPos(blockpos.offset(x, 0, z));
                    double yA = serverLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, newPos);
                    double yB = Math.clamp(yA + (badWeather ? 0:1) + (this.random.nextInt(badWeather ? 6:8) - this.random.nextInt(badWeather ? 6:8)), yA, yA + 10);

                    this.targetPosition = BlockPos.containing(
                            newPos.getX(),
                            yB,
                            newPos.getZ()
                    );
                }
            }

            double dX = this.targetPosition.getX() + 0.5 - this.getX();
            double dY = this.targetPosition.getY() + 0.1 - this.getY();
            double dZ = this.targetPosition.getZ() + 0.5 - this.getZ();
            Vec3 motion = this.getDeltaMovement();
            Vec3 adjusted = motion.add(
                    (Math.signum(dX) * 0.5 - motion.x) * 0.1F,
                    (Math.signum(dY) * 0.85F - motion.y) * 0.1F,
                    (Math.signum(dZ) * 0.5 - motion.z) * 0.1F
            );
            this.setDeltaMovement(adjusted);

            float f = (float) (Mth.atan2(adjusted.z, adjusted.x) * 180.0F / (float) Math.PI) - 90.0F;
            float f1 = Mth.wrapDegrees(f - this.getYRot());
            this.zza = 0.5F;
            this.setYRot(this.getYRot() + f1);

            boolean flag = serverLevel.getBlockState(blockpos1).isSolidRender();
            boolean flag2 = serverLevel.getBlockState(blockpos).is(BlockTags.FLOWERS) || serverLevel.getBlockState(blockpos).is(BlockTags.FLOWER_POTS);

            if (flag && this.random.nextInt(flag2 ? 100:200)==0) {
                this.setResting(true);
            }
        }
    }

    @Override
    protected MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float damage) {
        if (this.isInvulnerableTo(serverLevel, damageSource)) {
            return false;
        } else {
            if (this.isResting()) {
                this.setResting(false);
            }

            return super.hurtServer(serverLevel, damageSource, damage);
        }
    }

    int tick = 0;

    private void setupAnimationStates() {

        if (this.isResting()) {
            this.flyAnimationState.stop();

            if (tick==0) {
                this.landAnimationState.startIfStopped(this.tickCount);
                tick += 1;
            } else if (this.landAnimationState.isStarted() && tick < LAND_LENGTH_TICKS) {
                tick++;
            } else if (!this.restAnimationState.isStarted() && tick >= LAND_LENGTH_TICKS) {
                this.landAnimationState.stop();
                this.restAnimationState.startIfStopped(this.tickCount);
            }
        } else {
            this.landAnimationState.stop();
            this.restAnimationState.stop();
            this.flyAnimationState.startIfStopped(this.tickCount);
            tick = 0;
        }
    }

    public enum ButterflyVariant implements StringRepresentable {
        BLUE(0, "blue"),
        BROWN(1, "brown"),
        GREEN(2, "green"),
        PINK(3, "pink"),
        RED(4, "red"),
        YELLOW(5, "yellow");

        public static final Codec<ButterflyVariant> CODEC = StringRepresentable.fromEnum(ButterflyVariant::values);
        private static final IntFunction<ButterflyVariant> BY_ID = ByIdMap.continuous(ButterflyVariant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
        public static final StreamCodec<ByteBuf, ButterflyVariant> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, ButterflyVariant::getId);
        private final int id;
        private final String name;

        ButterflyVariant(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public static ButterflyVariant byId(int id) {
            return BY_ID.apply(id);
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
