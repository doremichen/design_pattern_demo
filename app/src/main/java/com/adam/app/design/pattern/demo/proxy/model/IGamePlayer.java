/**
 * File: IGamePlayer.java
 * Description: This file contains the abstract class for a game player,
 *defining the core playing behavior.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.model;

public abstract class IGamePlayer {

    protected final String mName;

    protected IGamePlayer(String name) {
        this.mName = name;
    }

    // abstract method: play
    public abstract void play(LogSink sink);

    @FunctionalInterface
    public interface LogSink {
        void add(String msg);
    }
}
