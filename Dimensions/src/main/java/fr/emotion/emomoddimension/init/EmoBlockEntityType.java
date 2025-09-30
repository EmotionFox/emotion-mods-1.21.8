package fr.emotion.emomoddimension.init;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.entity.DreamCatcherBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoBlockEntityType {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, EmoMain.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DreamCatcherBlockEntity>> DREAM_CATCHER = BLOCK_ENTITY_TYPE.register(
            "dream_catcher",
            () -> new BlockEntityType<>(
                    DreamCatcherBlockEntity::new,
                    false,
                    EmoBlocks.DREAM_CATCHER.get()
            )
    );

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_TYPE.register(eventBus);
    }
}
