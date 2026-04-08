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

package com.adam.app.design.pattern.demo.bridge.implementor;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class Radio implements IDevice {
    // on flag
    private boolean mOn = false;
    // volume
    private int mVolume = 30;


    @Override
    public boolean isEnabled() {
        return mOn;
    }

    @Override
    public void enable() {
        // turn on
        mOn = true;
    }

    @Override
    public void disable() {
        // turn off
        mOn = false;
    }

    @Override
    public int getVolume() {
        return mVolume;
    }

    @Override
    public void setVolume(int percent) {
        mVolume = Math.max(0, Math.min(100, percent));
    }

    @Override
    public String getStatus(Context context) {
        return context.getString(R.string.demo_bridge_radio_is) +
                (mOn ? context.getString(R.string.demo_bridge_on) : context.getString(R.string.demo_bridge_off)) +
                context.getString(R.string.demo_bridge_volume) + mVolume;
    }
}
