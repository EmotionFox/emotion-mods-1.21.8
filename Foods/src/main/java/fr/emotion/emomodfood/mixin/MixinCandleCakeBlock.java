package fr.emotion.emomodfood.mixin;

import fr.emotion.emomodfood.CandleCakeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
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
        BlockState cakeState = CandleCakeRegistry.getCakeForCandleCake((CandleCakeBlock) state.getBlock());
        InteractionResult interactionResult = MixinCakeBlockInvoker.invokeEat(level, pos, cakeState, player);
        if (interactionResult.consumesAction()) {
            dropResources(state, level, pos);
        }

        cir.setReturnValue(interactionResult);
    }

    @Inject(method = "getCloneItemStack", at = @At("HEAD"), cancellable = true)
    protected void emomodfood$fixCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, CallbackInfoReturnable<ItemStack> cir) {
        cir.setReturnValue(new ItemStack(CandleCakeRegistry.getCakeForCandleCake((CandleCakeBlock) state.getBlock()).getBlock()));
    }
}
