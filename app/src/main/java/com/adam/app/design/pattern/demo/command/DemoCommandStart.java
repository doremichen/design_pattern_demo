/**
 * Description: This class is the start activity of command pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.command.light.RemoteControl;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoCommandStartBinding;

public class DemoCommandStart extends AppCompatActivity {

    // view binding
    private ActivityDemoCommandStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDemoCommandStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // switch light
        mBinding.switchLight.setOnCheckedChangeListener((buttonView, isChecked) -> {
             // remote control
            RemoteControl.getInstance().getCommand(isChecked).execute();
            // show result
            mBinding.txtLog.setText(Util.logMessage());
            // clear log
            Util.clearLog();
        });

        // back button
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            // back to main list
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }
}