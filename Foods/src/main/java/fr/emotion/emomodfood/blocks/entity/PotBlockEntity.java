package fr.emotion.emomodfood.blocks.entity;

import fr.emotion.emomodfood.init.EmoBlockEntityTypes;
import fr.emotion.emomodfood.init.EmoItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.fml.common.asm.enumextension.IExtensibleEnum;

import java.util.Arrays;

public class PotBlockEntity extends BlockEntity {
    private PotContentType contentType = PotContentType.EMPTY;
    private int fillLevel = 0;
    public static final int maxLevel = 5;

    public PotBlockEntity(BlockPos pos, BlockState blockState) {
        super(EmoBlockEntityTypes.POT.get(), pos, blockState);
    }

    public InteractionResult use(Player player, InteractionHand hand) {
        ItemStack held = player.getItemInHand(hand);
        Item heldItem = held.getItem();

        PotContentType type = getContentType();

        if (type!=PotContentType.EMPTY && heldItem==type.getItem()) {
            ItemStack out = new ItemStack(type.getResult());
            this.fillLevel--;

            player.setItemInHand(hand, out);

            if (this.fillLevel <= 0) {
                this.contentType = PotContentType.EMPTY;
            }

            setChanged();
            return InteractionResult.SUCCESS;
        }

        if (type==PotContentType.EMPTY) {
            PotContentType newType = PotContentType.byResult(heldItem);
            if (newType!=PotContentType.EMPTY
                    && newType.getItem()!=EmoItems.SLICE_BREAD.asItem()) {
                this.contentType = newType;
                this.fillLevel = 1;

                player.setItemInHand(hand, new ItemStack(newType.getItem()));

                setChanged();
                return InteractionResult.SUCCESS;
            }
        }

        if (type!=PotContentType.EMPTY && this.fillLevel < maxLevel) {
            PotContentType addType = PotContentType.byResult(heldItem);
            if (addType==type) {
                this.fillLevel++;
                player.setItemInHand(hand, new ItemStack(addType.getItem()));
                setChanged();
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    public PotContentType getContentType() {
        return this.contentType;
    }

    public int getFillLevel() {
        return this.fillLevel;
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.contentType = PotContentType.byName(input.getStringOr("ContentType", "empty"));
        this.fillLevel = input.getIntOr("FillLevel", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putString("ContentType", this.contentType.getName());
        output.putInt("FillLevel", this.fillLevel);
    }

    public enum PotContentType implements IExtensibleEnum {
        EMPTY("empty", Items.BARRIER, Items.BARRIER),
        SWEETBERRY("sweetberry", EmoItems.SLICE_BREAD, EmoItems.SLICE_SWEETBERRY),
        CHOCOLATE("chocolate", EmoItems.SLICE_BREAD, EmoItems.SLICE_CHOCOLATE),
        APPLE("apple", EmoItems.SLICE_BREAD, EmoItems.SLICE_APPLE),
        BLACKCURRANT("blackcurrant", EmoItems.SLICE_BREAD, EmoItems.SLICE_BLACKCURRANT),
        BLUEBERRY("blueberry", EmoItems.SLICE_BREAD, EmoItems.SLICE_BLUEBERRY),
        DREAMCURRANT("dreamcurrant", EmoItems.SLICE_BREAD, EmoItems.SLICE_DREAMCURRANT),
        STARWBERRY("strawberry", EmoItems.SLICE_BREAD, EmoItems.SLICE_STRAWBERRY),
        PEAR("pear", EmoItems.SLICE_BREAD, EmoItems.SLICE_PEAR),
        CHERRY("cherry", EmoItems.SLICE_BREAD, EmoItems.SLICE_CHERRY),
        ORANGE("orange", EmoItems.SLICE_BREAD, EmoItems.SLICE_ORANGE),
        WATER("water", Items.BUCKET, Items.WATER_BUCKET),
        LAVA("lava", Items.BUCKET, Items.LAVA_BUCKET),
        MILK("milk", Items.BUCKET, Items.MILK_BUCKET),
        RABBIT_STEW("rabbit_stew", Items.BOWL, Items.RABBIT_STEW),
        MUSHROOM_STEW("mushroom_stew", Items.BOWL, Items.MUSHROOM_STEW);

        private final String name;
        private final ItemLike item;
        private final ItemLike result;

        PotContentType(String name, ItemLike item, ItemLike result) {
            this.name = name;
            this.item = item;
            this.result = result;
        }

        public String getName() {
            return this.name;
        }

        public Item getItem() {
            return this.item.asItem();
        }

        public Item getResult() {
            return this.result.asItem();
        }

        public static PotContentType byName(String name) {
            return Arrays.stream(values())
                    .filter(t -> t.name.equals(name))
                    .findFirst()
                    .orElse(EMPTY);
        }

        public static PotContentType byItem(Item item) {
            return Arrays.stream(values())
                    .filter(t -> t.getItem()==item)
                    .findFirst()
                    .orElse(EMPTY);
        }

        public static PotContentType byResult(Item result) {
            return Arrays.stream(values())
                    .filter(t -> t.getResult()==result)
                    .findFirst()
                    .orElse(EMPTY);
        }
    }
}
