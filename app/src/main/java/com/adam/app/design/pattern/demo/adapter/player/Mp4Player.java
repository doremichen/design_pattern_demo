/**
 * Description: This class is the mp4 player.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter.player;

import com.adam.app.design.pattern.demo.Util;

public class Mp4Player {
    /**
     * playMp4
     * @param fileName
     */
    public void playMp4(String fileName) {
        Util.log("Playing mp4 file by mp4 player. Name: " + fileName);
    }
}
