package fr.emotion.emomoddimension;

import com.mojang.logging.LogUtils;
import fr.emotion.emomoddimension.entity.goal.EmoEatBlockGoal;
import fr.emotion.emomoddimension.init.EmoBlocks;
import fr.emotion.emomoddimension.init.EmoItems;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import org.slf4j.Logger;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomoddimension";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        EmoItems.init(modEventBus);
        EmoBlocks.init(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_SHORT_GRASS.get(), 60, 100);
        ((FireBlock) Blocks.FIRE).setFlammable(EmoBlocks.DREAM_TALL_GRASS.get(), 60, 100);
    }

    @SubscribeEvent
    private void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Sheep sheep) {
            for (WrappedGoal wrappedGoal : sheep.goalSelector.getAvailableGoals()) {
                if (wrappedGoal!=null) {
                    Goal goal = wrappedGoal.getGoal();

                    if (goal instanceof EatBlockGoal) {
                        EmoMain.LOGGER.info("ADDING GOAL !");
                        sheep.goalSelector.removeGoal(goal);
                        sheep.goalSelector.addGoal(wrappedGoal.getPriority(), new EmoEatBlockGoal(sheep));
                    }
                }
            }
        }
    }
}
