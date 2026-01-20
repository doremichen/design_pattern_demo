/**
 * Description: This class is the start activity of the demo bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.bridge.abstraction.RemoteControl;
import com.adam.app.design.pattern.demo.bridge.implementor.IDevice;
import com.adam.app.design.pattern.demo.bridge.implementor.Radio;
import com.adam.app.design.pattern.demo.bridge.implementor.TV;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoBridgeStartBinding;

import java.util.HashMap;
import java.util.Map;

public class DemoBridgeStart extends AppCompatActivity {

    // view binding
    private ActivityDemoBridgeStartBinding mBinding;
    // RemoteControl
    private RemoteControl mRemoteControl;
    // device mp
    private final Map<String, IDevice> mDeviceMap = new HashMap<>() {
        {
            put("TV", new TV());
            put("Radio", new Radio());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoBridgeStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        String[] devices = getResources().getStringArray(R.array.bridge_devices);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, devices);
        mBinding.autoCompleteDevice.setAdapter(adapter);

        // set the first item
        mBinding.autoCompleteDevice.setText(adapter.getItem(0), false);


        // set toggle power button click listener
        mBinding.btnTogglePower.setOnClickListener(v -> {
            // current device
            String device = mBinding.autoCompleteDevice.getText().toString();
            mRemoteControl = new RemoteControl(mDeviceMap.get(device));

            // toggle power
            mRemoteControl.togglePower();
            // update status
            updateStatus();
        });

        // set volume up button click listener
        mBinding.btnVolumeUp.setOnClickListener(v -> {
            // volume up
            mRemoteControl.volumeUp();
            // update status
            updateStatus();
        });

        // set volume down button click listener
        mBinding.btnVolumeDown.setOnClickListener(v -> {
            // volume down
            mRemoteControl.volumeDown();
            // update status
            updateStatus();
        });

        // set back to main button click listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });

    }

    /**
     * Update status
     */
    private void updateStatus() {
        mBinding.txtDeviceStatus.setText(mRemoteControl.getDeviceStatus(this));
    }

}