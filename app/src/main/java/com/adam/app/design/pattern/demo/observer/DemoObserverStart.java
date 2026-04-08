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

package com.adam.app.design.pattern.demo.observer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoObserverStartBinding;
import com.adam.app.design.pattern.demo.observer.temparature.IObserver;
import com.adam.app.design.pattern.demo.observer.temparature.TemperatureData;

public class DemoObserverStart extends AppCompatActivity {

    // view binding
    private ActivityDemoObserverStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set view binding
        mBinding = ActivityDemoObserverStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // initial observer1 and observer2 view
        mBinding.observer1.setText(getString(R.string.demo_observer_tv_observer_1, "--"));
        mBinding.observer2.setText(getString(R.string.demo_observer_tv_observer_2, "--"));

        // Temperature data
        TemperatureData temperatureData = new TemperatureData();
        // set observer
        temperatureData.registerObserver(new IObserver() {

            @Override
            public void update(String newTemp) {
                // update temperature in observer view 1
                mBinding.observer1.setText(getString(R.string.demo_observer_tv_observer_1, newTemp));
            }
        });
        temperatureData.registerObserver(new IObserver() {

            @Override
            public void update(String newTemp) {
                // update temperature in observer view 2
                mBinding.observer2.setText(getString(R.string.demo_observer_tv_observer_2, newTemp));
            }
        });


        // set update button click listener
        mBinding.btnUpdate.setOnClickListener(v -> {

            // hide soft keyboard
            Util.hideSoftKeyboard(this, v);

            // get new temperature from edit text
            String newTemp = mBinding.edtTemperature.getText().toString();
            // check if new temperature is empty
            if (newTemp.isEmpty()) {
                Util.toast(this, getString(R.string.toast_error_empty_temperature));
                return;
            }

            // update temperature data
            temperatureData.setTemperature(newTemp);

        });

        // set back button click listener
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });

    }
}