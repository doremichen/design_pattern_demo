/**
 * Description: This is the utility class of the application.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

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
     * Clear log buffer.
     */
    public static void clearLog() {
        sLogBuffer.setLength(0);
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

    /**
     * start activity
     * @param context Context.
     * @param cls Class to start.
     */
    public static void startActivity(Context context, Class<?> cls) {
        WeakReference<Context> weakContext = new WeakReference<>(context);
        Context context1 = weakContext.get();
        context1.startActivity(new Intent(context1, cls));
    }

    /**
     * Back to main activity.
     * @param context Context.
     */
    public static void backToMainActivity(Context context) {
        WeakReference<Context> weakContext = new WeakReference<>(context);
        Context context1 = weakContext.get();
        final Intent intent = new Intent(context1, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context1.startActivity(intent);
    }

    /**
     * hideSoftKeyboard
     * @param context Context.
     * @param view View
     */
    public static void hideSoftKeyboard(Context context, View view) {
        WeakReference<Context> weakContext = new WeakReference<>(context);
        Context context1 = weakContext.get();
        if (context1 != null) {
            android.view.inputmethod.InputMethodManager imm = (android.view.inputmethod.InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

    }

    public enum NavigateEvent {
        NONE,
        BACK_TO_MENU;
    }

    public static class Event<T> {
        private final T content;
        private boolean handled = false;
        public Event(T content) { this.content = content; }
        public T getContentIfNotHandled() {
            if (handled) return null;
            handled = true;
            return content;
        }
        public T peek() { return content; }
    }
}
