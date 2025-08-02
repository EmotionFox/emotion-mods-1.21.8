package fr.emotion.emomodworld;

import fr.emotion.emomodworld.init.EmoBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        EmoMain.LOGGER.info("HELLO FROM CLIENT SETUP");
        EmoMain.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_1.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_2.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_3.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_4.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_5.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_6.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_7.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_8.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.FLOWER_9.get(), ChunkSectionLayer.CUTOUT);

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_1.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_2.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_3.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_4.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_5.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_6.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_7.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_8.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.POTTED_FLOWER_9.get(), ChunkSectionLayer.CUTOUT);
    }

    @SubscribeEvent
    public static void BuildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(EmoBlocks.FLOWER_1.asItem());
            event.accept(EmoBlocks.FLOWER_2.asItem());
            event.accept(EmoBlocks.FLOWER_3.asItem());
            event.accept(EmoBlocks.FLOWER_4.asItem());
            event.accept(EmoBlocks.FLOWER_5.asItem());
            event.accept(EmoBlocks.FLOWER_6.asItem());
            event.accept(EmoBlocks.FLOWER_7.asItem());
            event.accept(EmoBlocks.FLOWER_8.asItem());
            event.accept(EmoBlocks.FLOWER_9.asItem());
        }
    }
}
