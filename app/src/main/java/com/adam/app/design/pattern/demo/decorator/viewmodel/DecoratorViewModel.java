/**
 * File: DecoratorViewModel.java
 * Description: this is the view model for the decorator demo
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-16
 */
package com.adam.app.design.pattern.demo.decorator.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.decorator.coffee.ICoffee;
import com.adam.app.design.pattern.demo.decorator.coffee.MilkDecorator;
import com.adam.app.design.pattern.demo.decorator.coffee.SimpleCoffee;
import com.adam.app.design.pattern.demo.decorator.coffee.SugarDecorator;
import com.adam.app.design.pattern.demo.decorator.coffee.VanillaDecorator;

import java.util.Locale;

public class DecoratorViewModel extends ViewModel {
    // Live data: two way data binding to checkbox
    public final MutableLiveData<Boolean> mAddMilk = new MutableLiveData<>(false);
    public final MutableLiveData<Boolean> mAddSugar = new MutableLiveData<>(false);
    public final MutableLiveData<Boolean> mAddVanilla = new MutableLiveData<>(false);

    // output text
    private final MutableLiveData<String> mDescription = new MutableLiveData<>("");
    private final MutableLiveData<String> mTotalCost = new MutableLiveData<>("");

    // navigation event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));


    // get live data
    public LiveData<String> getDescription() {
        return mDescription;
    }
    public LiveData<String> getTotalCost() {
        return mTotalCost;
    }
    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    /**
     * calculateOrder
     * make coffee by checkbox item
     *
     * @param context context
     */
    public void calculateOrder(Context context) {
        // make coffee
        ICoffee coffee = new SimpleCoffee();

        // decorator pattern
        if (mAddMilk.getValue()) {
            coffee = new MilkDecorator(coffee);
        }
        if (mAddSugar.getValue()) {
            coffee = new SugarDecorator(coffee);
        }
        if (mAddVanilla.getValue()) {
            coffee = new VanillaDecorator(coffee);
        }

        // output
        mDescription.setValue(coffee.getDescription(context));
        mTotalCost.setValue(String.format(Locale.getDefault(), "%.1f", coffee.getCost()));

    }

    // back to main list
    public void onBackToMainList() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }

}
