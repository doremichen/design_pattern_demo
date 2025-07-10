/**
 * Description: This TV class is the concrete implementor of the demo bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge.implementor;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class TV implements IDevice {
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
        return context.getString(R.string.demo_bridge_tv_is) +
                (mOn ? context.getString(R.string.demo_bridge_on) : context.getString(R.string.demo_bridge_off)) +
                context.getString(R.string.demo_bridge_volume) + mVolume;
    }
}
