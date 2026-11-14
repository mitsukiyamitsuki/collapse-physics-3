package dev.example.collapse.mixin;

import dev.example.collapse.CollapseMod;
import net.minecraft.server.level.ChunkMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * サーバー(シングルプレイの内蔵サーバー含む)が送るチャンクの距離は
 * ChunkMap#setServerViewDistance で最大32に切り詰められるので、その上限を上げる。
 * 該当する場所が見つからなければ何もしない(ゲームは落ちない)。
 */
@Mixin(ChunkMap.class)
public abstract class ChunkMapMixin {
    @ModifyConstant(method = "setServerViewDistance", constant = @Constant(intValue = 32), require = 0)
    private int collapse$raiseServerViewDistanceLimit(int original) {
        return CollapseMod.MAX_VIEW_DISTANCE;
    }
}
