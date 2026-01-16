/**
 * File: MediatorViewModel.java
 * Description: This class is the view model for the mediator demo activity.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-16
 */
package com.adam.app.design.pattern.demo.mediator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.mediator.user.ChatRoom;
import com.adam.app.design.pattern.demo.mediator.user.ConcreteUser;
import com.adam.app.design.pattern.demo.mediator.user.User;

public class MediatorViewModel  extends ViewModel {

    // TAG
    private static final String TAG = "MediatorViewModel";

    // chat mediator
    private final ChatRoom mChatRoom = new ChatRoom();

    // live data: two way data binding
    public final MutableLiveData<String> mInputName = new MutableLiveData<>("");
    public final MutableLiveData<String> mInputMessage = new MutableLiveData<>("");
    private final MutableLiveData<String> mSystemLog = new MutableLiveData<>("");
    // return live data: system log
    public LiveData<String> getSystemLog() {
        return mSystemLog;
    }

    // navigate event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));

    // used to notify activity to hide soft keyboard
    private final MutableLiveData<Boolean> mHideSoftKeyboard = new MutableLiveData<>(false);
    // return live data: hide soft keyboard
    public LiveData<Boolean> getHideSoftKeyboard() {
        return mHideSoftKeyboard;
    }

    // return live data: navigate event
    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    // constructor
    public MediatorViewModel() {
        // initial default member
        String[] defaultUsers = {"Adam", "Bob", "Scott"};
        for (String name : defaultUsers) {
            final ConcreteUser user = new ConcreteUser(mChatRoom, name);
            mChatRoom.addUser(user);
            // set message callback
            user.setMessageCallback((message, sender) -> {
                String currentLog = mSystemLog.getValue();
                mSystemLog.setValue(currentLog + name + " Receive from " + sender + " message: " + message + "\n");
            });
        }
    }

    public void onSendMessage() {
        String name = mInputName.getValue();
        String message = mInputMessage.getValue();

        // input check
        if (!validInput(name, message)) {
            // show log
            Util.errorDebug(TAG + ": Invalid input");
            // show system log
            String currentLog = mSystemLog.getValue();
            mSystemLog.setValue(currentLog + "Invalid input\n");
            return;
        }

        // send message
        User inputUser = new ConcreteUser(mChatRoom, name);
        inputUser.sendMessage(message);
        // clear input
        mInputName.setValue("");
        mInputMessage.setValue("");

        // hide soft keyboard
        mHideSoftKeyboard.setValue(true);

    }

    private boolean validInput(String name, String message) {
        return name != null
                && !name.isEmpty()
                && message != null
                && !message.isEmpty();
    }

    // back to main
    public void onBackMainClicked() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }

}
