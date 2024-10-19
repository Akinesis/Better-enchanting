package cutefox.betterenchanting.mixin;

import cutefox.betterenchanting.registry.ModItemTags;
import cutefox.betterenchanting.registry.ModTradeOffers;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerDataContainer;
import net.minecraft.village.VillagerType;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Mixin(TradeOffers.class)
public class MixinTradeOffers {

    //@Inject(method = "createLibrarianTradeFactory", at = @At("HEAD"), cancellable = true)
    private static void betterEnchanting$replaceRebalancedTradOffers(int experience, CallbackInfoReturnable<TradeOffers.Factory> cir){

    }

}
