package fr.emotion.emomodfood.init;

import fr.emotion.emomodfood.EmoMain;
import fr.emotion.emomodfood.functions.PotConditionalFunction;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EmoLootItemFunctions {
    private static final DeferredRegister<LootItemFunctionType<?>> LOOT_FUNCTION_TYPE = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, EmoMain.MODID);

    public static final DeferredHolder<LootItemFunctionType<?>, LootItemFunctionType<PotConditionalFunction>> SET_POT = LOOT_FUNCTION_TYPE.register(
            "set_pot",
            () -> new LootItemFunctionType<>(
                    PotConditionalFunction.CODEC
            )
    );

    public static void init(IEventBus event){
        LOOT_FUNCTION_TYPE.register(event);
    }
}
