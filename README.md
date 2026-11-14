# Collapse Physics & Far View(崩落物理 + 描画距離アップ)for Minecraft 26.3 / Fabric

## 1. 崩落の物理
地面につながっていない建材ブロックのかたまりが、まとめて落下します。
木の幹・家の屋根・橋などが対象です(`CollapsePhysics.java` の `INCLUDE` / `EXCLUDE` で変更可)。

## 2. 描画距離の上限アップ
ビデオ設定の描画距離スライダーの上限を 32 → 64 チャンクに引き上げます
(`CollapseMod.java` の `MAX_VIEW_DISTANCE` で変更可)。
- シングルプレイ / LAN: 内蔵サーバーが送る距離の上限も引き上げます
- 専用サーバー: `server.properties` 側の上限(32)は別の場所で切られているので、このMODでは変わりません
- Sodiumなどを入れている場合、Sodiumのスライダーは32のままのことがあります。
  その場合は `options.txt` の `renderDistance:` の数字を直接書き換えてください

※ 描画距離を大きくするほど、メモリ・GPU・ワールド生成の負荷が一気に増えます。
  少しずつ上げて、重くなりすぎない値を探してください。
※ 実装は「見つからなければ何もしない」形になっています。効かなかった場合も、
  ゲームが落ちることはありません(スライダーの上限が32のままになります)。

## 必要なもの
Minecraft Java 26.3 / Fabric Loader 0.19.5以上 / Fabric API(26.3用) / Java 25

## ビルド
GitHub Actionsの `build` を実行 → Artifacts の `collapse-physics-1.1.0.jar`(`-sources` ではない方)を `mods` に入れる。
