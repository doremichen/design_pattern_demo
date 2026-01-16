/**
 * File: Response.java
 * Description: This class is used to define the response model.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-16
 */
package com.adam.app.design.pattern.demo.chainofresponsibility.model;

public class Response {

    private final String mResult;
    private final int mLevel;

    /**
     * constructor
     */
    public Response(String result, int level) {
        mResult = result;
        mLevel = level;
    }

    // --- getter ---
    public String getResult() {
        return mResult;
    }
    public int getLevel() {
        return mLevel;
    }
}
