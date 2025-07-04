/**
 * Description: This class is real player
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.proxy.model;

import com.adam.app.design.pattern.demo.Util;

public class RealPlayer extends IGamePlayer{

    // constructor
    public RealPlayer(String name) {
        // log
        Util.log("RealPlayer: " + name);
    }

    @Override
    public void play() {
        // log
        Util.log("RealPlayer: play");
    }
}
