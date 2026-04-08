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
