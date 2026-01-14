/**
 * File: PlayerFactory.java
 * Description: This class is a factory to create a player
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

public class PlayerFactory {
    public static IGamePlayer createPlayer(boolean useProxy, String name) {
        return (useProxy) ? new ProxyPlayer(name) : new RealPlayer(name);
    }
}
