package fr.emotion.emomoddimension.entity;

import fr.emotion.emomoddimension.init.EmoBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.Optional;
import java.util.UUID;

public class DreamCatcherBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(36, ItemStack.EMPTY);
    private UUID playerUUID;

    public DreamCatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(EmoBlockEntityType.DREAM_CATCHER.get(), blockPos, blockState);
    }

    public void storePlayerInventory(Player player) {
        for (int i = 0; i < 36; i++) {
            this.items.set(i, player.getInventory().getItem(i).copy());
            player.getInventory().setItem(i, ItemStack.EMPTY);
        }

        this.playerUUID = player.getUUID();
        this.getPersistentData().putString("playerUUID", playerUUID.toString());
        this.setChanged();
    }

    public void restorePlayerInventory(Player player) {
        for (int i = 0; i < 36; i++) {
            ItemStack stack = this.items.get(i);

            if (!stack.isEmpty()) {
                player.getInventory().setItem(i, stack);
                this.items.set(i, ItemStack.EMPTY);
            } else {
                player.getInventory().setItem(i, ItemStack.EMPTY);
            }
        }
        this.setChanged();
    }

    public boolean playerUUIDMatch(UUID testUUID) {
        return this.playerUUID.equals(testUUID);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }

        if (this.playerUUID!=null) {
            output.putString("playerUUID", this.playerUUID.toString());
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }

        Optional<String> optional = input.getString("playerUUID");
        optional.ifPresent(s -> this.playerUUID = UUID.fromString(s));

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
