package fr.emotion.emomodworld.items;

import fr.emotion.emomodworld.entities.butterfly.Butterfly;
import fr.emotion.emomodworld.init.EmoItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

public class ButterflyNetItem extends Item {
    public ButterflyNetItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return 100;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof Butterfly butterfly) {
            Item drop = null;

            switch (butterfly.getVariant()) {
                case BROWN:
                    drop = EmoItems.BUTTERFLY_BROWN.get();
                    break;
                case GREEN:
                    drop = EmoItems.BUTTERFLY_GREEN.get();
                    break;
                case PINK:
                    drop = EmoItems.BUTTERFLY_PINK.get();
                    break;
                case RED:
                    drop = EmoItems.BUTTERFLY_RED.get();
                    break;
                case YELLOW:
                    drop = EmoItems.BUTTERFLY_YELLOW.get();
                    break;
                default:
                    drop = EmoItems.BUTTERFLY_BLUE.get();
                    break;
            }

            player.playSound(SoundEvents.FISH_SWIM, 1.0F, 1.0F);
            butterfly.makePoofParticles();
            butterfly.drop(new ItemStack(drop, 1), true, false);
            butterfly.remove(Entity.RemovalReason.DISCARDED);

            if (!player.isCreative()) stack.setDamageValue(1);

            return true;
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
