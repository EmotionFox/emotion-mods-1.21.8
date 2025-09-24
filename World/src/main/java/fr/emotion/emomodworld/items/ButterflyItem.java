package fr.emotion.emomodworld.items;

import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.init.EmoEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class ButterflyItem extends Item {
    private final Butterfly.ButterflyVariant variant;

    public ButterflyItem(Properties properties, Butterfly.ButterflyVariant variant) {
        super(properties);
        this.variant = variant;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level instanceof ServerLevel serverLevel) {
            Butterfly butterfly = EmoEntityType.BUTTERFLY.get().create(serverLevel, EntitySpawnReason.SPAWN_ITEM_USE);

            if (butterfly==null) {
                return InteractionResult.PASS;
            } else {
                ItemStack itemStack = player.getItemInHand(hand);
                BlockPos blockPos = player.blockPosition().relative(player.getDirection()).above();

                if (!serverLevel.isEmptyBlock(blockPos)) blockPos = player.blockPosition().above();

                butterfly.setPos(blockPos.getCenter());
                butterfly.setYHeadRot(player.getYHeadRot());
                butterfly.setVariant(this.variant);
                serverLevel.addFreshEntity(butterfly);

                itemStack.consume(1, player);
                player.awardStat(Stats.ITEM_USED.get(this));
                level.gameEvent(player, GameEvent.ENTITY_PLACE, butterfly.position());
                return InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.SUCCESS;
        }
    }
}
