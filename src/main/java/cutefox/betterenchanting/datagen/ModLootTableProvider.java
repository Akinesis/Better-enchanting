package cutefox.betterenchanting.datagen;

import cutefox.betterenchanting.registry.ModItemTags;
import cutefox.betterenchanting.registry.ModLootTables;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends SimpleFabricLootTableProvider {

    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.CHEST);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {

        LootTable.Builder bulider = new LootTable.Builder();
        bulider.pool(LootPool.builder()
                .with(TagEntry.expandBuilder(ModItemTags.ENCHANTMENT_ESSENCE))
                .rolls(ConstantLootNumberProvider.create(1)));

        lootTableBiConsumer.accept(ModLootTables.ESSENCE_TABLE, bulider);

        bulider = new LootTable.Builder();

        bulider.pool(LootPool.builder()
                .with(TagEntry.expandBuilder(ModItemTags.ENCHANTEMNT_INGREDIENT))
                .rolls(ConstantLootNumberProvider.create(1)));
        lootTableBiConsumer.accept(ModLootTables.ENCHANTMENT_INGREDIENT_TABLE, bulider);

        bulider = new LootTable.Builder();

        bulider.pool(LootPool.builder()
                .with(TagEntry.expandBuilder(ModItemTags.ENCHANTMENT_ESSENCE))
                .with(TagEntry.expandBuilder(ModItemTags.ENCHANTEMNT_INGREDIENT))
                .rolls(ConstantLootNumberProvider.create(1)));
        lootTableBiConsumer.accept(ModLootTables.ENCHANTMENT_LOOT, bulider);
    }
}
