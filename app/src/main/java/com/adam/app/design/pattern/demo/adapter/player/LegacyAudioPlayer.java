/**
 * Description: This class is the legacy audio player.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter.player;

import com.adam.app.design.pattern.demo.Util;

public class LegacyAudioPlayer {
    /**
     * playMp3
     * @param fileName
     */
    public void playMp3(String fileName) {
        Util.log("Playing mp3 file by legacy audio player. Name: " + fileName);
    }
}
