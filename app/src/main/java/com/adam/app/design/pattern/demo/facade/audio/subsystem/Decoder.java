/**
 * Description: This is a decoder subsystem for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.facade.audio.subsystem;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class Decoder {

    /**
     * decode
     * @param context context
     * @param file file name
     * @return String
     */
    public String decode(Context context, String file) {

        String msg = this.getClass().getSimpleName() + ": " +
                context.getString(R.string.demo_facade_decoding_song) + file;

        return msg;
    }
}
