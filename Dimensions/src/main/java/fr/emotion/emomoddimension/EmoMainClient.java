package fr.emotion.emomoddimension;

import fr.emotion.emomoddimension.datagen.setBuilder.EmoDimensionType;
import fr.emotion.emomoddimension.init.EmoBlocks;
import fr.emotion.emomoddimension.init.EmoItems;
import fr.emotion.emomoddimension.world.dimension.DreamEffects;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_SHORT_GRASS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_TALL_GRASS.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.DREAM_GRASS_BLOCK.get(), ChunkSectionLayer.CUTOUT_MIPPED);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(EmoBlocks.DREAM_SHORT_GRASS);
            event.accept(EmoBlocks.DREAM_TALL_GRASS);

            event.accept(EmoBlocks.DREAM_STONE);
            event.accept(EmoBlocks.DREAM_GRASS_BLOCK);
        }
        if (key==CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(EmoItems.DREAM_CATCHER);
        }
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent(RegisterColorHandlersEvent.Block event) {
        BlockColor grassColor = ((state, world, pos, tintIndex) -> (world!=null && pos!=null) ? BiomeColors.getAverageGrassColor(world, pos):GrassColor.getDefaultColor());

        event.register(grassColor, EmoBlocks.DREAM_SHORT_GRASS.get(), EmoBlocks.DREAM_TALL_GRASS.get(), EmoBlocks.DREAM_GRASS_BLOCK.get());
    }

    @SubscribeEvent
    public static void onRegisterDimensionEffects(RegisterDimensionSpecialEffectsEvent event) {
        event.register(
                EmoDimensionType.DREAM_EFFECTS,
                new DreamEffects()
        );
    }
}
