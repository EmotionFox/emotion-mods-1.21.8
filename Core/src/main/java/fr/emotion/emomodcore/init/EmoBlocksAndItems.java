package fr.emotion.emomodcore.init;

import fr.emotion.emomodcore.EmoMain;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoBlocksAndItems {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmoMain.MODID);
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmoMain.MODID);

    public static final DeferredBlock<Block> ADVANCEMENT = BLOCKS.registerSimpleBlock("advancement");
    public static final DeferredItem<BlockItem> ADVANCEMENT_ITEM = ITEMS.registerSimpleBlockItem("advancement", ADVANCEMENT);

    public static void init(IEventBus event) {
        BLOCKS.register(event);
        ITEMS.register(event);
    }
}
