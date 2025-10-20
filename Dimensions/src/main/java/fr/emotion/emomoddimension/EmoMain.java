package fr.emotion.emomoddimension;

import com.mojang.logging.LogUtils;
import fr.emotion.emomodcore.utils.DreamDataSyncer;
import fr.emotion.emomoddimension.entity.DreamCatcherBlockEntity;
import fr.emotion.emomoddimension.entity.goal.EmoEatBlockGoal;
import fr.emotion.emomoddimension.init.*;
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
import net.minecraft.world.level.LevelAccessor;
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
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.SleepFinishedTimeEvent;
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
        EmoCriteriaTriggers.init(modEventBus);

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

        if (flag && player.getRandom().nextInt(2)==0) {
            ServerLevel serverLevel = player.level();
            BlockPos playerPos = player.blockPosition();
            List<DreamCatcherBlockEntity> blockEntities = DreamTeleporter.findDreamCatcherBlockEntity(serverLevel, playerPos, 4, true);
            CompoundTag data = player.getPersistentData();

            if (!blockEntities.isEmpty()) {
                double distSqr = 0;
                DreamCatcherBlockEntity selectedBlockEntity = blockEntities.getFirst();

                if (blockEntities.size() > 1) {
                    for (DreamCatcherBlockEntity blockEntity : blockEntities) {
                        BlockPos blockEntityPos = blockEntity.getBlockPos();
                        double newDistSqr = playerPos.distToCenterSqr(blockEntityPos.getCenter());

                        if (distSqr==0 || newDistSqr < distSqr) {
                            distSqr = newDistSqr;
                            selectedBlockEntity = blockEntity;
                        }
                    }
                }

                boolean flag2 = selectedBlockEntity.setPlayer(player);

                if (flag2) {
                    data.putLong("DreamCatcher", selectedBlockEntity.getBlockPos().asLong());
                    data.putBoolean("BadDream", player.getRandom().nextBoolean());
                }
            } else {
                data.remove("DreamCatcher");
                data.remove("BadDream");
            }
        }
    }

    @SubscribeEvent
    public void onSleepFinished(SleepFinishedTimeEvent event) {
        if (!event.getLevel().isClientSide()) {
            LevelAccessor level = event.getLevel();
            for (Player player : level.players()) {
                CompoundTag data = player.getPersistentData();

                if (data.getLong("DreamCatcher").isPresent()) {
                    data.putBoolean("Dreaming", true);
                }
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

        Optional<Long> dreamCatcher = data.getLong("DreamCatcher");
        Optional<Boolean> badDream = data.getBoolean("BadDream");
        Optional<Boolean> dreaming = data.getBoolean("Dreaming");
        Optional<Long> awakening = data.getLong("Awakening");

        if (dreaming.isPresent() && dreaming.get()) {
            if (awakening.isPresent() && serverLevel.getGameTime() >= awakening.get()) {
                data.remove("Dreaming");
                data.putLong("Awakening", serverLevel.getGameTime() + 10);
                DreamDataSyncer.reset((ServerPlayer) player);

                TeleportTransition transition = DreamTeleporter.getPortalDestination(serverLevel, player, playerPos);

                if (transition!=null) {
                    player.teleport(transition);
                }
            } else if (awakening.isEmpty()) {
                if (dreamCatcher.isPresent()) {
                    BlockPos catcherPos = BlockPos.of(dreamCatcher.get());

                    if (serverLevel.getBlockEntity(catcherPos)!=null && serverLevel.getBlockEntity(catcherPos) instanceof DreamCatcherBlockEntity blockEntity) {
                        blockEntity.storePlayerInventory((ServerPlayer) player);
                    }
                }

                // SHOULD BE DreamClientData.period
                long awakeningValue = serverLevel.getGameTime() + DreamTeleporter.dreamPeriod;
                DreamDataSyncer.sync((ServerPlayer) player, awakeningValue, DreamTeleporter.dreamPeriod, true);
                data.putLong("Awakening", awakeningValue);

                EmoMain.LOGGER.info("BadDream = {}", badDream.orElseGet(() -> false));

                TeleportTransition transition = DreamTeleporter.getPortalDestination(serverLevel, player, playerPos);

                if (transition!=null) player.teleport(transition);

                data.remove("BadDream");
            }
        } else {
            if (awakening.isPresent() && serverLevel.getGameTime() >= awakening.get()) {
                if (dreamCatcher.isPresent()) {
                    BlockPos catcherPos = BlockPos.of(dreamCatcher.get());

                    if (serverLevel.getBlockEntity(catcherPos)!=null && serverLevel.getBlockEntity(catcherPos) instanceof DreamCatcherBlockEntity blockEntity) {
                        blockEntity.restorePlayerInventory((ServerPlayer) player);
                    }
                }

                data.remove("DreamCatcher");
                data.remove("BadDream");
                data.remove("Dreaming");
                data.remove("Awakening");
            }
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        Optional<Long> awakening = event.getEntity().getPersistentData().getLong("Awakening");

        if (!(event.getEntity() instanceof ServerPlayer serverPlayer)) return;

        if (awakening.isPresent()) {
            DreamDataSyncer.sync(serverPlayer, awakening.get(), DreamTeleporter.dreamPeriod, true);
        } else {
            DreamDataSyncer.reset(serverPlayer);
        }
    }
}
