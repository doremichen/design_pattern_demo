/**
 * Description: This class is used to define the high level support handler.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chain_of_responsibility.handler;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class HighLevelSupport extends SupportHandler{

    @Override
    public String handleRequest(Context context, String request) {
        // check request
        if (request != null) {

            // check request type
            if (request.toLowerCase().contains(NETWORK) || request.toLowerCase().contains(CRASH)) {
                return context.getString(R.string.demo_chain_handled_by_high_level_support);
            }

            // check has next handler
            if (mNextHandler != null) {
                return mNextHandler.handleRequest(context, request);
            }

        }

        return context.getString(R.string.demo_chain_unhandled_request);
    }
}
