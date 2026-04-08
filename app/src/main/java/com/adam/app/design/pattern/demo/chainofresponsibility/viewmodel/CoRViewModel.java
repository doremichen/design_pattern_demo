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

package com.adam.app.design.pattern.demo.chainofresponsibility.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.chainofresponsibility.handler.HighLevelSupport;
import com.adam.app.design.pattern.demo.chainofresponsibility.handler.LowLevelSupport;
import com.adam.app.design.pattern.demo.chainofresponsibility.handler.MidLevelSupport;
import com.adam.app.design.pattern.demo.chainofresponsibility.handler.SupportHandler;
import com.adam.app.design.pattern.demo.chainofresponsibility.model.Response;

public class CoRViewModel extends ViewModel {
    // -- live data --
    // two way binding for input request
    public final MutableLiveData<String> mRequestInput = new MutableLiveData<>("");
    // result message
    private final MutableLiveData<String> mResultMessage = new MutableLiveData<>("");
    // level of support
    private final MutableLiveData<Integer> mHandlerLevel = new MutableLiveData<>(0);

    // navigate event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));

    // check if hide soft keyboard
    private final MutableLiveData<Boolean> mHideSoftKeyboard = new MutableLiveData<>(false);

    // --- getter ---
    public LiveData<String> getResultMessage() {
        return mResultMessage;
    }

    public LiveData<Integer> getHandlerLevel() {
        return mHandlerLevel;
    }

    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    public LiveData<Boolean> getHideSoftKeyboard() {
        return mHideSoftKeyboard;
    }

    // handler
    private final SupportHandler mChainHandler;

    // constructor
    public CoRViewModel() {
        // chain handler
        mChainHandler = buildChain();
    }

    private SupportHandler buildChain() {
        SupportHandler lowHandler = new LowLevelSupport();
        SupportHandler midHandler = new MidLevelSupport();
        SupportHandler highHandler = new HighLevelSupport();

        // chain
        lowHandler.setNextHandler(midHandler);
        midHandler.setNextHandler(highHandler);
        return lowHandler;
    }

    /**
     * On send request
     * @param context context
     */
    public void onSendRequest(Context context) {
        String request = mRequestInput.getValue();
        if (!validInput(request)) {
            // update result message
            mResultMessage.setValue("please enter your request!!!");
            return;
        }

        // hide soft keyboard
        mHideSoftKeyboard.setValue(true);


        // execute the chain of responsibility
        Response result = mChainHandler.handleRequest(context, request);
        // update result message
        mResultMessage.setValue(result.getResult());
        // update level
        mHandlerLevel.setValue(result.getLevel());
    }

    private boolean validInput(String input) {
        return input != null && !input.isEmpty();
    }

    // back to main
    public void onBackMainClicked() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }
}
