/**
 * File: AuthService.java
 * Description: This class is the used to obtain a token by the proxy player,
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

import java.util.UUID;

public class AuthService {

    public static String obtainToken(IGamePlayer.LogSink sink) {
        sink.add("AuthService: requesting token...");
        AssetLoader.delay(300L);
        String token = UUID.randomUUID().toString();
        sink.add("AuthService: token granted.");
        return token;
    }

}
