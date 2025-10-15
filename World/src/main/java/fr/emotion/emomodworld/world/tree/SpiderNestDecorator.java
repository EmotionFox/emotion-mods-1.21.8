package fr.emotion.emomodworld.world.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.init.EmoEntityType;
import fr.emotion.emomodworld.init.EmoTreeDecoratorType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpiderNestDecorator extends TreeDecorator {
    public static final MapCodec<SpiderNestDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(SpiderNestDecorator::new, decorator -> decorator.probability);
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL
            .stream()
            .filter(p_202307_ -> p_202307_!=WORLDGEN_FACING.getOpposite())
            .toArray(Direction[]::new);

    private final float probability;

    public SpiderNestDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return EmoTreeDecoratorType.SPIDER_NEST.get();
    }

    @Override
    public void place(Context context) {
        List<BlockPos> logs = context.logs();

        if (!logs.isEmpty()) {
            RandomSource random = context.random();

            if (!(random.nextFloat() >= this.probability)) {
                int i = logs.getFirst().getY() + 1;

                List<BlockPos> candidates = logs.stream()
                        .filter(blockPos -> blockPos.getY()==i)
                        .flatMap(blockPos -> Stream.of(SPAWN_DIRECTIONS).map(blockPos::relative))
                        .collect(Collectors.toList());

                if (!candidates.isEmpty()) {
                    Util.shuffle(candidates, random);
                    Optional<BlockPos> optional = candidates.stream()
                            .filter(blockPos -> context.isAir(blockPos) && context.checkBlock(blockPos.below(), BlockBehaviour.BlockStateBase::isSolidRender))
                            .findFirst();

                    if (optional.isPresent()) {
                        context.setBlock(optional.get(), Blocks.SPAWNER.defaultBlockState());

                        context.level().getBlockEntity(optional.get(), BlockEntityType.MOB_SPAWNER).ifPresent(blockEntity -> {
                            blockEntity.setEntityId(EmoEntityType.JUMPING_SPIDER.get(), random);
                        });
                    }
                }
            }
        }
    }
}
