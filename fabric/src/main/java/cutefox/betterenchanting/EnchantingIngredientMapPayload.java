package cutefox.betterenchanting;

import cutefox.betterenchanting.registry.ModEnchantIngredientMap;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

import java.util.*;


public record EnchantingIngredientMapPayload(Map<String, List<String>> map) implements CustomPayload {
    public static final CustomPayload.Id<EnchantingIngredientMapPayload> ID = new CustomPayload.Id<>(
            BetterEnchantingConstants.ENCHANT_INGREDIENT_MAP_PACKET_ID);
    public static final PacketCodec<RegistryByteBuf, EnchantingIngredientMapPayload> CODEC = PacketCodec.tuple(
            ModEnchantIngredientMap.MAP_CODEC, EnchantingIngredientMapPayload::map,
            EnchantingIngredientMapPayload::new);

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}