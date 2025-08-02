package fr.emotion.emomodore.block;

import fr.emotion.emomodore.Config;
import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LumeOreFadingBlock extends FadingBlock {
    public LumeOreFadingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (this.scanForAir(level, pos, true)) {
            if (random.nextInt(Config.FADING_CHANCE_NETHER_LUME_ORE.getAsInt())==0) {
                level.setBlockAndUpdate(pos, state.setValue(EmoBlockStateProperties.PHASE, (state.getValue(EmoBlockStateProperties.PHASE) - 1)));
            } else {
                for (Direction dir : Direction.values()) {
                    Vec3 centered = pos.relative(dir).getCenter();
                    level.sendParticles(
                            ParticleTypes.FLAME,
                            centered.x(),
                            centered.y(),
                            centered.z(),
                            15,
                            0.5,
                            0.5,
                            0.5,
                            0.025);
                }

                List<Player> players = level.getEntitiesOfClass(Player.class, new AABB(pos.getX() - 2.0, pos.getY() - 2.0, pos.getZ() - 2.0, pos.getX() + 2.0, pos.getY() + 2.0, pos.getZ() + 2.0));

                for (Player p : players) {
                    if (!p.isCreative()) p.setRemainingFireTicks(40);
                }
            }
        }
    }

    @Override
    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
        return UniformInt.of(2, 5).sample(level.getRandom());
    }

//    @Override
//    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
//        List<ItemStack> drops = new ArrayList<>();
//        ItemStack stack = new ItemStack(ItemRegistry.LUME_STONE.get());
//        stack.set(ComponentRegistry.PHASE, new PhaseRecord(state.getValue(EmoBlockStateProperties.PHASE)));
//        drops.add(stack);
//
//        return drops;
//    }
}
