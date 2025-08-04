package fr.emotion.emomodworld;

import fr.emotion.emomodworld.blocks.properties.EmoWoodType;
import fr.emotion.emomodworld.init.EmoBlocks;
import fr.emotion.emomodworld.init.EmoEntityType;
import fr.emotion.emomodworld.init.EmoItems;
import fr.emotion.emomodworld.models.EmoBoatRenderer;
import fr.emotion.emomodworld.models.EmoModelLayers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.special.HangingSignSpecialRenderer;
import net.minecraft.client.renderer.special.StandingSignSpecialRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;
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

        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_SAPLING.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);
        ItemBlockRenderTypes.setRenderLayer(EmoBlocks.PEAR_DOOR.get(), ChunkSectionLayer.CUTOUT);

        event.enqueueWork(() -> {
            Sheets.addWoodType(EmoWoodType.PEAR);
        });
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EmoEntityType.PEAR_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_BOAT));
        event.registerEntityRenderer(EmoEntityType.PEAR_CHEST_BOAT.get(), context -> new EmoBoatRenderer(context, EmoModelLayers.PEAR_CHEST_BOAT));
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(EmoModelLayers.PEAR_BOAT, BoatModel::createBoatModel);
        event.registerLayerDefinition(EmoModelLayers.PEAR_CHEST_BOAT, BoatModel::createChestBoatModel);
    }

    @SubscribeEvent
    public static void BuildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(EmoBlocks.FLOWER_1);
            event.accept(EmoBlocks.FLOWER_2);
            event.accept(EmoBlocks.FLOWER_3);
            event.accept(EmoBlocks.FLOWER_4);
            event.accept(EmoBlocks.FLOWER_5);
            event.accept(EmoBlocks.FLOWER_6);
            event.accept(EmoBlocks.FLOWER_7);
            event.accept(EmoBlocks.FLOWER_8);
            event.accept(EmoBlocks.FLOWER_9);
            event.accept(EmoBlocks.PEAR_LOG);
            event.accept(EmoBlocks.PEAR_LEAVES);
            event.accept(EmoBlocks.PEAR_SAPLING);
        } else if (key==CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(EmoBlocks.PEAR_LOG);
            event.accept(EmoBlocks.PEAR_WOOD);
            event.accept(EmoBlocks.STRIPPED_PEAR_LOG);
            event.accept(EmoBlocks.STRIPPED_PEAR_WOOD);
            event.accept(EmoBlocks.PEAR_PLANKS);
            event.accept(EmoBlocks.PEAR_STAIRS);
            event.accept(EmoBlocks.PEAR_SLAB);
            event.accept(EmoBlocks.PEAR_FENCE);
            event.accept(EmoBlocks.PEAR_FENCE_GATE);
            event.accept(EmoBlocks.PEAR_DOOR);
            event.accept(EmoBlocks.PEAR_TRAPDOOR);
            event.accept(EmoBlocks.PEAR_PRESSURE_PLATE);
            event.accept(EmoBlocks.PEAR_BUTTON);
        } else if (key==CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(EmoBlocks.PEAR_SIGN);
            event.accept(EmoBlocks.PEAR_HANGING_SIGN);
        } else if (key==CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(EmoItems.PEAR_BOAT);
            event.accept(EmoItems.PEAR_CHEST_BOAT);
        }
    }

    @SubscribeEvent
    public static void onRegisterSpecialBlockModelRenderer(RegisterSpecialBlockModelRendererEvent event) {
        event.register(
                EmoBlocks.PEAR_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_WALL_SIGN.get(),
                new StandingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
        event.register(
                EmoBlocks.PEAR_WALL_HANGING_SIGN.get(),
                new HangingSignSpecialRenderer.Unbaked(EmoWoodType.PEAR)
        );
    }

    @SubscribeEvent
    public static void onRegisterColorHandlersEvent(RegisterColorHandlersEvent.Block event) {
        int baseColor = 0x6A9E3F;

        BlockColor foliageColor = (state, world, pos, tintIndex) -> {
            if (world!=null && pos!=null) {
                int biomeColor = BiomeColors.getAverageFoliageColor(world, pos);
                return blendColors(baseColor, biomeColor, 0.5F);
            }

            return baseColor;
        };

        event.register(foliageColor, EmoBlocks.PEAR_LEAVES.get(), EmoBlocks.PEAR_SAPLING.get());
    }

    public static int blendColors(int color1, int color2, float ratio) {
        float inverseRatio = 1.0F - ratio;
        int r = (int) (((color1 >> 16 & 0xFF) * ratio) + ((color2 >> 16 & 0xFF) * inverseRatio));
        int g = (int) (((color1 >> 8 & 0xFF) * ratio) + ((color2 >> 8 & 0xFF) * inverseRatio));
        int b = (int) (((color1 & 0xFF) * ratio) + ((color2 & 0xFF) * inverseRatio));

        return (r << 16) | (g << 8) | b;
    }
}
