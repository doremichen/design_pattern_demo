/**
 * Description: This class is demo prototype pattern activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.prototype;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoPrototypeStartBinding;
import com.adam.app.design.pattern.demo.prototype.viewmodel.PrototypeViewModel;

public class DemoPrototypeStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        // view binding
        ActivityDemoPrototypeStartBinding viewBinding = ActivityDemoPrototypeStartBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        // view model
        PrototypeViewModel viewModel = new ViewModelProvider(this).get(PrototypeViewModel.class);
        viewBinding.setVm(viewModel);
        viewBinding.setLifecycleOwner(this);

        // observer
        viewModel.getNavigateEvent().observe(this, this::handleNavigateEvent);


    }

    private void handleNavigateEvent(Util.Event<Util.NavigateEvent> event) {
        Util.NavigateEvent ev = event != null ? event.getContentIfNotHandled() : null;
        if (ev == Util.NavigateEvent.BACK_TO_MENU) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }


}