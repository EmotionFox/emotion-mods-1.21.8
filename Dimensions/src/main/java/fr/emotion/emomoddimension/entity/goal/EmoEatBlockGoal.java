package fr.emotion.emomoddimension.entity.goal;

import fr.emotion.emomoddimension.init.EmoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;
import java.util.function.Predicate;

public class EmoEatBlockGoal extends Goal {
    private static final Predicate<BlockState> IS_EDIBLE = p_401757_ -> p_401757_.is(BlockTags.EDIBLE_FOR_SHEEP);
    private final Mob mob;
    private final Level level;
    private int eatAnimationTick;

    public EmoEatBlockGoal(Mob mob) {
        this.mob = mob;
        this.level = mob.level();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if (this.mob.getRandom().nextInt(this.mob.isBaby() ? 50:1000)!=0) {
            return false;
        } else {
            BlockPos blockpos = this.mob.blockPosition();

            boolean isGrass = this.level.getBlockState(blockpos.below()).is(Blocks.GRASS_BLOCK);
            boolean isDreamGrass = this.level.getBlockState(blockpos.below()).is(EmoBlocks.DREAM_GRASS_BLOCK.get());

            return IS_EDIBLE.test(this.level.getBlockState(blockpos)) || isGrass || isDreamGrass;
        }
    }

    @Override
    public void start() {
        this.eatAnimationTick = this.adjustedTickDelay(40);
        this.level.broadcastEntityEvent(this.mob, (byte) 10);
        this.mob.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatAnimationTick = 0;
    }

    @Override
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick==this.adjustedTickDelay(4)) {
            BlockPos blockpos = this.mob.blockPosition();
            if (IS_EDIBLE.test(this.level.getBlockState(blockpos))) {
                if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(getServerLevel(this.level), this.mob)) {
                    this.level.destroyBlock(blockpos, false);
                }

                this.mob.ate();
            } else {
                BlockPos blockpos1 = blockpos.below();

                boolean isGrass = this.level.getBlockState(blockpos1).is(Blocks.GRASS_BLOCK);
                boolean isDreamGrass = this.level.getBlockState(blockpos1).is(EmoBlocks.DREAM_GRASS_BLOCK.get());

                if (isGrass || isDreamGrass) {
                    if (net.neoforged.neoforge.event.EventHooks.canEntityGrief(getServerLevel(this.level), this.mob)) {
                        BlockState grassBlock = Blocks.GRASS_BLOCK.defaultBlockState();
                        BlockState dirtBlock = Blocks.DIRT.defaultBlockState();

                        if (isDreamGrass) {
                            grassBlock = EmoBlocks.DREAM_GRASS_BLOCK.get().defaultBlockState();
                            dirtBlock = EmoBlocks.DREAM_STONE.get().defaultBlockState();
                        }

                        this.level.levelEvent(2001, blockpos1, Block.getId(grassBlock));
                        this.level.setBlock(blockpos1, dirtBlock, 2);
                    }

                    this.mob.ate();
                }
            }
        }
    }
}
