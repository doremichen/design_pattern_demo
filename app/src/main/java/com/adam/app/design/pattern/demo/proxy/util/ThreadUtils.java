/**
 * File: ThreadUtils.java
 * Description: This file contains the implementation of the ThreadUtils class,
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.util;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static final ExecutorService IO = Executors.newSingleThreadExecutor();
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    public static void workByIO(Runnable task) {
        IO.execute(task);
    }

    public static void workByMain(Runnable task) {
        MAIN.post(task);
    }


}
