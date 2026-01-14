/**
 * File: RealPlayer.java
 * Description: This class is the Real Player class
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

public class RealPlayer extends IGamePlayer {
    // TAG
    private static final String TAG = "RealPlayer";

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public void play(LogSink sink) {
        sink.add(TAG + ": playing " + mName);
        sink.add(TAG + ": loading assets...");
        AssetLoader.loadHeavyAssets(sink);
        sink.add("RealPlayer: initializing gameplay...");
        AssetLoader.delay(400L);
        sink.add("RealPlayer: done.");
    }
}
