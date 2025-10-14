package fr.emotion.emomoddimension;

import com.mojang.logging.LogUtils;
import fr.emotion.emomoddimension.entity.DreamCatcherBlockEntity;
import fr.emotion.emomoddimension.entity.goal.EmoEatBlockGoal;
import fr.emotion.emomoddimension.init.EmoBlockEntityType;
import fr.emotion.emomoddimension.init.EmoBlockType;
import fr.emotion.emomoddimension.init.EmoBlocks;
import fr.emotion.emomoddimension.init.EmoItems;
import fr.emotion.emomoddimension.utils.DreamTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.portal.TeleportTransition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.CanPlayerSleepEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

@Mod(EmoMain.MODID)
public class EmoMain {
    public static final String MODID = "emomoddimension";
    public static final Logger LOGGER = LogUtils.getLogger();

    public EmoMain(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        EmoItems.init(modEventBus);
        EmoBlocks.init(modEventBus);
        EmoBlockEntityType.init(modEventBus);
        EmoBlockType.init(modEventBus);

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
                        sheep.goalSelector.removeGoal(goal);
                        sheep.goalSelector.addGoal(wrappedGoal.getPriority(), new EmoEatBlockGoal(sheep));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerSleep(CanPlayerSleepEvent event) {
        boolean flag = event.getProblem()==null;
        ServerPlayer player = event.getEntity();

        if (flag) {
            ServerLevel serverLevel = player.level();
            BlockPos playerPos = player.blockPosition();
            List<DreamCatcherBlockEntity> blockEntities = DreamTeleporter.findDreamCatcherBlockEntity(serverLevel, playerPos, 4, true);

            if (!blockEntities.isEmpty()) {
                blockEntities.getFirst().storePlayerInventory(player);

                CompoundTag data = player.getPersistentData();
                data.putBoolean("Dreaming", true);
                // SHOULD BE 12000 OTHER VALUE FOR TESTING PURPOSE
                data.putLong("Awakening", serverLevel.getGameTime() + 1000);
                event.setProblem(Player.BedSleepingProblem.OTHER_PROBLEM);

                TeleportTransition transition = DreamTeleporter.getPortalDestination(serverLevel, player, playerPos);

                if (transition!=null) player.teleport(transition);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) return;

        ServerLevel serverLevel = (ServerLevel) player.level();

        BlockPos playerPos = player.blockPosition();
        CompoundTag data = player.getPersistentData();
        Optional<Long> awakening = data.getLong("Awakening");

        if (data.getBooleanOr("Dreaming", false)) {
            if (awakening.isPresent() && serverLevel.getGameTime() >= awakening.get()) {
                data.remove("Dreaming");
                data.putLong("Awakening", serverLevel.getGameTime() + 10);

                TeleportTransition transition = DreamTeleporter.getPortalDestination(serverLevel, player, playerPos);

                if (transition!=null) {
                    player.teleport(transition);
                }
            }
        } else if (awakening.isPresent() && serverLevel.getGameTime() >= awakening.get() && player.getUUID() != null) {
            data.remove("Awakening");
            List<DreamCatcherBlockEntity> blockEntities = DreamTeleporter.findDreamCatcherBlockEntity(serverLevel, playerPos, 4, false);

            if (!blockEntities.isEmpty()) {
                for (DreamCatcherBlockEntity blockEntity : blockEntities) {
                    if (blockEntity.playerUUIDMatch(player.getUUID())) {
                        blockEntity.restorePlayerInventory(player);
                        break;
                    }
                }
            }
        }
    }
}
