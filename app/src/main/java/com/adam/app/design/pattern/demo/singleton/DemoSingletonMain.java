/**
 * Description: This activity is used to show the singleton demo.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.singleton;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoSingletonMainBinding;

public class DemoSingletonMain extends AppCompatActivity {

    // view binding
    private ActivityDemoSingletonMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoSingletonMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set title
        setTitle(R.string.title_activity_demo_singleton_main);
        // set start button listener
        mBinding.btnStart.setOnClickListener(v -> {
            // start singleton demo
            Intent intent = new Intent(this, DemoSingletonStart.class);
            startActivity(intent);
        });

    }
}