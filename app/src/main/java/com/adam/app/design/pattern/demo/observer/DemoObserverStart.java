/**
 * Description: This is a demo observer activity for observer pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
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