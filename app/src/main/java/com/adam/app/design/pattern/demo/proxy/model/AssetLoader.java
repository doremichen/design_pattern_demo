/**
 * File: AssetLoader.java
 * Description: This file contains the implementation of the AssetLoader class,
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

import java.util.UUID;

public class AssetLoader {

    public static String loadHeavyAssets(IGamePlayer.LogSink sink) {
        sink.add("AssetLoader: start heavy load (maps/textures)...");
        delay(1000L);
        sink.add("AssetLoader: decoding textures...");
        delay(700L);
        sink.add("AssetLoader: unify shader pipeline...");
        delay(500L);
        String hash = UUID.randomUUID().toString();
        sink.add("AssetLoader: done. hash=" + hash);
        return hash;
    }

    /**
     * delay
     * @param ms long
     */
    public static void delay(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
