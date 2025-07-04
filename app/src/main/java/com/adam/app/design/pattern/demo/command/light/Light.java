/**
 * Description: This is class for Command pattern demo. The class is receiver role.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command.light;

import com.adam.app.design.pattern.demo.Util;

public class Light {

    private static class Helper {
        private static final Light INSTANCE = new Light();
    }

    public static Light getInstance() {
        return Helper.INSTANCE;
    }

    private Light() {
    }

    /**
     * On method
     */
    public void on() {
        Util.log("Light is on");
    }

    /**
     * Off method
     */
    public void off() {
        Util.log("Light is off");
    }

}
