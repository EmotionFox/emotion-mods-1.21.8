package fr.emotion.emomodfurniture.init;

import fr.emotion.emomodfurniture.EmoMain;
import fr.emotion.emomodfurniture.blocks.entity.NightstandBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EmoBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EmoMain.MODID);

    public static final Supplier<BlockEntityType<NightstandBlockEntity>> NIGHTSTAND = BLOCK_ENTITY_TYPE.register(
            "nightstand",
            () -> new BlockEntityType<>(
                    NightstandBlockEntity::new,
                    false,
                    EmoBlocks.NIGHTSTAND_PEAR.get(),
                    EmoBlocks.NIGHTSTAND_ORANGE.get(),
                    EmoBlocks.NIGHTSTAND_ATLAS.get(),
                    EmoBlocks.NIGHTSTAND_PINE.get(),
                    EmoBlocks.NIGHTSTAND_COCO.get(),
                    EmoBlocks.NIGHTSTAND_DREAM.get(),
                    EmoBlocks.NIGHTSTAND_OAK.get(),
                    EmoBlocks.NIGHTSTAND_SPRUCE.get(),
                    EmoBlocks.NIGHTSTAND_BIRCH.get(),
                    EmoBlocks.NIGHTSTAND_JUNGLE.get(),
                    EmoBlocks.NIGHTSTAND_ACACIA.get(),
                    EmoBlocks.NIGHTSTAND_CHERRY.get(),
                    EmoBlocks.NIGHTSTAND_DARK_OAK.get(),
                    EmoBlocks.NIGHTSTAND_PALE_OAK.get(),
                    EmoBlocks.NIGHTSTAND_MANGROVE.get(),
                    EmoBlocks.NIGHTSTAND_BAMBOO.get(),
                    EmoBlocks.NIGHTSTAND_CRIMSON.get(),
                    EmoBlocks.NIGHTSTAND_WARPED.get()
            )
    );

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_TYPE.register(eventBus);
    }

    public static DeferredRegister<BlockEntityType<?>> getEntityType() {
        return BLOCK_ENTITY_TYPE;
    }
}
