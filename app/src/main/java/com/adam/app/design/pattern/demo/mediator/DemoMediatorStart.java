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