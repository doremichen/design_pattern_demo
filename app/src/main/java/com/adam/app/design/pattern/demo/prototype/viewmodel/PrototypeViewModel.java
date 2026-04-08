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
