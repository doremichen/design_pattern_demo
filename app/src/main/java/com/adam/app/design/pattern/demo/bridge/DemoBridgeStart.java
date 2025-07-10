/**
 * Description: This class is the start activity of the demo bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

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

        // set spinner item selected listener
        mBinding.spinnerDevice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String deviceName = parent.getItemAtPosition(position).toString();
                mRemoteControl = new RemoteControl(mDeviceMap.get(deviceName));

                updateStatus();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // set toggle power button click listener
        mBinding.btnTogglePower.setOnClickListener(v -> {
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