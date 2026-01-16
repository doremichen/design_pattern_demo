/**
 * Description: This class is used to define the low level support handler.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chainofresponsibility.handler;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.chainofresponsibility.model.Response;

public class LowLevelSupport extends SupportHandler{

    @Override
    public Response handleRequest(Context context, String request) {
        String result = context.getString(R.string.demo_chain_request_could_not_be_handled);
        // check request
        if (request != null) {

            // check request type
            if (request.toLowerCase().contains(PASSWORD) || request.toLowerCase().contains(LOGIN)) {
                result = context.getString(R.string.demo_chain_handled_by_low_level_support);
                return new Response(result, 1);
            }

            // check has next handler
            if (mNextHandler != null) {
                return mNextHandler.handleRequest(context, request);
            }

        }
        return new Response(result, 0);
    }
}
