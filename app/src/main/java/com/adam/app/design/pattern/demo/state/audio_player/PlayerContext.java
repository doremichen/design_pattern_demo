/**
 * Description: This class handle state change of the context of the audio player.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.state.audio_player;

import android.content.Context;

public class PlayerContext {
    // current state
    private PlayerState mCurrentState;

    /**
     * Constructor
     */
    public PlayerContext() {
        mCurrentState = PlayerState.STOPPED;
    }

    /**
     * get current state
     */
    public PlayerState getState() {
        return mCurrentState;
    }

    /**
     * play
     * @param context Context
     * @return String
     */
    public String play(Context context) {
        // set last state
        String lastState = mCurrentState.toString();
        // change state to playing
        mCurrentState = PlayerState.PLAYING;
        return mCurrentState.handle(context, lastState);
    }

    /**
     * pause
     * @param context Context
     * @return String
     */
    public String pause(Context context) {
        // set last state
        String lastState = mCurrentState.toString();
        // change state to paused
        mCurrentState = PlayerState.PAUSED;
        return mCurrentState.handle(context, lastState);
    }

    /**
     * stop
     * @param context Context
     * @return String
     */
    public String stop(Context context) {
        // set last state
        String lastState = mCurrentState.toString();
        // change state to stopped
        mCurrentState = PlayerState.STOPPED;
        return mCurrentState.handle(context, lastState);
    }

}
