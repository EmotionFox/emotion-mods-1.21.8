package fr.emotion.emomodfood.functions;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.emotion.emomodfood.blocks.entity.PotBlockEntity;
import fr.emotion.emomodfood.components.PotRecord;
import fr.emotion.emomodfood.init.EmoLootItemFunctions;
import fr.emotion.emomodfood.utils.EmoUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.List;

//Just bcs I'm unsure how to use CopyComponentsFunction
public class PotConditionalFunction extends LootItemConditionalFunction {
    public static final MapCodec<PotConditionalFunction> CODEC = RecordCodecBuilder.mapCodec(
            instance -> commonFields(instance).apply(instance, PotConditionalFunction::new)
    );

    protected PotConditionalFunction(List<LootItemCondition> predicates) {
        super(predicates);
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return EmoLootItemFunctions.SET_POT.get();
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        BlockEntity be = context.getOptionalParameter(LootContextParams.BLOCK_ENTITY);

        if (be instanceof PotBlockEntity potBE) {
            PotRecord record = new PotRecord(
                    potBE.getContentType().getName(),
                    potBE.getFillLevel()
            );
            return EmoUtils.definePotDataComponents(stack, record);
        }

        return stack;
    }

    public static LootItemConditionalFunction.Builder<?> copyPotData() {
        return simpleBuilder(PotConditionalFunction::new);
    }
}
