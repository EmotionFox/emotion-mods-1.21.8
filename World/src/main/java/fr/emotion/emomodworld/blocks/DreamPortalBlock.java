package fr.emotion.emomodworld.blocks;

import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.datagen.setBuilder.dimension.EmoDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class DreamPortalBlock extends Block implements Portal {
    public DreamPortalBlock(Properties props) {
        super(props);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier blockEffectApplier) {
        if (entity.canUsePortal(false)) {
            entity.setAsInsidePortal(this, pos);
        }
    }

    @Override
    public @Nullable TeleportTransition getPortalDestination(ServerLevel level, Entity entity, BlockPos pos) {
        ResourceKey<Level> levelKey = level.dimension()==EmoDimension.DREAM ? Level.OVERWORLD:EmoDimension.DREAM;
        ServerLevel serverLevel = level.getServer().getLevel(levelKey);

        if (serverLevel==null) {
            return null;
        } else {
            boolean flag = levelKey==EmoDimension.DREAM;
            Vec3 vec3 = pos.getBottomCenter();
            float f;
            Set<Relative> set;
            if (flag) {
                if (serverLevel.getBlockState(pos.below()).isAir())
                    createPlatform(serverLevel, pos);

                if (!serverLevel.getBlockState(pos.above()).isAir())
                    vec3 = findFreePos(serverLevel, pos.above()).getBottomCenter();

                f = Direction.WEST.toYRot();
                set = Relative.union(Relative.DELTA, Set.of(Relative.X_ROT));
                if (entity instanceof ServerPlayer) {
                    vec3 = vec3.subtract(0.0, 1.0, 0.0);
                }
            } else {
                f = serverLevel.getSharedSpawnAngle();
                set = Relative.union(Relative.DELTA, Relative.ROTATION);
                if (entity instanceof ServerPlayer serverPlayer) {
                    return serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING);
                }

                vec3 = entity.adjustSpawnLocation(serverLevel, pos).getBottomCenter();
            }

            return new TeleportTransition(
                    serverLevel, vec3, Vec3.ZERO, f, 0.0F, set, TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET)
            );
        }
    }

    public static void createPlatform(ServerLevelAccessor level, BlockPos pos) {
        BlockPos.MutableBlockPos blockPos = pos.mutable();

        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                if (level.getBlockState(blockPos.setWithOffset(pos, x, -2, z)).isAir())
                    level.setBlock(blockPos, Blocks.STONE.defaultBlockState(), 3);
            }
        }
    }

    public static BlockPos findFreePos(ServerLevelAccessor level, BlockPos pos) {
        BlockPos.MutableBlockPos blockPos = pos.mutable();
        int i = 0;

        do {
            EmoMain.LOGGER.info("UP WE GO! " + i);
            i++;
            blockPos.setWithOffset(pos, 0, i, 0);
        } while (!(level.getBlockState(blockPos).isAir() && level.getBlockState(blockPos.below()).isAir()));

        return blockPos;
    }
}
