/**
 * Description: This class is used to define the support handler.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chainofresponsibility.handler;

import android.content.Context;

import com.adam.app.design.pattern.demo.chainofresponsibility.model.Response;

public abstract class SupportHandler {

    // Low
    public static final String PASSWORD = "password";
    public static final String LOGIN = "login";
    // Mid
    public static final String DATABASE = "database";
    public static final String ISSUE = "issue";
    // High
    public static final String NETWORK = "network";
    public static final String CRASH = "crash";
    // next handler
    protected SupportHandler mNextHandler;

    // set next handler
    public void setNextHandler(SupportHandler nextHandler) {
        mNextHandler = nextHandler;
    }

    /**
     * Handle request
     *
     * @param context context
     * @param request input request
     * @return processed request
     */
    public abstract Response handleRequest(Context context, String request);
}
