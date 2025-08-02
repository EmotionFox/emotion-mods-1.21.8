package fr.emotion.emomodore.block;

import fr.emotion.emomodore.block.state.EmoBlockStateProperties;
import fr.emotion.emomodore.components.PhaseRecord;
import fr.emotion.emomodore.init.ComponentRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import java.util.List;

public class FadingBlock extends Block {
    public FadingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(EmoBlockStateProperties.PHASE, 4));
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(EmoBlockStateProperties.PHASE) > 0;
    }

    protected boolean scanForAir(BlockGetter getter, BlockPos pos, boolean setFire) {
        for (Direction dir : Direction.values()) {
            if (getter.getBlockState(pos.relative(dir)).isAir()) {
                if (setFire && getter instanceof ServerLevel level) {
                    if (level.getBlockState(pos.relative(Direction.UP)).isAir())
                        level.setBlockAndUpdate(pos.relative(Direction.UP), Blocks.FIRE.defaultBlockState());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EmoBlockStateProperties.PHASE);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        int phase = state.getValue(EmoBlockStateProperties.PHASE);
        ItemStack stack = new ItemStack(this.asItem());

        stack.set(ComponentRegistry.PHASE, new PhaseRecord(phase));
        stack.set(DataComponents.LORE, new ItemLore(List.of(
                Component.translatable("item.emomodore.phase.tooltip").append(": " + phase).withStyle(ChatFormatting.DARK_AQUA)
        )));

        return stack;
    }
}
