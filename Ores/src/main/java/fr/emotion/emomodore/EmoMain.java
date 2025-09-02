package fr.emotion.emomodore;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoComponents;
import fr.emotion.emomodore.init.EmoItems;
import fr.emotion.emomodore.init.EmoRecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        EmoItems.init(modEventBus);
        EmoBlocks.init(modEventBus);
        EmoComponents.init(modEventBus);
        EmoRecipeSerializer.init(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
