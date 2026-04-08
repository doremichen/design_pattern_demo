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

package com.adam.app.design.pattern.demo.mediator.user;

public abstract class User {
    // chat mediator
    protected IChatMediator mMediator;
    // name
    protected String mName;

    /**
     * MessageCallback interface is used to define the message callback.
     * This interface contains the method:
     * onMessageReceived(message)
     */
    public interface MessageCallback {
        void onMessageReceived(String message, String sender);
    }

    // message callback
    protected MessageCallback mMessageCallback;
    public void setMessageCallback(MessageCallback callback) {
        this.mMessageCallback = callback;
    }

    // construct
    public User(IChatMediator mediator, String name) {
        this.mMediator = mediator;
        this.mName = name;
    }

    // get name
    public String getName() {
        return this.mName;
    }

    // abstract methods: sendMessage, getMessage
    public abstract void sendMessage(String message);
    public abstract void getMessage(String message, User sender);

}
