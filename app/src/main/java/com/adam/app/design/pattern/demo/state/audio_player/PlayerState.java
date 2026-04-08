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

package com.adam.app.design.pattern.demo.state.audio_player;

import android.content.Context;

import androidx.annotation.NonNull;

import com.adam.app.design.pattern.demo.R;

public enum PlayerState {
    STOPPED {

        @Override
        String handle(Context context, String lastState) {
            // from pause to stop
            if (lastState.equals(PAUSED_NAME)) {
                return context.getString(R.string.demo_state_stopping_from_pause);
            }

            // from play to stop
            if (lastState.equals(PLAYING_NAME)) {
                return context.getString(R.string.demo_state_stopping_playback);
            }

            return context.getString(R.string.demo_state_already_stopped);
        }

        @NonNull
        @Override
        public String toString() {
            return STOPPED_NAME;
        }
    },
    PLAYING {
        @Override
        String handle(Context context, String lastState) {

            // from stop to play
            if (lastState.equals(STOPPED_NAME)) {
                return context.getString(R.string.demo_state_switching_to_playing);
            }

            // from pause to play
            if (lastState.equals(PAUSED_NAME)) {
                return context.getString(R.string.demo_state_resuming_playback);
            }


            return context.getString(R.string.demo_state_already_playing);
        }


        @NonNull
        @Override
        public String toString() {
            return PLAYING_NAME;
        }

    },
    PAUSED {

        @Override
        String handle(Context context,String lastState) {

            // from play to pause
            if (lastState.equals(PLAYING_NAME)) {
                return context.getString(R.string.demo_state_pausing_music);
            }

            return context.getString(R.string.demo_state_already_paused);
        }

        @NonNull
        @Override
        public String toString() {
            return PAUSED_NAME;
        }

    };


    public static final String PLAYING_NAME = "PLAYING";
    public static final String PAUSED_NAME = "PAUSED";
    public static final String STOPPED_NAME = "STOPPED";

    // abstract methods: onPlay, onPause, onStop, onRelease
    abstract String handle(Context context, String lastState);
}
