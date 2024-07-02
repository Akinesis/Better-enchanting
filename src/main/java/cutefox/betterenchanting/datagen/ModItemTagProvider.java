package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.registry.ModItemTags;
import cutefox.betterenchanting.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        BetterEnchanting.LOGGER.info("Generating Item tags for : "+BetterEnchanting.MOD_ID);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ModItemTags.LIBRARIAN_ENCHANT_INGREDIENT_SALE)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.TURTLE_SCUTE)
                .add(Items.WIND_CHARGE)
                .add(ModItems.MAGIC_SHARD_FULL)
                .add(ModItems.MAGIC_SHARD_DULL)
                .add(ModItems.INFUSED_LAPIS);

        getOrCreateTagBuilder(ModItemTags.ENCHANTEMNT_INGREDIENT)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.TURTLE_SCUTE)
                .add(Items.WIND_CHARGE)
                .add(ModItems.MAGIC_SHARD_FULL)
                .add(ModItems.MAGIC_SHARD_DULL)
                .add(ModItems.INFUSED_LAPIS);

        getOrCreateTagBuilder(ModItemTags.ENCHANTMENT_ESSENCE)
                .add(ModItems.ESSENCE_OF_EXPERIENCE)
                .add(ModItems.SOUL_ESSENCE_1)
                .add(ModItems.SOUL_ESSENCE_2)
                .add(ModItems.SOUL_ESSENCE_3)
                .add(ModItems.ESSENCE_OF_SNEAK_1)
                .add(ModItems.ESSENCE_OF_SNEAK_2)
                .add(ModItems.ESSENCE_OF_SNEAK_3)
                .add(ModItems.ESSENCE_OF_PROTECTION)
                .add(ModItems.ESSENCE_OF_BLAST_PROTECTION)
                .add(ModItems.ESSENCE_OF_FIRE_PROTECTION);

    }
}
