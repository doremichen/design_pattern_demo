/**
 * File: StrategyViewModel.java
 * Description: This class is the view model for the strategy demo activity.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-19
 */
package com.adam.app.design.pattern.demo.strategy.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.strategy.discount.ClearanceDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.IDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.NoDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.SeasonalDiscountStrategy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StrategyViewModel extends AndroidViewModel {
    // two way data binding: input price
    public final MutableLiveData<String> mInputPrice = new MutableLiveData<>("");

    private final MutableLiveData<String> mDiscountedPrice = new MutableLiveData<>("0.00");
    // navigate event
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));

    // handle soft key board
    private final MutableLiveData<Boolean> mHandleSoftKeyboard = new MutableLiveData<>(false);

    // badge flag
    private final MutableLiveData<String> mBadgeText = new MutableLiveData<>("");
    private final MutableLiveData<String> mBadgeColor = new MutableLiveData<>("#9E9E9E");
    private final MutableLiveData<Integer> mBadgeVisible = new MutableLiveData<>(View.GONE);


    // constructor


    public StrategyViewModel(@NonNull Application application) {
        super(application);
        setupStrategies(application);
    }

    private void setupStrategies(Application application) {
        final String noDiscount = application.getResources().getString(R.string.demo_strategy_label_no_discount);
        final String seasonalDiscount = application.getResources().getString(R.string.demo_strategy_label_seasonal_discount);
        final String clearanceDiscount = application.getResources().getString(R.string.demo_strategy_label_clearance_discount);
        // build map: key is strategy name, value is strategy object
        mStrategyMap.put(noDiscount, new NoDiscountStrategy());
        mStrategyMap.put(seasonalDiscount, new SeasonalDiscountStrategy());
        mStrategyMap.put(clearanceDiscount, new ClearanceDiscountStrategy());
    }

    public LiveData<String> getDiscountedPrice() {
        return mDiscountedPrice;
    }

    // return live data: navigate event
    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    // strategy map: key is strategy name, value is strategy object
    private Map<String, IDiscountStrategy> mStrategyMap = new HashMap<>();

    // back button click event
    public void onBackButtonClick() {
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }


    // handle soft keyboard
    public LiveData<Boolean> getHandleSoftKeyboard() {
        return mHandleSoftKeyboard;
    }

    public LiveData<String> getBadgeText() {
        return mBadgeText;
    }

    public LiveData<String> getBadgeColor() {
        return mBadgeColor;
    }

    public LiveData<Integer> getBadgeVisible() {
        return mBadgeVisible;
    }


    // set item click event
    public void onCalculateButtonClick(AdapterView<?> parent, int position) {
        // input check
        if (parent == null || position < 0) {
            throw new IllegalArgumentException("parent or position is null");
        }

        String selected = parent.getItemAtPosition(position).toString();
        IDiscountStrategy strategy = mStrategyMap.get(selected);
        if (strategy != null) {
            // hide soft keyboard
            mHandleSoftKeyboard.setValue(true);
            onCalculate(strategy);
        }
    }

    private void onCalculate(IDiscountStrategy strategy) {
        // input price is empty
        if (mInputPrice.getValue() == null || mInputPrice.getValue().isEmpty()) {
            // show toast
            mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.SHOW_TOAST));
            return;
        }

        // get price
        try {
            double price = Double.parseDouble(mInputPrice.getValue());
            // get result according to strategy
            double result = strategy.applyDiscount(price);
            // update ui
            mDiscountedPrice.setValue(String.format(Locale.getDefault(), "%.2f", result));

           // update flag
            String text = strategy.getBadgeText();
            String color = strategy.getBadgeColor();

            mBadgeText.setValue(text);
            mBadgeColor.setValue(color);
            mBadgeVisible.setValue(text.isEmpty() ? View.GONE : View.VISIBLE);

        } catch (NumberFormatException e) {
            // show toast
            mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.SHOW_TOAST));
        }
    }

}
