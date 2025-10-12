package fr.emotion.emomodworld.entities;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootTable;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class AbstractFurnaceBoat extends AbstractBoat implements HasCustomInventoryScreen, ContainerEntity {
    private static final int CONTAINER_SIZE = 3;
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
    @Nullable
    private ResourceKey<LootTable> lootTable;
    private long lootTableSeed;

    public AbstractFurnaceBoat(EntityType<? extends AbstractBoat> entityType, Level level, Supplier<Item> supplier) {
        super(entityType, level, supplier);
    }

    @Override
    protected float getSinglePassengerXOffset() {
        return 0.15F;
    }

    @Override
    protected int getMaxPassengers() {
        return 1;
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput p_421797_) {
        super.addAdditionalSaveData(p_421797_);
        this.addChestVehicleSaveData(p_421797_);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput p_421628_) {
        super.readAdditionalSaveData(p_421628_);
        this.readChestVehicleSaveData(p_421628_);
    }

    @Override
    public void destroy(ServerLevel p_376333_, DamageSource p_376433_) {
        this.destroy(p_376333_, this.getDropItem());
        this.chestVehicleDestroyed(p_376433_, p_376333_, this);
    }

    @Override
    public void remove(Entity.RemovalReason p_376764_) {
        if (!this.level().isClientSide() && p_376764_.shouldDestroy()) {
            Containers.dropContents(this.level(), this, this);
        }

        super.remove(p_376764_);
    }

    @Override
    public InteractionResult interact(Player p_376860_, InteractionHand p_376424_) {
        InteractionResult interactionresult = super.interact(p_376860_, p_376424_);
        if (interactionresult!=InteractionResult.PASS) {
            return interactionresult;
        } else if (this.canAddPassenger(p_376860_) && !p_376860_.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else {
            InteractionResult interactionresult1 = this.interactWithContainerVehicle(p_376860_);
            if (interactionresult1.consumesAction() && p_376860_.level() instanceof ServerLevel serverlevel) {
                this.gameEvent(GameEvent.CONTAINER_OPEN, p_376860_);
                PiglinAi.angerNearbyPiglins(serverlevel, p_376860_, true);
            }

            return interactionresult1;
        }
    }

    @Override
    public void openCustomInventoryScreen(Player p_376437_) {
        p_376437_.openMenu(this);
        if (p_376437_.level() instanceof ServerLevel serverlevel) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, p_376437_);
            PiglinAi.angerNearbyPiglins(serverlevel, p_376437_, true);
        }
    }

    @Override
    public void clearContent() {
        this.clearChestVehicleContent();
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public ItemStack getItem(int p_376545_) {
        return this.getChestVehicleItem(p_376545_);
    }

    @Override
    public ItemStack removeItem(int p_376479_, int p_376802_) {
        return this.removeChestVehicleItem(p_376479_, p_376802_);
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_376287_) {
        return this.removeChestVehicleItemNoUpdate(p_376287_);
    }

    @Override
    public void setItem(int p_376127_, ItemStack p_376526_) {
        this.setChestVehicleItem(p_376127_, p_376526_);
    }

    @Override
    public SlotAccess getSlot(int p_376264_) {
        return this.getChestVehicleSlot(p_376264_);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player p_376726_) {
        return this.isChestVehicleStillValid(p_376726_);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        if (this.lootTable!=null && player.isSpectator()) {
            return null;
        } else {
            this.unpackLootTable(inventory.player);
            return ChestMenu.threeRows(id, inventory, this);
        }
    }

    public void unpackLootTable(@Nullable Player player) {
        this.unpackChestVehicleLootTable(player);
    }

    @Nullable
    @Override
    public ResourceKey<LootTable> getContainerLootTable() {
        return this.lootTable;
    }

    @Override
    public void setContainerLootTable(@Nullable ResourceKey<LootTable> p_376327_) {
        this.lootTable = p_376327_;
    }

    @Override
    public long getContainerLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setContainerLootTableSeed(long p_376440_) {
        this.lootTableSeed = p_376440_;
    }

    @Override
    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    @Override
    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    @Override
    public void stopOpen(ContainerUser user) {
        this.level().gameEvent(GameEvent.CONTAINER_CLOSE, this.position(), GameEvent.Context.of(user.getLivingEntity()));
    }
}
