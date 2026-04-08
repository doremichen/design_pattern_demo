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

package com.adam.app.design.pattern.demo.iterator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.iterator.data_set.IItemIterator;
import com.adam.app.design.pattern.demo.iterator.data_set.ItemCollection;

public class IteratorViewModel extends ViewModel {
    // Live data
    private final MutableLiveData<String> mCurrentItem = new MutableLiveData<>("-");
    public LiveData<String> getCurrentItem() {
        return mCurrentItem;
    }
    private final MutableLiveData<String> mLogText = new MutableLiveData<>("Iterator created\n");
    public LiveData<String> getLogText() {
        return mLogText;
    }
    private final MutableLiveData<Boolean> mHasNext = new MutableLiveData<>(true);
    public LiveData<Boolean> getHasNext() {
        return mHasNext;
    }

    // navigate event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));
    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    private IItemIterator mItemIterator;

    public IteratorViewModel() {
        startIterator();
    }


    private void startIterator() {
        ItemCollection itemCollection = new ItemCollection();
        mItemIterator = itemCollection.createIterator();
    }

    public void next() {
        if (mItemIterator == null) {
            startIterator();
        }

        boolean result = mItemIterator.hasNext();
        appendLog("hasNext() = " + result);
        mHasNext.setValue(result);
        // is finish?
        if (!result) {
            appendLog("Iterator finished");
            return;
        }

        String item = mItemIterator.next();
        appendLog("next() = " + item);
        mCurrentItem.setValue(item);
    }

    private void appendLog(String s) {
        mLogText.setValue(mLogText.getValue() + s + "\n");
    }

    // back to main list
    public void onBackButtonClick() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }

}
