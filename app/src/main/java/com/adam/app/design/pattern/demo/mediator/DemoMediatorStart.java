/**
 * Description: This class is used to define the demo mediator start activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.mediator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoMediatorStartBinding;
import com.adam.app.design.pattern.demo.mediator.viewmodel.MediatorViewModel;

public class DemoMediatorStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view binding
        ActivityDemoMediatorStartBinding viewBinding = ActivityDemoMediatorStartBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        // init view model
        // view model
        MediatorViewModel viewModel = new ViewModelProvider(this).get(MediatorViewModel.class);
        viewBinding.setVm(viewModel);
        viewBinding.setLifecycleOwner(this);

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