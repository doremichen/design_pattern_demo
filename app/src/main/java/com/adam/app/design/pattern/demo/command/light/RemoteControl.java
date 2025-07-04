/**
 * Description: This is class for Command pattern demo. The class is invoker role.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command.light;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoteControl {

    private static class Helper {
        private static final RemoteControl INSTANCE = new RemoteControl();

    }

    public static RemoteControl getInstance() {
        return Helper.INSTANCE;
    }

    private RemoteControl() {
    }


    // CommandMap: HashMap
    // key: Boolean
    // value: ICommand
    private final Map<Boolean, ICommand> mCommandMap = new HashMap<>() {
        {
            put(true, new LightOnCommand());
            put(false, new LightOffCommand());
        }
    };

    /**
     * get Command by boolean
     */
    @NonNull
    public ICommand getCommand(boolean status) {
        return Objects.requireNonNull(mCommandMap.get(status));
    }

}
