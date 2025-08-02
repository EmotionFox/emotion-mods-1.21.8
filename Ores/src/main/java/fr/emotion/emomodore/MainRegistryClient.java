package fr.emotion.emomodore;

import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import fr.emotion.emomodore.item.PhaseValue;
import fr.emotion.emomodore.models.ViridisHumanoidArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = MainRegistry.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MainRegistry.MODID, value = Dist.CLIENT)
public class MainRegistryClient {
    public static final ModelLayerLocation VIRIDIS_OUTER_ARMOR = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis_armor"), "main");
    public static final ModelLayerLocation VIRIDIS_INNER_ARMOR = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis_armor"), "main");

    public MainRegistryClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.VIRIDIS_CRYSTAL.get(), ChunkSectionLayer.CUTOUT);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VIRIDIS_OUTER_ARMOR, () -> ViridisHumanoidArmorModel.createLayer(new CubeDeformation(1.0F)));
        event.registerLayerDefinition(VIRIDIS_INNER_ARMOR, () -> ViridisHumanoidArmorModel.createLayer(new CubeDeformation(0.5F)));
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            private ViridisHumanoidArmorModel<HumanoidRenderState> model;

            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(VIRIDIS_INNER_ARMOR);
                model = new ViridisHumanoidArmorModel<>(part);
                return model;
            }
        }, ItemRegistry.VIRIDIS_HELMET, ItemRegistry.VIRIDIS_CHESTPLATE, ItemRegistry.VIRIDIS_BOOTS);

        event.registerItem(new IClientItemExtensions() {
            private ViridisHumanoidArmorModel<HumanoidRenderState> model;

            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(VIRIDIS_OUTER_ARMOR);
                model = new ViridisHumanoidArmorModel<>(part);
                return model;
            }
        }, ItemRegistry.VIRIDIS_LEGGINGS);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegistry.FOSSIL);
            event.accept(ItemRegistry.PURPURA_SHARD);
            event.accept(ItemRegistry.LUME_STONE);
        } else if (key==CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemRegistry.PURPURA_SHOVEL);
            event.accept(ItemRegistry.PURPURA_PICKAXE);
            event.accept(ItemRegistry.PURPURA_HOE);

            event.accept(ItemRegistry.FOSSIL_SHOVEL);
            event.accept(ItemRegistry.FOSSIL_PICKAXE);
            event.accept(ItemRegistry.FOSSIL_HOE);

            event.accept(ItemRegistry.VIRIDIS_HELMET);
            event.accept(ItemRegistry.VIRIDIS_CHESTPLATE);
            event.accept(ItemRegistry.VIRIDIS_LEGGINGS);
            event.accept(ItemRegistry.VIRIDIS_BOOTS);
        } else if (key==CreativeModeTabs.COMBAT) {
            event.accept(ItemRegistry.PURPURA_SWORD);
            event.accept(ItemRegistry.PURPURA_AXE);
            event.accept(ItemRegistry.FOSSIL_SWORD);
            event.accept(ItemRegistry.FOSSIL_AXE);
        } else if (key==CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockRegistry.FOSSIL_BLOCK);
            event.accept(BlockRegistry.PURPURA_BLOCK);
            event.accept(BlockRegistry.VIRIDIS_BLOCK);
            event.accept(BlockRegistry.LUME_BLOCK);
        } else if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockRegistry.FOSSIL_ORE);
            event.accept(BlockRegistry.PURPURA_ORE);
            event.accept(BlockRegistry.DEEPSLATE_PURPURA_ORE);
            event.accept(BlockRegistry.VIRIDIS_ORE);
            event.accept(BlockRegistry.VIRIDIS_CRYSTAL);
            event.accept(BlockRegistry.NETHER_LUME_ORE);
        }
    }

    @SubscribeEvent
    public static void registerRangeSelectItemModelProperty(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(
                ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "phase_value"),
                PhaseValue.MAP_CODEC
        );
    }
}
