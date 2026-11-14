package dev.example.collapse;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.server.level.ServerLevel;

public class CollapseMod implements ModInitializer {
    public static final String MOD_ID = "collapse_physics";

    /** 描画距離の新しい上限(チャンク数)。バニラは32。大きくするほど重くなる */
    public static final int MAX_VIEW_DISTANCE = 64;

    @Override
    public void onInitialize() {
        // プレイヤーがブロックを壊した直後に、まわりが崩れないか調べる
        PlayerBlockBreakEvents.AFTER.register((level, player, pos, state, blockEntity) -> {
            if (level instanceof ServerLevel serverLevel) {
                CollapsePhysics.onBlockBroken(serverLevel, pos);
            }
        });
    }
}
