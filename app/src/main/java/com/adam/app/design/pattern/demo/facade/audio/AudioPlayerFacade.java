/**
 * Description: This is a audio player facade for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.facade.audio;

import android.content.Context;

import com.adam.app.design.pattern.demo.facade.audio.subsystem.AudioOutput;
import com.adam.app.design.pattern.demo.facade.audio.subsystem.BufferManager;
import com.adam.app.design.pattern.demo.facade.audio.subsystem.Decoder;

public class AudioPlayerFacade {
    // decoder subsystem
    private final Decoder mDecoder;
    // buffer manager subsystem
    private final BufferManager mBufferManager;
    // audio output subsystem
    private final AudioOutput mAudioOutput;

    /**
     * Constructor
     */
    public AudioPlayerFacade() {
        mDecoder = new Decoder();
        mBufferManager = new BufferManager();
        mAudioOutput = new AudioOutput();
    }

    /**
     * playSound
     * @param context context
     * @param file file name
     * @return String
     */
    public String playSound(Context context, String file) {
        StringBuilder sb = new StringBuilder();
        sb.append(mDecoder.decode(context, file)).append("\n");
        sb.append(mBufferManager.loadBuffer(context)).append("\n");
        sb.append(mAudioOutput.startOutput(context)).append("\n");
        return sb.toString();
    }
}
