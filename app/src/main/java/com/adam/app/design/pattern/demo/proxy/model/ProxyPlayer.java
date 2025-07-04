/**
 * Description: This class is proxy player
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.proxy.model;

import com.adam.app.design.pattern.demo.Util;

public class ProxyPlayer extends IGamePlayer {

    // realPlayer: real player
    private final RealPlayer mRealPlayer;

    // constructor
    public ProxyPlayer(String name) {
        // log
        Util.log("ProxyPlayer: " + name);
        // create real player
        mRealPlayer = new RealPlayer(name);
    }


    @Override
    public void play() {
        // log
        Util.log("ProxyPlayer: play");
        // play
        mRealPlayer.play();

    }
}
