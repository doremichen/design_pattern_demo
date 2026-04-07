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

package com.adam.app.design.pattern.demo.singleton;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoSingletonStartBinding;

public class DemoSingletonStart extends AppCompatActivity {

    // view binding
    private ActivityDemoSingletonStartBinding mBinding;

    // logBuffer string for output
    private StringBuilder mLogBuffer = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoSingletonStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set title
        setTitle(R.string.title_activity_demo_singleton_main);

        // initial text output
        mLogBuffer.append(this.getString(R.string.singleton_result_init_1))
                .append(this.getString(R.string.singleton_result_init_2));
        mBinding.txtOutput.setText(mLogBuffer.toString());

        // set generate button listener
        mBinding.btnGenerate.setOnClickListener(v -> {
            // get singleton object
            SigletonObj singletonObj = SigletonObj.getInstance();
            // result
            String result = singletonObj.log(this.getString(R.string.singleton_result_log_1));
            // append result to log buffer
            mLogBuffer.append(result).append("\n");
            // set text output
            mBinding.txtOutput.setText(mLogBuffer.toString());
        });

        // set back button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}