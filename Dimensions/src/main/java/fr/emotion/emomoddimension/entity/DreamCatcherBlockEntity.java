package fr.emotion.emomoddimension.entity;

import fr.emotion.emomoddimension.init.EmoBlockEntityType;
import fr.emotion.emomoddimension.init.EmoCriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class DreamCatcherBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(36, ItemStack.EMPTY);

    public DreamCatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(EmoBlockEntityType.DREAM_CATCHER.get(), blockPos, blockState);
    }

    public void storePlayerInventory(ServerPlayer player) {
        for (int i = 0; i < 36; i++) {
            this.items.set(i, player.getInventory().getItem(i).copy());
            player.getInventory().setItem(i, ItemStack.EMPTY);
        }

        this.setChanged();
    }

    public void restorePlayerInventory(ServerPlayer player) {
        int lost = 0;

        for (int i = 0; i < 36; i++) {
            ItemStack stack = this.items.get(i);

            if (!player.getInventory().getItem(i).isEmpty()) {
                lost++;
                ItemStack lostStack = player.getInventory().getItem(i);
                player.displayClientMessage(Component.translatable("dream.lost_item").append(lostStack.getCount() + " " + lostStack.getItemName().getString()), false);
            }

            if (!stack.isEmpty()) {
                player.getInventory().setItem(i, stack);
                this.items.set(i, ItemStack.EMPTY);
            } else {
                player.getInventory().setItem(i, ItemStack.EMPTY);
            }
        }

        if (lost==36) EmoCriteriaTriggers.DREAM_LOSS.get().trigger(player);

        this.setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return 36;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.dream_catcher");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return null;
    }
}
