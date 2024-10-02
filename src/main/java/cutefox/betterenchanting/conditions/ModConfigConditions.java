package cutefox.betterenchanting.conditions;

import com.mojang.serialization.MapCodec;
import cutefox.betterenchanting.BetterEnchanting;
import cutefox.betterenchanting.Utils;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;

public class ModConfigConditions {

    public static final ResourceConditionType<NeoEnchantCompatCondition> NEO_ENCHANT = createResourceConditionType("neo_enchant", NeoEnchantCompatCondition.CODEC);
    public static final ResourceConditionType<BumblezoneCompatCondition> BUMBLEZONE = createResourceConditionType("bumblezone", BumblezoneCompatCondition.CODEC);

    public static void registerConditions(){
        BetterEnchanting.LOGGER.info("Registering conditions for : "+BetterEnchanting.MOD_ID);
        ResourceConditions.register(NEO_ENCHANT);
        ResourceConditions.register(BUMBLEZONE);
    }

    private static <T extends ResourceCondition> ResourceConditionType<T> createResourceConditionType(String name, MapCodec<T> codec) {
        return ResourceConditionType.create(Utils.id(name), codec);
    }
}