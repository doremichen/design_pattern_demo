/**
 * Description: This class is used to define the demo chain start activity.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chainofresponsibility;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.chainofresponsibility.viewmodel.CoRViewModel;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoChainStartBinding;

public class DemoChainStart extends AppCompatActivity {

    // view binding
    private ActivityDemoChainStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDemoChainStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // init view model
        CoRViewModel viewModel = new ViewModelProvider(this).get(CoRViewModel.class);
        // data binding to view
        mBinding.setVm(viewModel);
        mBinding.setLifecycleOwner(this);

        // observer
        viewModel.getNavigateEvent().observe(this, this::onNavigateEvent);
        viewModel.getHideSoftKeyboard().observe(this, this::onHideSoftKeyboard);
    }

    private void onHideSoftKeyboard(Boolean shouldHide) {
        if (shouldHide == null) {
            return;
        }

        if (!shouldHide) {
            return;
        }

        // hide soft keyboard
        Util.hideSoftKeyboard(this, getCurrentFocus());
    }

    private void onNavigateEvent(Util.Event<Util.NavigateEvent> event) {
        Util.NavigateEvent ev = event != null ? event.getContentIfNotHandled() : null;
        if (ev == Util.NavigateEvent.BACK_TO_MENU) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }

}