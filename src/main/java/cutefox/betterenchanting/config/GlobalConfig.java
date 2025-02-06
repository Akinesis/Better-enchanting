package cutefox.betterenchanting.config;


import com.google.common.collect.Lists;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.util.Identifier;

import java.util.List;

public class GlobalConfig extends MidnightConfig {

    public static final String GLOBAL = "Global config";

    @Entry(category = GLOBAL, idMode = 2) public static List<Identifier> disabledEnchants = Lists.newArrayList(Identifier.of("namespace","enchantment"));
    @Entry(category = GLOBAL) public static boolean  allowBookInAnvil = false;
    @Comment(category = GLOBAL) public static Comment spacer1;
    @Comment(category = GLOBAL) public static Comment costSection;
    @Entry(category = GLOBAL) public static int shardFillingLapisCost = 3;
    @Entry(category = GLOBAL) public static int shardFillingExperienceCost = 5;
    @Entry(category = GLOBAL) public static boolean  overideItemCost = false;
    @Entry(category = GLOBAL) public static int overidenItemCost = 3;
    @Entry(category = GLOBAL) public static double consecutiveEnchantIncrease = 0.05;
    @Entry(category = GLOBAL) public static int baseEnchantmentCost = 8;
    @Entry(category = GLOBAL) public static double tresaureMultiplier = 2;
    @Entry(category = GLOBAL) public static int catalystGivebackChance = 10;

    // removed ModMenuApi - obsolete, causes crashes on dedicated servers

}
