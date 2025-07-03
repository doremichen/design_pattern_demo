/**
 * Description: This is the main activity of the factory pattern demo.
 *            It shows the instruction and a button to start the demo.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.factory;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoFactoryMainBinding;

public class DemoFactoryMain extends AppCompatActivity {

    // view binding
    private ActivityDemoFactoryMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoFactoryMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set title
        setTitle(R.string.title_activity_demo_factory_main);

        // set start button listener
        mBinding.btnStartFactoryDemo.setOnClickListener(v -> {
            Intent intent = new Intent(this, DemoFactoryStart.class);
            startActivity(intent);
        });

    }
}