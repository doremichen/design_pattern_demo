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