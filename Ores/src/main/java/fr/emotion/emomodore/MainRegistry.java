package fr.emotion.emomodore;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ComponentRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import fr.emotion.emomodore.init.RecipeSerializerRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(MainRegistry.MODID)
public class MainRegistry {
    public static final String MODID = "emomodore";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MainRegistry(IEventBus modEventBus, ModContainer modContainer) {
        ItemRegistry.init(modEventBus);
        BlockRegistry.init(modEventBus);
        ComponentRegistry.init(modEventBus);
        RecipeSerializerRegistry.init(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
