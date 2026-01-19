/**
 * Description: This class is the start activity of strategy demo.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoStrategyStartBinding;
import com.adam.app.design.pattern.demo.strategy.viewmodel.StrategyViewModel;

public class DemoStrategyStart extends AppCompatActivity {

    // view binding
    private ActivityDemoStrategyStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoStrategyStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //init view model
        StrategyViewModel vm = new ViewModelProvider(this).get(StrategyViewModel.class);
        // data bing to view binding
        mBinding.setVm(vm);
        // set lifecycle owner
        mBinding.setLifecycleOwner(this);

        // setup strategy items
        String[] Names = getResources().getStringArray(R.array.strategy_types);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Names);
        // set adapter
        mBinding.autoCompleteStrategy.setAdapter(adapter);

        // observer
        vm.getNavigateEvent().observe(this, this::onNavigate);
        vm.getHandleSoftKeyboard().observe(this, this::onHandleSoftKeyboard);

        }

    private void onHandleSoftKeyboard(Boolean hideSoftKeyboard) {
        if (hideSoftKeyboard) {
            Util.hideSoftKeyboard(this, mBinding.getRoot());
        }
    }

    private void onNavigate(Util.Event<Util.NavigateEvent> event) {
        Util.NavigateEvent navigateEvent = event.getContentIfNotHandled();
        if (navigateEvent != null) {
            if (navigateEvent == Util.NavigateEvent.BACK_TO_MENU) {
                Util.backToMainActivity(this);
            } else if (navigateEvent == Util.NavigateEvent.SHOW_TOAST) {
                // show toast
                Util.toast(this, getString(R.string.demo_strategy_toast_error_occurred));
            }
        }
    }
}