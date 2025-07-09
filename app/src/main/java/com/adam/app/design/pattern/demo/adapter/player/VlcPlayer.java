/**
 * Description: This class is the vlc player.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter.player;

import com.adam.app.design.pattern.demo.Util;

public class VlcPlayer {
    /**
     * playVlc
     * @param fileName
     */
    public void playVlc(String fileName) {
        Util.log("Playing vlc file by vlc player. Name: " + fileName);
    }
}
