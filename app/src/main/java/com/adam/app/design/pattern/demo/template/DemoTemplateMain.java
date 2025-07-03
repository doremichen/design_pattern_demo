/**
 * Description: This is the main activity of the template pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.template;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.databinding.ActivityDemoTemplateMainBinding;

public class DemoTemplateMain extends AppCompatActivity {

    // view binding
    private ActivityDemoTemplateMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoTemplateMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set start button listener
        mBinding.btnStartDemo.setOnClickListener(v -> {
            // next activity
            Intent intent = new Intent(this, DemoTemplateStart.class);
            startActivity(intent);
        });

    }
}