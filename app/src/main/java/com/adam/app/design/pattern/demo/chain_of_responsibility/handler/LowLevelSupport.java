/**
 * Description: This class is used to define the low level support handler.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chain_of_responsibility.handler;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class LowLevelSupport extends SupportHandler{

    @Override
    public String handleRequest(Context context, String request) {
        // check request
        if (request != null) {

            // check request type
            if (request.toLowerCase().contains(PASSWORD) || request.toLowerCase().contains(LOGIN)) {
                return context.getString(R.string.demo_chain_handled_by_low_level_support);
            }

            // check has next handler
            if (mNextHandler != null) {
                return mNextHandler.handleRequest(context, request);
            }

        }
        return context.getString(R.string.demo_chain_request_could_not_be_handled);
    }
}
