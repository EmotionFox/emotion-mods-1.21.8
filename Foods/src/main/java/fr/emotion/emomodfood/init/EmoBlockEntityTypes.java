package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EmoMain.MODID);

    public static final Supplier<BlockEntityType<PotBlockEntity>> POT = BLOCK_ENTITY_TYPE.register(
            "pot",
            () -> new BlockEntityType<>(
                    PotBlockEntity::new,
                    false,
                    EmoBlocks.POT.get()
            )
    );

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}
