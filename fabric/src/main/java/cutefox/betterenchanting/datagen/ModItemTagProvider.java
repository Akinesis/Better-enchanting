package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.BetterEnchantingFabric;
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
        BetterEnchantingFabric.LOGGER.info("Generating Item tags for : "+ BetterEnchantingFabric.MOD_ID);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE);

        /*getOrCreateTagBuilder(ModItemTags.LIBRARIAN_RARE_INGREDIENT)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.TURTLE_SCUTE)
                .add(Items.WIND_CHARGE)
                .add(Items.HEART_OF_THE_SEA)
                .add(Items.NAUTILUS_SHELL)
                .add(Items.QUARTZ)
                .add(ModItems.MAGIC_SHARD_FULL);

        getOrCreateTagBuilder(ModItemTags.ENCHANTEMNT_INGREDIENT)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.PUFFERFISH)
                .add(Items.GOLDEN_CARROT)
                .add(Items.PISTON)
                .add(Items.POINTED_DRIPSTONE)
                .add(Items.PHANTOM_MEMBRANE)
                .add(Items.GLASS_BOTTLE)
                .add(ModItems.MAGIC_SHARD_FULL)
                .add(ModItems.MAGIC_SHARD_DULL)
                .add(ModItems.INFUSED_LAPIS);

        getOrCreateTagBuilder(ModItemTags.ENCHANTMENT_ESSENCE)
                .add(ModItems.ESSENCE_OF_EXPERIENCE)
                .add(ModItems.ESSENCE_OF_ARROWS)
                .add(ModItems.ESSENCE_OF_FEATHER)
                .add(ModItems.ESSENCE_OF_RESPIRATION)
                .add(ModItems.ESSENCE_OF_THORN)
                .add(ModItems.ESSENCE_OF_SEA)
                .add(ModItems.ESSENCE_OF_ICE)
                .add(ModItems.ESSENCE_OF_PROTECTION)
                .add(ModItems.ESSENCE_OF_BLAST_PROTECTION)
                .add(ModItems.ESSENCE_OF_FIRE_PROTECTION)
                .add(ModItems.ESSENCE_OF_PROJECTILE_PROTECTION)
                .add(ModItems.ESSENCE_OF_ARTHROPODS)
                .add(ModItems.ESSENCE_OF_SHARPNESS)
                .add(ModItems.ESSENCE_OF_SMITE)
                .add(ModItems.ESSENCE_OF_FIRE)
                .add(ModItems.ESSENCE_OF_KNOCKBACK)
                .add(ModItems.ESSENCE_OF_LOOTING)
                .add(ModItems.ESSENCE_OF_SWEEPING)
                .add(ModItems.ESSENCE_OF_PUNCH)
                .add(ModItems.ESSENCE_OF_POWER)
                .add(ModItems.ESSENCE_OF_SEA_LUCK)
                .add(ModItems.ESSENCE_OF_FORTUNE)
                .add(ModItems.ESSENCE_OF_EFFICIENCY)
                .add(ModItems.ESSENCE_OF_LURE)
                .add(ModItems.ESSENCE_OF_SILK_TOUCH)
                .add(ModItems.ESSENCE_OF_MENDING)
                .add(ModItems.ESSENCE_OF_UNBREAKING)
                .add(ModItems.ESSENCE_OF_CHANNELING)
                .add(ModItems.ESSENCE_OF_IMPALING)
                .add(ModItems.ESSENCE_OF_LOYALTY)
                .add(ModItems.ESSENCE_OF_RIPTIDE)
                .add(ModItems.ESSENCE_OF_MULTISHOT)
                .add(ModItems.ESSENCE_OF_PIERCING)
                .add(ModItems.ESSENCE_OF_QUICK_CHARGE)
                .add(ModItems.ESSENCE_OF_DENSITY)
                .add(ModItems.ESSENCE_OF_WIND)
                .add(ModItems.ESSENCE_OF_BREACH);*/

    }
}
