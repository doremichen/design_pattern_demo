/**
 * Description: This class is abstract raw of bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge.abstraction;

import android.content.Context;

import com.adam.app.design.pattern.demo.bridge.implementor.IDevice;

public class RemoteControl {
    protected IDevice mDeivce;

    /**
     * construct
     */
    public RemoteControl(IDevice device) {
        this.mDeivce = device;
    }

    public void togglePower() {
        if (mDeivce.isEnabled()) mDeivce.disable();
        else mDeivce.enable();
    }

    public void volumeDown() {
        mDeivce.setVolume(mDeivce.getVolume() - 10);
    }

    public void volumeUp() {
        mDeivce.setVolume(mDeivce.getVolume() + 10);
    }

    public String getDeviceStatus(Context context) {
        return mDeivce.getStatus(context);
    }
}
