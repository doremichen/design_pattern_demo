/**
 * File: IteratorViewModel.java
 * Description: This class is the view model for the iterator demo activity.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-19
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
