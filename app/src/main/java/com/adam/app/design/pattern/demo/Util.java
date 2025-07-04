/**
 * Description: This is the utility class of the application.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public final class Util {
    private Util() {
    }

    // TAG: DesignPatternDemo
    private static final String TAG = "DesignPatternDemo";

    // logBuffer: stringBuilder
    private static final StringBuilder sLogBuffer = new StringBuilder();

    /**
     * Log message.
     * @param msg Message to log.
     */
    public static void log(String msg) {
        sLogBuffer.append(msg).append("\n");
    }

    /**
     * Log message.
     * @return Message to log.
     */
    public static String logMessage() {
        return sLogBuffer.toString();
    }

    /**
     * Log debug message.
     * @param msg Message to log.
     */
    public static void logDebug(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * Toast message.
     * @param context Context.
     * @param msg Message to toast.
     */
    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
