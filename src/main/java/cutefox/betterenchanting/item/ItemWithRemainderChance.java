package cutefox.betterenchanting.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public class ItemWithRemainderChance extends Item {

    private float remainderChance;

    public ItemWithRemainderChance(Settings settings) {
        super(settings);
        remainderChance = 0.65f;
    }

    public ItemWithRemainderChance(Settings settings, float chance) {
        super(settings);
        remainderChance = chance;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        Random random = Random.create();
        return (this.hasRecipeRemainder() && random.nextFloat() <= remainderChance) ? this.getRecipeRemainder().getDefaultStack() : ItemStack.EMPTY;
    }
}
