package fr.emotion.emomodfood.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CakeBlock.class)
public interface MixinCakeBlockInvoker {
    @Invoker("eat")
    static InteractionResult invokeEat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        throw new AssertionError();
    }
}
