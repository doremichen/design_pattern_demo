/**
 * Description: This class is the base class of all instruction activities.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.databinding.ActivityBaseInstructionBinding;

public abstract class BaseInstructionActivity extends AppCompatActivity {

    // view binding
    private ActivityBaseInstructionBinding mBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBaseInstructionBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.txtInstruction.setText(getInstruction());
        mBinding.btnStartDemo.setOnClickListener(v -> startDemo());

    }

    public abstract String getInstruction();
    public abstract void startDemo();

}