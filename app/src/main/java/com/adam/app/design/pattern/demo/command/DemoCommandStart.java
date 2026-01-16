/**
 * Description: This class is the start activity of command pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.command.viewmodel.CommandViewModel;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoCommandStartBinding;

public class DemoCommandStart extends AppCompatActivity {
    // TAG
    private static final String TAG = "DemoCommandStart";

    // view binding
    private ActivityDemoCommandStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.logDebug(TAG + ": onCreate");
        mBinding = ActivityDemoCommandStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // init view model
        CommandViewModel viewModel = new ViewModelProvider(this).get(CommandViewModel.class);
        mBinding.setVm(viewModel);
        mBinding.setLifecycleOwner(this);

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