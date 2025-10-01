package fr.emotion.emomodfood;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CandleCakeRegistry {
    private static final Map<CakeBlock, Map<CandleBlock, CandleCakeBlock>> REGISTRY = new HashMap<>();

    public static void register(CakeBlock cake, CandleBlock candle, CandleCakeBlock candleCake) {
        REGISTRY.computeIfAbsent(cake, k -> new HashMap<>()).put(candle, candleCake);
    }

    public static BlockState get(CakeBlock cake, CandleBlock candle) {
        CandleCakeBlock candleCake = REGISTRY
                .getOrDefault(cake, Map.of())
                .get(candle);
        return Objects.requireNonNullElse(candleCake, Blocks.CANDLE_CAKE).defaultBlockState();
    }

    public static BlockState getCakeForCandleCake(CandleCakeBlock candleCake) {
        for (var entry : REGISTRY.entrySet()) {
            for (Map.Entry<CandleBlock, CandleCakeBlock> mapEntry : entry.getValue().entrySet()) {
                if (mapEntry.getValue()==candleCake) return entry.getKey().defaultBlockState();
            }
        }

        return Blocks.CAKE.defaultBlockState();
    }
}
