package fr.emotion.emomodfood.mixin;

import fr.emotion.emomodfood.CandleCakeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.level.block.Block.dropResources;

@Mixin(CandleCakeBlock.class)
public abstract class MixinCandleCakeBlock {

    @Inject(method = "useWithoutItem", at = @At("HEAD"), cancellable = true)
    private void emomodfood$fixEating(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
        if (state.getBlock() instanceof CandleCakeBlock candleCakeBlock) {
            BlockState cakeState = CandleCakeRegistry.getCakeForCandleCake(candleCakeBlock);
            InteractionResult interactionResult = InteractionResult.FAIL;

            if (!player.canEat(false)) {
                interactionResult = InteractionResult.PASS;
            } else {
                dropResources(state, level, pos);

                player.awardStat(Stats.EAT_CAKE_SLICE);
                player.getFoodData().eat(2, 0.1F);
                int i = cakeState.getValue(CakeBlock.BITES);
                level.gameEvent(player, GameEvent.EAT, pos);

                if (i < 6) {
                    level.setBlock(pos, cakeState.setValue(CakeBlock.BITES, i + 1), 3);
                } else {
                    level.removeBlock(pos, false);
                    level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
                }

                interactionResult = InteractionResult.SUCCESS;
            }

            cir.setReturnValue(interactionResult);
        } else {
            cir.setReturnValue(InteractionResult.PASS);
        }
    }

    @Inject(method = "getCloneItemStack", at = @At("HEAD"), cancellable = true)
    protected void emomodfood$fixCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, CallbackInfoReturnable<ItemStack> cir) {
        if (state.getBlock() instanceof CandleCakeBlock candleCakeBlock)
            cir.setReturnValue(new ItemStack(CandleCakeRegistry.getCakeForCandleCake(candleCakeBlock).getBlock()));
        else
            cir.setReturnValue(new ItemStack(Blocks.CAKE));
    }
}
