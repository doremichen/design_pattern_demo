/**
 * File: PrototypeViewModel.java
 * Description: This class is the view model for the prototype demo activity.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-15
 */
package com.adam.app.design.pattern.demo.prototype.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.prototype.data.GameCharacter;

import java.util.Random;

public class PrototypeViewModel extends ViewModel {
    // live data: origCharacter, cloneCharacter
    private final MutableLiveData<GameCharacter> origCharacter = new MutableLiveData<>();
    private final MutableLiveData<GameCharacter> cloneCharacter = new MutableLiveData<>();

    // navigate event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));

    // constructor
    public PrototypeViewModel() {
        // init origCharacter
        origCharacter.setValue(new GameCharacter("Default", "Warrior", 100));
    }

    // -- get live data ---
    public LiveData<GameCharacter> getOrigCharacter() {
        return origCharacter;
    }

    public LiveData<GameCharacter> getCloneCharacter() {
        return cloneCharacter;
    }

    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    /**
     * Perform clone.
     */
    public void performClone() {
        GameCharacter base = origCharacter.getValue();
        if (base == null) {
            return;
        }
        // random
        Random random = new Random();
        int randomInt = random.nextInt(10);

        GameCharacter clone = base.clone();
        clone.setName(base.getName() + ": \" (Clone)\"");
        clone.setLevel(base.getLevel() + randomInt);
        clone.setType("Clone Warrior");
        cloneCharacter.setValue(clone);
    }

    public void onBackMainClicked() {
        // back to main
        //mNavigateEvent.setValue(NavigateEvent.BACK_TO_MENU);
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }

}
