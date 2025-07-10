/**
 * Description: This device interface is the implementor of the demo bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge.implementor;

import android.content.Context;

public interface IDevice {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    String getStatus(Context context);
}
