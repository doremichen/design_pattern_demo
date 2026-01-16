/**
 * Description: this is the start activity for the decorator demo
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoDecoratorStartBinding;
import com.adam.app.design.pattern.demo.decorator.viewmodel.DecoratorViewModel;

public class DemoDecoratorStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        ActivityDemoDecoratorStartBinding viewBinding = ActivityDemoDecoratorStartBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        // init view model
        DecoratorViewModel viewModel = new ViewModelProvider(this).get(DecoratorViewModel.class);
        // data binding to view
        viewBinding.setVm(viewModel);
        viewBinding.setLifecycleOwner(this);

        // observer
        viewModel.getNavigateEvent().observe(this, this::onNavigateEvent);


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