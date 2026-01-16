/**
 * File: CommandViewModel.java
 * Description: This class is the view model for the command demo activity.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-16
 */
package com.adam.app.design.pattern.demo.command.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.command.light.ICommand;
import com.adam.app.design.pattern.demo.command.light.RemoteControl;

public class CommandViewModel extends ViewModel {
    // Live data
    // used to check the light on/off status
    private MutableLiveData<Boolean> mIsLightOn = new MutableLiveData<>(false);
    // used to display status log
    private MutableLiveData<String> mStatusLog = new MutableLiveData<>("");
    // navigate event
    private MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));

    // -- get live data --
    public LiveData<Boolean> getIsLightOn() {
        return mIsLightOn;
    }

    public LiveData<String> getStatusLog() {
        return mStatusLog;
    }

    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    public void onLightSwitchChanged(boolean checked) {
        // Command pattern demo
        ICommand command = RemoteControl.getInstance().getCommand(checked);
        command.execute();

        // update UI
        mIsLightOn.setValue(checked);
        mStatusLog.setValue(checked ? "Light is on" : "Light is off");
    }

    // back to main
    public void onBackMainClicked() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }
}
