package fr.emotion.emomodfurniture;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodfurniture.init.EmoBlockEntityTypes;
import fr.emotion.emomodfurniture.init.EmoBlocks;
import fr.emotion.emomodfurniture.init.EmoItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodfurniture";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        EmoBlocks.init(modEventBus);
        EmoItems.init(modEventBus);
        EmoBlockEntityTypes.init(modEventBus);
    }
}
