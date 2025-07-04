/**
 * Description: This is class for Command pattern demo. The class is command role.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command.light;

import com.adam.app.design.pattern.demo.Util;

public class LightOnCommand implements ICommand {
    @Override
    public void execute() {
        Util.log("LightOnCommand execute");
        // light on
        Light.getInstance().on();
    }
}
