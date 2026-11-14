package dev.example.collapse.mixin;

import dev.example.collapse.CollapseMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * ビデオ設定の「描画距離」スライダーの最大値(通常は32)を引き上げる。
 * 該当する場所が見つからなければ何もしない(ゲームは落ちない)。
 */
@Mixin(targets = "net.minecraft.client.OptionInstance$ClampingLazyMaxIntRange")
public abstract class ClampingLazyMaxIntRangeMixin {
    @Inject(method = "maxInclusive", at = @At("RETURN"), cancellable = true, require = 0)
    private void collapse$raiseMax(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Math.max(cir.getReturnValue(), CollapseMod.MAX_VIEW_DISTANCE));
    }
}
