/**
 * Description: This class is the audio player adapter.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter.player;

import com.adam.app.design.pattern.demo.Util;

public class AudioPlayerAdapter implements IMediaPlayer {

    // Constant
    public static final String MP3 = "mp3";
    public static final String MP4 = "mp4";
    public static final String VLC = "vlc";
    // legacy audio player
    private final LegacyAudioPlayer mLegacyAudioPlayer = new LegacyAudioPlayer();

    // mp4 player
    private final Mp4Player mMp4Player = new Mp4Player();

    // vlc player
    private final VlcPlayer mVlcPlayer = new VlcPlayer();


    @Override
    public void play(String audioType, String fileName) {
        Util.log("AudioPlayerAdapter.play");
        switch (audioType.toLowerCase()) {
            case MP3:
                mLegacyAudioPlayer.playMp3(fileName);
                break;
            case MP4:
                mMp4Player.playMp4(fileName);
                break;
            case VLC:
                mVlcPlayer.playVlc(fileName);
                break;
            default:
                Util.log("Invalid media. Type: " + audioType);
                break;
        }
    }
}
