package fr.emotion.emomodworld.world;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.init.EmoPlacementModifierType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.stream.Stream;

public class InGridPlacement extends PlacementModifier {
    private static final InGridPlacement INSTANCE = new InGridPlacement();
    public static final MapCodec<InGridPlacement> CODEC = MapCodec.unit(() -> INSTANCE);

    public static InGridPlacement spread() {
        return INSTANCE;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext context, RandomSource random, BlockPos pos) {
        int chunkX = (pos.getX() >> 4) << 4;
        int chunkZ = (pos.getZ() >> 4) << 4;
        return random.nextInt(1)==0 ? Stream.of(new BlockPos(chunkX, pos.getY(), chunkZ)):Stream.empty();
    }

    @Override
    public PlacementModifierType<?> type() {
        return EmoPlacementModifierType.IN_GRID.get();
    }
}
