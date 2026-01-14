/**
 * File: ProxyPlayer.java
 * Description: This class is the Proxy Player of real Player.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

public class ProxyPlayer extends IGamePlayer{
    // TAG
    private static final String TAG = "ProxyPlayer";

    private String mCachedAssetsHash;
    private long mLastPlayEpochMs;

    // real player
    private final RealPlayer mRealPlayer;

    public ProxyPlayer(String name) {
        super(name);
        mRealPlayer = new RealPlayer(name);
    }

    @Override
    public void play(LogSink sink) {
        long now = System.currentTimeMillis();

        sink.add(TAG + ": start play");

        // time boundary
        // Not allow to play again during the 1.5 sec.
        long intervalMs = 1500L;
        if ((now - mLastPlayEpochMs) < intervalMs) {
            sink.add(TAG + ": rate-limited (wait " + (intervalMs - (now - mLastPlayEpochMs)) + "ms)");
            return;
        }
        // update last play time
        mLastPlayEpochMs = now;

        // check permission
        sink.add(TAG + ": checking permission...");
        String token = AuthService.obtainToken(sink);
        if (token == null) {
            sink.add(TAG + ": permission denied.");
            return;
        }

        sink.add(TAG + ": : auth ok: " + token.substring(0, Math.min(6, token.length())) + "...");

        // check assets
        if (mCachedAssetsHash == null) {
            sink.add(TAG + ": loading assets...");
            mCachedAssetsHash = AssetLoader.loadHeavyAssets(sink);
            sink.add(TAG + ": done: " + mCachedAssetsHash);
        } else {
            sink.add(TAG + ": cache hit → reuse assets: " + mCachedAssetsHash);
        }

        // real play
        sink.add(TAG + ": start real play...");
        mRealPlayer.play(sink);

        sink.add(TAG + ": analytics tracked.");
    }
}
