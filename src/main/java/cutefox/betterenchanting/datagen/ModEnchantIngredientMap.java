package cutefox.betterenchanting.datagen;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.registry.ModItems;
import io.netty.buffer.ByteBuf;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.lang.reflect.Type;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class ModEnchantIngredientMap {

    public static HashMap<String, List<String>> defaultMap = new HashMap<>();
    public static HashMap<RegistryKey<Enchantment>, List<Item>> map = new HashMap<>();
    public static Map<String, List<String>> jsonMap = new HashMap<>();


    static{
        //Armor enchantment
        defaultMap.put(Enchantments.PROTECTION.getValue().toString(), listOfIdentifiers(List.of(Items.COPPER_INGOT,Items.IRON_INGOT,Items.DIAMOND, ModItems.ESSENCE_OF_PROTECTION)));
        defaultMap.put(Enchantments.FIRE_PROTECTION.getValue().toString(), listOfIdentifiers(List.of(Items.MAGMA_BLOCK,Items.MAGMA_CREAM,Items.LAVA_BUCKET,ModItems.ESSENCE_OF_FIRE_PROTECTION)));
        defaultMap.put(Enchantments.FEATHER_FALLING.getValue().toString(), listOfIdentifiers(List.of(Items.FEATHER,Items.PHANTOM_MEMBRANE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_FEATHER)));
        defaultMap.put(Enchantments.BLAST_PROTECTION.getValue().toString(), listOfIdentifiers(List.of(Items.GUNPOWDER, Items.TNT, Items.CREEPER_HEAD, ModItems.ESSENCE_OF_BLAST_PROTECTION)));
        defaultMap.put(Enchantments.PROJECTILE_PROTECTION.getValue().toString(), listOfIdentifiers(List.of(Items.LEATHER,Items.BRICK,Items.IRON_BARS,ModItems.ESSENCE_OF_PROJECTILE_PROTECTION)));
        defaultMap.put(Enchantments.RESPIRATION.getValue().toString(), listOfIdentifiers(List.of(Items.PUFFERFISH,Items.TURTLE_SCUTE,ModItems.ESSENCE_OF_RESPIRATION)));
        defaultMap.put(Enchantments.AQUA_AFFINITY.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SEA)));
        defaultMap.put(Enchantments.THORNS.getValue().toString(), listOfIdentifiers(List.of(Items.CACTUS,Items.PUFFERFISH_BUCKET,ModItems.ESSENCE_OF_THORN)));
        defaultMap.put(Enchantments.DEPTH_STRIDER.getValue().toString(), listOfIdentifiers(List.of(Items.COD,Items.SPONGE, ModItems.ESSENCE_OF_SEA)));
        defaultMap.put(Enchantments.FROST_WALKER.getValue().toString(), listOfIdentifiers(List.of(Items.BLUE_ICE,ModItems.ESSENCE_OF_ICE))); //Treasure
        defaultMap.put(Enchantments.SOUL_SPEED.getValue().toString(), listOfIdentifiers(List.of(ModItems.SOUL_ESSENCE_1,ModItems.SOUL_ESSENCE_2,ModItems.SOUL_ESSENCE_3))); //Treasure
        defaultMap.put(Enchantments.SWIFT_SNEAK.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SNEAK_1,ModItems.ESSENCE_OF_SNEAK_2,ModItems.ESSENCE_OF_SNEAK_3))); //Treasure

        //Sword enchantment
        defaultMap.put(Enchantments.SHARPNESS.getValue().toString(), listOfIdentifiers(List.of(Items.FLINT,Items.IRON_SWORD,Items.GRINDSTONE,Items.DIAMOND,ModItems.ESSENCE_OF_SHARPNESS)));
        defaultMap.put(Enchantments.SMITE.getValue().toString(), listOfIdentifiers(List.of(Items.ROTTEN_FLESH,Items.GLOWSTONE,Items.QUARTZ,Items.AMETHYST_SHARD,ModItems.ESSENCE_OF_SMITE)));
        defaultMap.put(Enchantments.BANE_OF_ARTHROPODS.getValue().toString(), listOfIdentifiers(List.of(Items.SHEARS,Items.SPIDER_EYE,Items.COBWEB,Items.FERMENTED_SPIDER_EYE,ModItems.ESSENCE_OF_ARTHROPODS)));
        defaultMap.put(Enchantments.KNOCKBACK.getValue().toString(), listOfIdentifiers(List.of(Items.PISTON, ModItems.ESSENCE_OF_KNOCKBACK)));
        defaultMap.put(Enchantments.FIRE_ASPECT.getValue().toString(), listOfIdentifiers(List.of(Items.FIRE_CHARGE,ModItems.ESSENCE_OF_FIRE)));
        defaultMap.put(Enchantments.LOOTING.getValue().toString(), listOfIdentifiers(List.of(Items.EMERALD,Items.TORCHFLOWER,ModItems.ESSENCE_OF_LOOTING)));
        defaultMap.put(Enchantments.SWEEPING_EDGE.getValue().toString(), listOfIdentifiers(List.of(Items.IRON_BARS,Items.OBSIDIAN,ModItems.ESSENCE_OF_SWEEPING)));

        //Bow enchantment
        defaultMap.put(Enchantments.POWER.getValue().toString(), listOfIdentifiers(List.of(Items.SNOWBALL,Items.LEATHER,Items.GHAST_TEAR,Items.SHULKER_SHELL,ModItems.ESSENCE_OF_POWER)));
        defaultMap.put(Enchantments.PUNCH.getValue().toString(), listOfIdentifiers(List.of(Items.DEEPSLATE,ModItems.ESSENCE_OF_PUNCH)));
        defaultMap.put(Enchantments.FLAME.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_FIRE)));
        defaultMap.put(Enchantments.INFINITY.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_ARROWS)));

        //Tool enchantement
        defaultMap.put(Enchantments.EFFICIENCY.getValue().toString(), listOfIdentifiers(List.of(Items.FLINT,Items.GOLDEN_APPLE,Items.OBSIDIAN,Items.CHORUS_FRUIT,ModItems.ESSENCE_OF_EFFICIENCY)));
        defaultMap.put(Enchantments.SILK_TOUCH.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SILK_TOUCH)));
        defaultMap.put(Enchantments.FORTUNE.getValue().toString(), listOfIdentifiers(List.of(Items.GOLD_BLOCK,Items.EMERALD_BLOCK,ModItems.ESSENCE_OF_FORTUNE)));

        //Fishing tool enchantment
        defaultMap.put(Enchantments.LUCK_OF_THE_SEA.getValue().toString(), listOfIdentifiers(List.of(Items.NAUTILUS_SHELL,Items.HEART_OF_THE_SEA,ModItems.ESSENCE_OF_SEA_LUCK)));
        defaultMap.put(Enchantments.LURE.getValue().toString(), listOfIdentifiers(List.of(Items.CARROT_ON_A_STICK,Items.BREAD,ModItems.ESSENCE_OF_LURE)));

        //Anything enchantment
        defaultMap.put(Enchantments.UNBREAKING.getValue().toString(), listOfIdentifiers(List.of(Items.DIAMOND,Items.CRYING_OBSIDIAN, ModItems.ESSENCE_OF_UNBREAKING)));
        defaultMap.put(Enchantments.MENDING.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_MENDING))); //Treasure

        //Trident enchantment
        defaultMap.put(Enchantments.CHANNELING.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_CHANNELING)));
        defaultMap.put(Enchantments.IMPALING.getValue().toString(), listOfIdentifiers(List.of(Items.POINTED_DRIPSTONE,Items.IRON_BARS,Items.QUARTZ,Items.DIAMOND_SWORD,ModItems.ESSENCE_OF_IMPALING)));
        defaultMap.put(Enchantments.LOYALTY.getValue().toString(), listOfIdentifiers(List.of(Items.BONE_BLOCK,Items.GOLDEN_CARROT,ModItems.ESSENCE_OF_LOYALTY)));
        defaultMap.put(Enchantments.RIPTIDE.getValue().toString(), listOfIdentifiers(List.of(Items.WATER_BUCKET,Items.NAUTILUS_SHELL,ModItems.ESSENCE_OF_RIPTIDE)));

        //Crossbow enchantment
        defaultMap.put(Enchantments.MULTISHOT.getValue().toString(), listOfIdentifiers(List.of(ModItems.ESSENCE_OF_MULTISHOT)));
        defaultMap.put(Enchantments.PIERCING.getValue().toString(), listOfIdentifiers(List.of(Items.FLINT,Items.ARROW,Items.SPECTRAL_ARROW,ModItems.ESSENCE_OF_PIERCING)));
        defaultMap.put(Enchantments.QUICK_CHARGE.getValue().toString(), listOfIdentifiers(List.of(Items.AMETHYST_SHARD,Items.GLOWSTONE,ModItems.ESSENCE_OF_QUICK_CHARGE)));

        //Mace enchantment
        defaultMap.put(Enchantments.DENSITY.getValue().toString(), listOfIdentifiers(List.of(Items.STONE,Items.DEEPSLATE,Items.OBSIDIAN,Items.LODESTONE,ModItems.ESSENCE_OF_DENSITY)));
        defaultMap.put(Enchantments.BREACH.getValue().toString(), listOfIdentifiers(List.of(Items.IRON_INGOT,Items.SMOOTH_STONE,Items.TNT,ModItems.ESSENCE_OF_BREACH)));
        defaultMap.put(Enchantments.WIND_BURST.getValue().toString(), listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_WIND)));

    }

    public static void createMap() {
        BetterEnchanting.LOGGER.info("Creating enchantement ingredient map for mod : "+BetterEnchanting.MOD_ID);

    }

    public static void genMapFromJson(World world){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Resolve default config for supported mod here. Put entry in default map

        try {

            File configFolder = new File(FabricLoader.getInstance().getConfigDir().resolve("better-enchanting").toString());
            configFolder.mkdirs();

            File configFile = new File(configFolder.getAbsolutePath()+"/enchantment_ingredients.json");
            if(configFile.createNewFile()){
                //init default file
                BufferedWriter writer = new BufferedWriter(new FileWriter(configFile));
                String temp = gson.toJson(defaultMap);
                writer.write(temp);
                writer.close();
            }

            JsonReader reader = new JsonReader(new FileReader(configFile));
            jsonMap = gson.fromJson(reader, Map.class);
            reader.close();

            //get enchant present in default map but not in config and
            Map<String, List<String>> missingEntries = getEnchantNotPresentInConfig();

            //Append entries not present in config file
            if(!missingEntries.isEmpty()){
                BufferedWriter writer = new BufferedWriter(new FileWriter(configFile));
                jsonMap.putAll(missingEntries);
                String temp = gson.toJson(jsonMap);
                writer.append(temp);
                writer.close();
            }

            if (!world.isClient){
                genMapFromJsonStringMap(world, jsonMap);
            }
        } catch (Exception e){
            throw new RuntimeException(e.toString());
        }
    }

    public static void genMapFromJsonStringMap(World world, Map<String, List<String>> stringMap) {
        map = new HashMap<>();
        RegistryKey<Enchantment> enchantementKey;
        Enchantment enchantment;

        for (String key : stringMap.keySet()) {
            Identifier enchantId = Identifier.of(key);
            enchantment = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).get(enchantId);
            Registry<Enchantment> enchantRegistry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
            Optional<RegistryKey<Enchantment>> optional = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getKey(enchantment);
            //enchantementKey = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getKey(enchantment);

            if (optional.isPresent()) {
                enchantementKey = optional.get();
                List<Item> ingredients = new ArrayList<>();

                stringMap.get(key).forEach(s -> {
                    Item temp;
                    Identifier itemId = Identifier.of(s);
                    temp = Registries.ITEM.get(itemId);
                    ingredients.add(temp!=null?temp:Items.BARRIER);
                });

                map.put(enchantementKey, ingredients);
            }
        }
    }

    private static List<String> listOfIdentifiers(List<Item> items){

        List<String> list = new ArrayList<>();

        for(Item item : items){
            list.add(Registries.ITEM.getId(item).toString());
        }

        return list;
    }

    private static Map<String, List<String>> getEnchantNotPresentInConfig() throws Exception{

        Map<String, List<String>> missingEntries = new HashMap<>();

        for(String enchant : defaultMap.keySet()){
            if(!jsonMap.keySet().contains(enchant))
                missingEntries.put(enchant, defaultMap.get(enchant));
        }

        return missingEntries;
    }

    public static final PacketCodec<ByteBuf, Map<String, List<String>>> MAP_CODEC = new PacketCodec<ByteBuf, Map<String, List<String>>>() {
        public Map<String, List<String>> decode(ByteBuf byteBuf) {
            Gson gson = new GsonBuilder().create();
            int length = byteBuf.readInt();
            byte[] bytes = new byte[length];
            byteBuf.readBytes(bytes);
            String message = new String(bytes, Charsets.UTF_8);
            Type mapType = new TypeToken<Map<String, List<String>>>() {
            }.getType();
            return gson.fromJson(message, mapType);
        }

        public void encode(ByteBuf byteBuf, Map<String, List<String>> blockPos) {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(jsonMap);
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            byteBuf.writeInt(bytes.length);
            byteBuf.writeBytes(bytes);
        }
    };

    public static void loadNeoEnchantConfig(){

        defaultMap.put("enchantplus:bow/accuracy_shot", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_ARROWS)));
        defaultMap.put("enchantplus:boots/agility", listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,Items.WIND_CHARGE,Items.SUGAR_CANE,ModItems.ESSENCE_OF_AGILITY)));
        defaultMap.put("enchantplus:elytra/armored", listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_PROTECTION)));
        defaultMap.put("enchantplus:sword/attack_speed", listOfIdentifiers(List.of(Items.WIND_CHARGE,ModItems.ESSENCE_OF_COMBAT)));
        defaultMap.put("enchantplus:helmet/auto_feed", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_FOOD)));
        defaultMap.put("enchantplus:tools/auto_smelt", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SMELTING)));
        defaultMap.put("enchantplus:bow/breezing_arrow", listOfIdentifiers(List.of(Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_ARROWS)));
        defaultMap.put("enchantplus:helmet/bright_vision", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SIGHT)));
        defaultMap.put("enchantplus:chestplate/builder_arm", listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,Items.WIND_CHARGE,Items.SUGAR_CANE,ModItems.ESSENCE_OF_BUILDING)));
        defaultMap.put("enchantplus:bow/echo_shot", listOfIdentifiers(List.of(Items.ECHO_SHARD,Items.SCULK_SENSOR,ModItems.ESSENCE_OF_ARROWS)));
        defaultMap.put("enchantplus:pickaxe/experimental_bedrock_breaker", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_MINING)));
        defaultMap.put("enchantplus:bow/explosive_arrow", listOfIdentifiers(List.of(Items.TNT,Items.CREEPER_HEAD,ModItems.ESSENCE_OF_ARROWS)));
        defaultMap.put("enchantplus:leggings/fast_swim", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SEA)));
        defaultMap.put("enchantplus:sword/fear", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_FEAR)));
        defaultMap.put("enchantplus:armor/fury", listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_COMBAT)));
        defaultMap.put("enchantplus:boots/lava_walker", listOfIdentifiers(List.of(Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_FIRE)));
        defaultMap.put("enchantplus:leggings/leaping", listOfIdentifiers(List.of(Items.WIND_CHARGE,ModItems.ESSENCE_OF_AGILITY)));
        defaultMap.put("enchantplus:sword/life_steal", listOfIdentifiers(List.of(Items.SWEET_BERRIES,Items.IRON_SWORD,ModItems.ESSENCE_OF_VAMPIRISM)));
        defaultMap.put("enchantplus:armor/lifeplus", listOfIdentifiers(List.of(Items.APPLE,Items.RABBIT_STEW,Items.NETHER_WART_BLOCK,Items.DRAGON_HEAD,ModItems.ESSENCE_OF_HEALTH)));
        defaultMap.put("enchantplus:trident/magical_water", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SEA)));
        defaultMap.put("enchantplus:tools/miningplus", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_MINING)));
        defaultMap.put("enchantplus:sword/poison_aspect", listOfIdentifiers(List.of(Items.SPIDER_EYE,Items.PUFFERFISH_BUCKET,Items.POISONOUS_POTATO,ModItems.ESSENCE_OF_POISON)));
        defaultMap.put("enchantplus:sword/pull", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_PULLING)));
        defaultMap.put("enchantplus:sword/reach", listOfIdentifiers(List.of(Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_REACH)));
        defaultMap.put("enchantplus:hoe/scyther", listOfIdentifiers(List.of(Items.WIND_CHARGE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_FORAGING)));
        defaultMap.put("enchantplus:boots/sky_walk", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_WIND)));
        defaultMap.put("enchantplus:pickaxe/spawner_touch", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_SILK_TOUCH)));
        defaultMap.put("enchantplus:boots/step_assist", listOfIdentifiers(List.of(Items.SUGAR_CANE,Items.WIND_CHARGE,ModItems.ESSENCE_OF_AGILITY)));
        defaultMap.put("enchantplus:bow/storm_arrow", listOfIdentifiers(List.of(Items.WIND_CHARGE,ModItems.ESSENCE_OF_ARROWS)));
        defaultMap.put("enchantplus:mace/striker", listOfIdentifiers(List.of(Items.LIGHTNING_ROD,ModItems.ESSENCE_OF_STRIKE)));
        defaultMap.put("enchantplus:axe/timber", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_FORAGING)));
        defaultMap.put("enchantplus:pickaxe/vein_miner", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_MINING)));
        defaultMap.put("enchantplus:armor/venom_protection", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_POISON_PROTECTION)));
        defaultMap.put("enchantplus:helmet/voidless", listOfIdentifiers(List.of(ModItems.ESSENCE_OF_LEVITATION)));
        defaultMap.put("enchantplus:mace/wind_propulsion", listOfIdentifiers(List.of(Items.TNT,Items.WIND_CHARGE,ModItems.ESSENCE_OF_WIND)));
        defaultMap.put("enchantplus:sword/xp_boost", listOfIdentifiers(List.of(Items.ENDER_EYE,ModItems.MAGIC_SHARD_DULL,ModItems.ESSENCE_OF_EXPERIENCE)));

    }
}
