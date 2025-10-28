package fr.emotion.emomoddimension.entity;

import fr.emotion.emomoddimension.init.EmoBlockEntityType;
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

import java.util.UUID;

public class DreamCatcherBlockEntity extends RandomizableContainerBlockEntity {
    private UUID uuid;
    private static final int size = 36 + 4 + 1;
    private NonNullList<ItemStack> items = NonNullList.withSize(size, ItemStack.EMPTY);

    public DreamCatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(EmoBlockEntityType.DREAM_CATCHER.get(), blockPos, blockState);
    }

    // Only one player per dream catcher
    public boolean setPlayer(ServerPlayer player) {
        if (this.uuid==null) {
            this.uuid = player.getUUID();
            this.setChanged();
            return true;
        } else {
            return false;
        }
    }

    public void resetPlayer() {
        this.uuid = null;
    }

    public void storePlayerInventory(ServerPlayer player) {
        if (!this.uuid.equals(player.getUUID())) return;

        for (int i = 0; i < size; i++) {
            this.items.set(i, player.getInventory().removeItemNoUpdate(i));
        }

        this.setChanged();
    }

    public void restorePlayerInventory(ServerPlayer player) {
        if (!this.uuid.equals(player.getUUID())) return;

        for (int i = 0; i < size; i++) {
            ItemStack stack = this.items.get(i);

            if (!stack.isEmpty()) {
                player.getInventory().setItem(i, stack);
                this.items.set(i, ItemStack.EMPTY);
            }
        }

        this.setChanged();
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        if (this.uuid!=null) output.putString("Player", this.uuid.toString());

        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        if (input.getString("Player").isPresent()) this.uuid = UUID.fromString(input.getString("Player").get());

        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return size;
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
