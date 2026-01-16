package com.adam.app.design.pattern.demo.mediator.user;

import com.adam.app.design.pattern.demo.Util;

public class ConcreteUser extends User {

    public ConcreteUser(IChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        mMediator.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message, User sender) {
        Util.log(sender.getName() + " sent message: " + message);
        // check callback
        if (mMessageCallback != null) {
            mMessageCallback.onMessageReceived(message, sender.getName());
        }
    }

}
