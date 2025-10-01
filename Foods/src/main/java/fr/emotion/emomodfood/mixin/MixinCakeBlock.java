package fr.emotion.emomodfood.mixin;

import fr.emotion.emomodfood.CandleCakeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.level.block.CakeBlock.BITES;

@Mixin(CakeBlock.class)
public abstract class MixinCakeBlock {

    @Shadow
    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        return null;
    }

    @Inject(method = "useItemOn", at = @At("HEAD"), cancellable = true)
    private void emomodfood$redirectCandlePlacement(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit,
            CallbackInfoReturnable<InteractionResult> cir
    ) {
        Item item = stack.getItem();
        if (stack.is(ItemTags.CANDLES) && state.getValue(BITES)==0 && Block.byItem(item) instanceof CandleBlock candleBlock && state.getBlock() instanceof CakeBlock cakeBlock) {
            BlockState candleCakeState = CandleCakeRegistry.get(cakeBlock, candleBlock);
            stack.consume(1, player);
            level.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlockAndUpdate(pos, candleCakeState);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            player.awardStat(Stats.ITEM_USED.get(item));
            cir.setReturnValue(InteractionResult.SUCCESS);
        } else if (player.canEat(false)) {
            cir.setReturnValue(eat(level, pos, state, player));
        } else {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }
}
