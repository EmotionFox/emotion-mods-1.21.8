package fr.emotion.emomodfood;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodfood.blocks.entity.PotSpecialRenderer;
import fr.emotion.emomodfood.init.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.RegisterSpecialBlockModelRendererEvent;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomodfood";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::onRegisterSpecialBlockRenderers);

        modEventBus.addListener(this::commonSetup);
        EmoBlocks.init(modEventBus);
        EmoItems.init(modEventBus);
        EmoBlockEntityTypes.init(modEventBus);
        EmoComponents.init(modEventBus);
        EmoDataComponentPredicates.init(modEventBus);
        EmoRecipeSerializer.init(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.CANDLE, (CandleCakeBlock) Blocks.CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.WHITE_CANDLE, (CandleCakeBlock) Blocks.WHITE_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.ORANGE_CANDLE, (CandleCakeBlock) Blocks.ORANGE_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.MAGENTA_CANDLE, (CandleCakeBlock) Blocks.MAGENTA_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) Blocks.LIGHT_BLUE_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.YELLOW_CANDLE, (CandleCakeBlock) Blocks.YELLOW_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.LIME_CANDLE, (CandleCakeBlock) Blocks.LIME_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.PINK_CANDLE, (CandleCakeBlock) Blocks.PINK_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.GRAY_CANDLE, (CandleCakeBlock) Blocks.GRAY_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) Blocks.LIGHT_GRAY_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.CYAN_CANDLE, (CandleCakeBlock) Blocks.CYAN_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.PURPLE_CANDLE, (CandleCakeBlock) Blocks.PURPLE_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.BLUE_CANDLE, (CandleCakeBlock) Blocks.BLUE_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.BROWN_CANDLE, (CandleCakeBlock) Blocks.BROWN_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.GREEN_CANDLE, (CandleCakeBlock) Blocks.GREEN_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.RED_CANDLE, (CandleCakeBlock) Blocks.RED_CANDLE_CAKE);
            CandleCakeRegistry.register((CakeBlock) Blocks.CAKE, (CandleBlock) Blocks.BLACK_CANDLE, (CandleCakeBlock) Blocks.BLACK_CANDLE_CAKE);

            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.CANDLE, (CandleCakeBlock) EmoBlocks.CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.WHITE_CANDLE, (CandleCakeBlock) EmoBlocks.WHITE_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.ORANGE_CANDLE, (CandleCakeBlock) EmoBlocks.ORANGE_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.MAGENTA_CANDLE, (CandleCakeBlock) EmoBlocks.MAGENTA_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.YELLOW_CANDLE, (CandleCakeBlock) EmoBlocks.YELLOW_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.LIME_CANDLE, (CandleCakeBlock) EmoBlocks.LIME_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.PINK_CANDLE, (CandleCakeBlock) EmoBlocks.PINK_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.GRAY_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.CYAN_CANDLE, (CandleCakeBlock) EmoBlocks.CYAN_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.PURPLE_CANDLE, (CandleCakeBlock) EmoBlocks.PURPLE_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.BLUE_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.BROWN_CANDLE, (CandleCakeBlock) EmoBlocks.BROWN_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.GREEN_CANDLE, (CandleCakeBlock) EmoBlocks.GREEN_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.RED_CANDLE, (CandleCakeBlock) EmoBlocks.RED_CANDLE_CAKE_CHOCOLATE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_CHOCOLATE.get(), (CandleBlock) Blocks.BLACK_CANDLE, (CandleCakeBlock) EmoBlocks.BLACK_CANDLE_CAKE_CHOCOLATE.get());

            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.CANDLE, (CandleCakeBlock) EmoBlocks.CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.WHITE_CANDLE, (CandleCakeBlock) EmoBlocks.WHITE_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.ORANGE_CANDLE, (CandleCakeBlock) EmoBlocks.ORANGE_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.MAGENTA_CANDLE, (CandleCakeBlock) EmoBlocks.MAGENTA_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.YELLOW_CANDLE, (CandleCakeBlock) EmoBlocks.YELLOW_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.LIME_CANDLE, (CandleCakeBlock) EmoBlocks.LIME_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.PINK_CANDLE, (CandleCakeBlock) EmoBlocks.PINK_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.GRAY_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.CYAN_CANDLE, (CandleCakeBlock) EmoBlocks.CYAN_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.PURPLE_CANDLE, (CandleCakeBlock) EmoBlocks.PURPLE_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.BLUE_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.BROWN_CANDLE, (CandleCakeBlock) EmoBlocks.BROWN_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.GREEN_CANDLE, (CandleCakeBlock) EmoBlocks.GREEN_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.RED_CANDLE, (CandleCakeBlock) EmoBlocks.RED_CANDLE_CAKE_FRUIT.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_FRUIT.get(), (CandleBlock) Blocks.BLACK_CANDLE, (CandleCakeBlock) EmoBlocks.BLACK_CANDLE_CAKE_FRUIT.get());

            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.CANDLE, (CandleCakeBlock) EmoBlocks.CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.WHITE_CANDLE, (CandleCakeBlock) EmoBlocks.WHITE_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.ORANGE_CANDLE, (CandleCakeBlock) EmoBlocks.ORANGE_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.MAGENTA_CANDLE, (CandleCakeBlock) EmoBlocks.MAGENTA_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.YELLOW_CANDLE, (CandleCakeBlock) EmoBlocks.YELLOW_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.LIME_CANDLE, (CandleCakeBlock) EmoBlocks.LIME_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.PINK_CANDLE, (CandleCakeBlock) EmoBlocks.PINK_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.GRAY_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.CYAN_CANDLE, (CandleCakeBlock) EmoBlocks.CYAN_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.PURPLE_CANDLE, (CandleCakeBlock) EmoBlocks.PURPLE_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.BLUE_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.BROWN_CANDLE, (CandleCakeBlock) EmoBlocks.BROWN_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.GREEN_CANDLE, (CandleCakeBlock) EmoBlocks.GREEN_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.RED_CANDLE, (CandleCakeBlock) EmoBlocks.RED_CANDLE_CAKE_TOFFEE.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_TOFFEE.get(), (CandleBlock) Blocks.BLACK_CANDLE, (CandleCakeBlock) EmoBlocks.BLACK_CANDLE_CAKE_TOFFEE.get());

            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.CANDLE, (CandleCakeBlock) EmoBlocks.CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.WHITE_CANDLE, (CandleCakeBlock) EmoBlocks.WHITE_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.ORANGE_CANDLE, (CandleCakeBlock) EmoBlocks.ORANGE_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.MAGENTA_CANDLE, (CandleCakeBlock) EmoBlocks.MAGENTA_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_BLUE_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.YELLOW_CANDLE, (CandleCakeBlock) EmoBlocks.YELLOW_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.LIME_CANDLE, (CandleCakeBlock) EmoBlocks.LIME_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.PINK_CANDLE, (CandleCakeBlock) EmoBlocks.PINK_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.GRAY_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) EmoBlocks.LIGHT_GRAY_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.CYAN_CANDLE, (CandleCakeBlock) EmoBlocks.CYAN_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.PURPLE_CANDLE, (CandleCakeBlock) EmoBlocks.PURPLE_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.BLUE_CANDLE, (CandleCakeBlock) EmoBlocks.BLUE_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.BROWN_CANDLE, (CandleCakeBlock) EmoBlocks.BROWN_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.GREEN_CANDLE, (CandleCakeBlock) EmoBlocks.GREEN_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.RED_CANDLE, (CandleCakeBlock) EmoBlocks.RED_CANDLE_CAKE_STRAWBERRY.get());
            CandleCakeRegistry.register((CakeBlock) EmoBlocks.CAKE_STRAWBERRY.get(), (CandleBlock) Blocks.BLACK_CANDLE, (CandleCakeBlock) EmoBlocks.BLACK_CANDLE_CAKE_STRAWBERRY.get());
        });
    }

    public void onRegisterSpecialBlockRenderers(RegisterSpecialBlockModelRendererEvent event) {
        event.register(
                EmoBlocks.POT.get(),
                new PotSpecialRenderer.Unbaked(ResourceLocation.fromNamespaceAndPath(EmoMain.MODID, "entity/pot_special"))
        );
    }
}
