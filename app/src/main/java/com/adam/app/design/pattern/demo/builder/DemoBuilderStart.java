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

package com.adam.app.design.pattern.demo.builder;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.builder.model.Computer;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoBuilderStartBinding;

public class DemoBuilderStart extends AppCompatActivity {

    // view binding
    private ActivityDemoBuilderStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDemoBuilderStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set created button listener
        mBinding.btnCreateComputer.setOnClickListener(v ->
        {
            buildComputer();
        });


        // set back to main button listener
        mBinding.btnBackToMain.setOnClickListener(v ->
        {
            // intent to main activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }

    /**
     * Build computer
     */
    private void buildComputer() {
        // create builder
        Computer.Builder builder = new Computer.Builder();
        // check checkbox
        if (mBinding.checkboxCpu.isChecked()) {
            builder.setCpu("CPU: Intel i7");
        }
        if (mBinding.checkboxRam.isChecked()) {
            builder.setRam("RAM: 16GB");
        }
        if (mBinding.checkboxStorage.isChecked()) {
            builder.setHdd("HDD: 1TB");
        }
        if (mBinding.checkboxGpu.isChecked()) {
            builder.setGpu("GPU: NVIDIA RTX 3080");
        }
        // build computer
        Computer computer = builder.build();
        // set result
        mBinding.txtResult.setText(computer.getInfo(this));
    }
}