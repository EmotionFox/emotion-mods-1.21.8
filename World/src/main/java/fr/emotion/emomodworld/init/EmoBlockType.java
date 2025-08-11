package fr.emotion.emomodworld.init;

import com.mojang.serialization.MapCodec;
import fr.emotion.emomodworld.EmoMain;
import fr.emotion.emomodworld.blocks.EmoBushBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoBlockType {
    private static final DeferredRegister<MapCodec<? extends Block>> BLOCK_TYPES = DeferredRegister.create(Registries.BLOCK_TYPE, EmoMain.MODID);

    public static final DeferredHolder<MapCodec<? extends Block>, MapCodec<EmoBushBlock>> BUSH_BLOCK = BLOCK_TYPES.register("bush_block", () -> EmoBushBlock.CODEC);

    public static void init(IEventBus eventBus) {
        BLOCK_TYPES.register(eventBus);
    }
}
