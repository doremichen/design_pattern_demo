/**
 * Description: This activity is used to start the singleton demo.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.singleton;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

    }
}