package fr.emotion.emomoddimension.entity;

import fr.emotion.emomoddimension.EmoMain;
import fr.emotion.emomoddimension.init.EmoBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.Optional;
import java.util.UUID;

public class DreamCatcherBlockEntity extends BlockEntity {
    private final ItemStackHandler inventory = new ItemStackHandler(36);
    private UUID playerUUID;

    public DreamCatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(EmoBlockEntityType.DREAM_CATCHER.get(), blockPos, blockState);
    }

    public void storePlayerInventory(Player player) {
        for (int i = 0; i < 36; i++) {
            inventory.setStackInSlot(i, player.getInventory().getItem(i).copy());
            player.getInventory().setItem(i, ItemStack.EMPTY);
        }

        playerUUID = player.getUUID();
        this.getPersistentData().putString("playerUUID", playerUUID.toString());
    }

    public void restorePlayerInventory(Player player) {
        EmoMain.LOGGER.info("RESTORING INV");
        for (int i = 0; i < 36; i++) {
            ItemStack stack = inventory.getStackInSlot(i);

            if (!stack.isEmpty()) {
                player.getInventory().setItem(i, stack);
                inventory.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }

    public boolean playerUUIDMatch(UUID testUUID) {
        return playerUUID.equals(testUUID);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        inventory.serialize(output);

        if (playerUUID!=null) {
            output.putString("playerUUID", playerUUID.toString());
        }

        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        inventory.deserialize(input);

        Optional<String> optional = input.getString("playerUUID");
        optional.ifPresent(s -> playerUUID = UUID.fromString(s));

        super.loadAdditional(input);
    }
}
