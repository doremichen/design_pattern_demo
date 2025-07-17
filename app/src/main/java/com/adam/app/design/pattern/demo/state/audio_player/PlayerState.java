/**
 * Description: This enum class is used to represent the state of the audio player.
 * Author: Adam Chen
 * Date: 2025/07/10
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
