package fr.emotion.emomodworld.entities.boar;

import fr.emotion.emomodworld.init.EmoEntityType;
import fr.emotion.emomodworld.tags.EmoItemTags;
import fr.emotion.emomodworld.world.biome.EmoBiomeKeys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Boar extends Animal implements NeutralMob {
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(Boar.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Float> ANGER = SynchedEntityData.defineId(Boar.class, EntityDataSerializers.FLOAT);
    private int warningSoundTicks;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private int remainingPersistentAngerTime;
    @javax.annotation.Nullable
    private UUID persistentAngerTarget;
    public final AnimationState chargeAnimationState = new AnimationState();
    public final AnimationState restAnimationState = new AnimationState();

    public Boar(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(EmoItemTags.BOAR_FOOD);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Boar child = EmoEntityType.BOAR.get().create(level, EntitySpawnReason.BREEDING);

        if (child!=null && otherParent instanceof Boar boarParent) {
            float angerParent1 = this.getAnger();
            float angerParent2 = boarParent.getAnger();
            float baseAnger = (angerParent1 + angerParent2) / 2.0F;
            baseAnger -= 0.1F;
            baseAnger += (random.nextFloat() - 0.5F) * 0.05F;
            child.setAnger(Math.clamp(baseAnger, 0.0F, 1.0F));
        }

        return child;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new Boar.BoarCharge());
        this.goalSelector.addGoal(2, new Boar.BoarLookAtPlayerGoal());
        this.goalSelector.addGoal(3, new Boar.BoarAvoidEntityGoal<>());
        //this.goalSelector.addGoal(1, new PanicGoal(this, 2.0, mob -> mob.isBaby() ? DamageTypeTags.PANIC_CAUSES:DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.05));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 25.0)
                .add(Attributes.FOLLOW_RANGE, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0);
    }

    public static boolean checkBoarSpawnRules(EntityType<Boar> entityType, LevelAccessor level, EntitySpawnReason spawnReason, BlockPos blockPos, RandomSource random) {
        Holder<Biome> holder = level.getBiome(blockPos);
        return holder.is(EmoBiomeKeys.VERDANT_SLOPES)
                ? checkAnimalSpawnRules(entityType, level, spawnReason, blockPos, random)
                :isBrightEnoughToSpawn(level, blockPos) && level.getBlockState(blockPos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.readPersistentAngerSaveData(this.level(), input);
        this.setAnger(input.getFloatOr("Anger", 1.0F));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        this.addPersistentAngerSaveData(output);
        output.putFloat("Anger", this.getAnger());
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) {
        this.remainingPersistentAngerTime = time;
    }

    @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID target) {
        this.persistentAngerTarget = target;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    public void setBoarState(BoarState state) {
        this.entityData.set(DATA_ID_FLAGS, state.getId());
    }

    public void setAnger(float anger) {
        this.entityData.set(ANGER, anger);
    }

    public BoarState getBoarState() {
        return BoarState.fromId(this.entityData.get(DATA_ID_FLAGS));
    }

    public boolean isAngry() {
        return this.entityData.get(ANGER) > 0;
    }

    public float getAnger() {
        return this.entityData.get(ANGER);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.POLAR_BEAR_STEP, 0.15F, 1.0F);
    }

    protected void playWarningSound() {
        if (this.warningSoundTicks <= 0) {
            this.makeSound(SoundEvents.POLAR_BEAR_WARNING);
            this.warningSoundTicks = 40;
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_FLAGS, (byte) 0);
        builder.define(ANGER, 1.0F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.warningSoundTicks > 0) {
            this.warningSoundTicks--;
        }

        if (this.level() instanceof ServerLevel serverLevel) {
            Player player = serverLevel.getNearestPlayer(this.getX(), this.getY(), this.getZ(), 10.0, true);
            if (player!=null) {
                double distSqr = player.blockPosition().distSqr(this.blockPosition());

                if (distSqr <= 3.0 * 3.0) {
                    this.setBoarState(BoarState.CHARGING);
                    this.setTarget(player);
                    this.setPersistentAngerTarget(player.getUUID());
                } else if (distSqr <= 6.0 * 6.0) {
                    this.setBoarState(BoarState.WARNING);
                } else {
                    this.setBoarState(BoarState.CALM);
                }
            } else if (this.getBoarState().getId() > 1) {
                if (serverLevel.getBlockState(this.blockPosition().below()).is(Blocks.MUD) && random.nextInt(2)==0)
                    this.setBoarState(BoarState.RESTING);
                else
                    this.setBoarState(BoarState.CALM);
            } else if (this.getBoarState()==BoarState.RESTING && (!serverLevel.getBlockState(this.blockPosition().below()).is(Blocks.MUD) || random.nextInt(50)==0)) {
                this.setBoarState(BoarState.CALM);
            }
        }

        if (this.getBoarState()==BoarState.RESTING)
            this.setDeltaMovement(Vec3.ZERO);

        if (!this.level().isClientSide()) {
            this.updatePersistentAnger((ServerLevel) this.level(), true);
        } else {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.getBoarState()==BoarState.RESTING) {
            this.chargeAnimationState.stop();
            this.restAnimationState.startIfStopped(this.tickCount);
        } else if (this.getBoarState()==BoarState.CHARGING && this.walkAnimation.isMoving()) {
            this.restAnimationState.stop();
            this.chargeAnimationState.startIfStopped(this.tickCount);
        } else {
            this.chargeAnimationState.stop();
            this.restAnimationState.stop();
        }
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.98F;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData spawnGroupData) {
        if (spawnGroupData==null) {
            spawnGroupData = new AgeableMobGroupData(1.0F);
        }

        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    class BoarAvoidEntityGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final Boar boar;

        public BoarAvoidEntityGoal() {
            super(Boar.this, (Class<T>) Player.class, 10.0F, 0.5, 0.5, EntitySelector.NO_CREATIVE_OR_SPECTATOR::test);
            this.boar = Boar.this;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public boolean canUse() {
            boolean flag = super.canUse();
            return boar.getBoarState()==BoarState.CALM && boar.getAnger() > 0.5F && flag;
        }

        @Override
        public boolean canContinueToUse() {
            return this.boar.getBoarState()==BoarState.CALM && super.canContinueToUse();
        }
    }

    class BoarLookAtPlayerGoal extends LookAtPlayerGoal {
        private final Boar boar;

        public BoarLookAtPlayerGoal() {
            super(Boar.this, Player.class, 10.0F, 1.0F);
            this.boar = Boar.this;
        }

        @Override
        public void start() {
            super.start();
            boar.playWarningSound();
        }

        @Override
        public boolean canUse() {
            boolean flag = super.canUse();
            return boar.getBoarState()==BoarState.WARNING && boar.getAnger() > 0.25F && flag;
        }

        @Override
        public boolean canContinueToUse() {
            return boar.getBoarState()==BoarState.WARNING && super.canContinueToUse();
        }
    }

    class BoarCharge extends MeleeAttackGoal {
        private final Boar boar;

        public BoarCharge() {
            super(Boar.this, 1.05F, false);
            this.boar = Boar.this;
        }

        @Override
        public void start() {
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
        }

        @Override
        public boolean canUse() {
            boolean flag = super.canUse();
            return boar.getBoarState()==BoarState.CHARGING && (boar.getAnger() > 0.1F || random.nextInt(10)==0) && !boar.isBaby() && flag;
        }

        @Override
        public boolean canContinueToUse() {
            return boar.getBoarState()==BoarState.CHARGING && super.canContinueToUse();
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity target) {
            super.checkAndPerformAttack(target);

            if (this.canPerformAttack(target)) {
                double dx = target.getX() - boar.getX();
                double dz = target.getZ() - boar.getZ();
                Vec3 dir = new Vec3(dx, 0, dz).normalize().scale(5.0);
                target.push(dir.x, 0.5, dir.z);
            }
        }
    }

    public enum BoarState implements StringRepresentable {
        CALM(0, "calm"),
        RESTING(1, "resting"),
        WARNING(2, "warning"),
        CHARGING(3, "charging");

        private final byte id;
        private final String name;

        BoarState(int id, String name) {
            this.id = (byte) id;
            this.name = name;
        }

        public byte getId() {
            return this.id;
        }

        public static BoarState fromId(byte id) {
            for (BoarState state : values()) {
                if (state.id==id) return state;
            }
            return CALM;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
