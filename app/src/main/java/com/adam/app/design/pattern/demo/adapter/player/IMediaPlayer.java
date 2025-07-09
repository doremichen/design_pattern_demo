/**
 * Description: This is the interface of the application.
 *              This interface contains methods: play(audiotype: string, filename: string): void
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter.player;

public interface IMediaPlayer {
    void play(String audioType, String fileName);
}
