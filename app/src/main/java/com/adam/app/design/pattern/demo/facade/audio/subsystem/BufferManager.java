/**
 * Description: This is a buffer manager subsystem for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.facade.audio.subsystem;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class BufferManager {

    /**
     * loadBuffer
     * @param context
     * @return String
     */
    public String loadBuffer(Context context) {
        String msg = this.getClass().getSimpleName() +
                ": " + context.getString(R.string.demo_facade_buffer_loaded_successfully);

        return msg;
    }

}


