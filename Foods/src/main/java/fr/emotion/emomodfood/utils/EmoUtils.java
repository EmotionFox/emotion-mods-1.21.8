package fr.emotion.emomodfood.utils;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import fr.emotion.emomodfood.blocks.entity.PotModel;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoComponents;
import fr.emotion.emomodfood.models.EmoModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;

import java.util.List;

public class EmoUtils {
    public static ItemStack definePotDataComponents(ItemStack stack, PotRecord component) {
        stack.set(EmoComponents.POT, component);
        stack.set(DataComponents.ITEM_NAME, Component.translatable("item." + EmoMain.MODID + ".pot_" + component.contentType()));
        stack.set(DataComponents.LORE, stack.getOrDefault(DataComponents.LORE, new ItemLore(List.of())).withLineAdded(Component.translatable("tooltip." + EmoMain.MODID + ".pot.fill_level", component.fillLevel(), PotBlockEntity.maxLevel)));

        return stack;
    }

    public static List<PotModel> getPots(BlockEntityRendererProvider.Context context){
        return List.of(
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER1)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER2)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER3)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER4))
        );
    }

    public static List<PotModel> getPots(SpecialModelRenderer.BakingContext context){
        return List.of(
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER1)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER2)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER3)),
                new PotModel(context.entityModelSet().bakeLayer(EmoModelLayers.POT_LAYER4))
        );
    }
}
