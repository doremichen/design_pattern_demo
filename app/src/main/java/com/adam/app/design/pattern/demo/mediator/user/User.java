/**
 * Description: This class is used to define the user.
 * Author: Adam Chen
 * Date: 2025/07/04
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
