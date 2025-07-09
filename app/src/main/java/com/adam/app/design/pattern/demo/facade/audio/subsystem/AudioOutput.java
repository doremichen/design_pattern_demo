/**
 * Description: This is a audio output subsystem for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.facade.audio.subsystem;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class AudioOutput {

    /**
     * startOutput
     * @param context context
     * @return String
     */
    public String startOutput(Context context) {
        String msg = this.getClass().getSimpleName() +
                ": " +
                context.getString(R.string.demo_facade_audio_output_started);
        return msg;
    }
}
