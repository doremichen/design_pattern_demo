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
