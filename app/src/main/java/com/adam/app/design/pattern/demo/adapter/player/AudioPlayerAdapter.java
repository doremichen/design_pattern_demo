/*
 * Copyright (c) 2026 Adam Chen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
