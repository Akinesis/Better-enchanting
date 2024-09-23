package cutefox.betterenchanting.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.datagen.ModEnchantIngredientMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;

@Mixin(LootTable.class)
public abstract class LootTableMixin {

    private List<ItemStack> essences = new ArrayList<>();

    @Shadow protected abstract List<Integer> getFreeSlots(Inventory inventory, Random random);

    @Inject(method = "supplyInventory", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"))
    public void betterEnchanting$replaceEnchantedBook(Inventory inventory, LootContextParameterSet parameters, long seed, CallbackInfo ci, @Local LocalRef<ItemStack> localRef){

        if(localRef.get().isEmpty())
            return;

        int i = 0;
        ItemStack newItem;
        ItemStack localRefItemStack = localRef.get().copy();

        if(localRefItemStack.getItem().equals(Items.ENCHANTED_BOOK)){
            ItemEnchantmentsComponent bookEnchants = EnchantmentHelper.getEnchantments(localRefItemStack);


            for(Object2IntMap.Entry<RegistryEntry<Enchantment>> ench : bookEnchants.getEnchantmentEntries()){
                bookEnchants.getEnchantmentEntries();
                int enchantLevel = ench.getIntValue();
                RegistryKey<Enchantment> enchantmentKey = ench.getKey().getKey().get();
                List<Item> ingredientsOfEnchant = ModEnchantIngredientMap.map.get(enchantmentKey);
                if(ingredientsOfEnchant !=null && !ingredientsOfEnchant.isEmpty()){
                    if(enchantLevel > ingredientsOfEnchant.size()) //If not all ingredients are configured for the enchant
                        enchantLevel = ingredientsOfEnchant.size();

                    newItem = new ItemStack(ingredientsOfEnchant.get(enchantLevel-1));
                    if(enchantLevel < ingredientsOfEnchant.size()){
                        //If the ingredient is not an essence
                        Random rand = Random.create();
                        newItem.setCount(enchantLevel+rand.nextBetween(1,3));
                    }
                }else {
                    newItem = new ItemStack(Items.EXPERIENCE_BOTTLE);
                }
                if(i > 0)
                    this.essences.add(newItem);
                else
                    localRef.set(newItem);
                i++;
            }
        }
    }

    //@Inject(method = "supplyInventory", at = @At(value = "RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    @Inject(method = "supplyInventory", at = @At(value = "TAIL"),locals = LocalCapture.CAPTURE_FAILHARD)
    public void betterEnchanting$addEssencesAfterLootGeneration(Inventory inventory, LootContextParameterSet parameters, long seed, CallbackInfo ci){

        Random random = Random.create(53844);

        this.betterEnchanting$addEssences(inventory, random);
        this.essences.clear();
    }

    private void betterEnchanting$addEssences(Inventory inventory, Random random){

        List<Integer> list = this.getFreeSlots(inventory, random);


        for (ItemStack stack : essences){
            if (list.isEmpty()) {
                BetterEnchanting.LOGGER.warn("Tried to over-fill a container");
                return;
            }
            inventory.setStack(list.remove(list.size()-1), stack);
        }
    }
}
