package fr.emotion.emomodore;

import fr.emotion.emomodore.init.EmoBlocks;
import fr.emotion.emomodore.init.EmoItems;
import fr.emotion.emomodore.item.PhaseValue;
import fr.emotion.emomodore.models.ViridisHumanoidArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
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
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(value = EmoMain.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = EmoMain.MODID, value = Dist.CLIENT)
public class EmoMainClient {
    public static final ModelLayerLocation VIRIDIS_OUTER_ARMOR = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "viridis_armor"), "main");
    public static final ModelLayerLocation VIRIDIS_INNER_ARMOR = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "viridis_armor"), "main");

    public EmoMainClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
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
        }, EmoItems.VIRIDIS_HELMET, EmoItems.VIRIDIS_CHESTPLATE, EmoItems.VIRIDIS_BOOTS);

        event.registerItem(new IClientItemExtensions() {
            private ViridisHumanoidArmorModel<HumanoidRenderState> model;

            @Override
            public Model getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
                ModelPart part = Minecraft.getInstance().getEntityModels().bakeLayer(VIRIDIS_OUTER_ARMOR);
                model = new ViridisHumanoidArmorModel<>(part);
                return model;
            }
        }, EmoItems.VIRIDIS_LEGGINGS);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key==CreativeModeTabs.INGREDIENTS) {
            event.accept(EmoItems.FOSSIL);
            event.accept(EmoItems.PURPURA_SHARD);
            event.accept(EmoItems.LUME_STONE);
        } else if (key==CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(EmoItems.PURPURA_SHOVEL);
            event.accept(EmoItems.PURPURA_PICKAXE);
            event.accept(EmoItems.PURPURA_HOE);

            event.accept(EmoItems.FOSSIL_SHOVEL);
            event.accept(EmoItems.FOSSIL_PICKAXE);
            event.accept(EmoItems.FOSSIL_HOE);

            event.accept(EmoItems.VIRIDIS_HELMET);
            event.accept(EmoItems.VIRIDIS_CHESTPLATE);
            event.accept(EmoItems.VIRIDIS_LEGGINGS);
            event.accept(EmoItems.VIRIDIS_BOOTS);
        } else if (key==CreativeModeTabs.COMBAT) {
            event.accept(EmoItems.PURPURA_SWORD);
            event.accept(EmoItems.PURPURA_AXE);
            event.accept(EmoItems.FOSSIL_SWORD);
            event.accept(EmoItems.FOSSIL_AXE);
        } else if (key==CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(EmoBlocks.FOSSIL_BLOCK);
            event.accept(EmoBlocks.PURPURA_BLOCK);
            event.accept(EmoBlocks.VIRIDIS_BLOCK);
            event.accept(EmoBlocks.LUME_BLOCK);
        } else if (key==CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(EmoBlocks.FOSSIL_ORE);
            event.accept(EmoBlocks.PURPURA_ORE);
            event.accept(EmoBlocks.DEEPSLATE_PURPURA_ORE);
            event.accept(EmoBlocks.VIRIDIS_ORE);
            event.accept(EmoBlocks.VIRIDIS_CRYSTAL);
            event.accept(EmoBlocks.NETHER_LUME_ORE);
        }
    }

    @SubscribeEvent
    public static void registerRangeSelectItemModelProperty(RegisterRangeSelectItemModelPropertyEvent event) {
        event.register(
                ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "phase_value"),
                PhaseValue.MAP_CODEC
        );
    }
}
