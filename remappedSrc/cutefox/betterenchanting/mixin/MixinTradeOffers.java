package cutefox.betterenchanting.mixin;

import net.minecraft.village.TradeOffers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(TradeOffers.class)
public class MixinTradeOffers {

    //@Inject(method = "createLibrarianTradeFactory", at = @At("HEAD"), cancellable = true)
    private static void betterEnchanting$replaceRebalancedTradOffers(int experience, CallbackInfoReturnable<TradeOffers.Factory> cir){

    }

}
