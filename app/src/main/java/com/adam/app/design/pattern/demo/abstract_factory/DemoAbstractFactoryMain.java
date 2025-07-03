/**
 * Description: This is the main activity of the demo abstract factory pattern.
 * Author: Adam
 * Date: 2023/10/19
 */
package com.adam.app.design.pattern.demo.abstract_factory;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoAbstractFactoryMainBinding;

public class DemoAbstractFactoryMain extends AppCompatActivity {

    // view binding
    private ActivityDemoAbstractFactoryMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoAbstractFactoryMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set start button listener
        mBinding.btnStartDemo.setOnClickListener(v -> {
            // start activity
            Intent intent = new Intent(this, DemoAbstractFactoryStart.class);
            startActivity(intent);
        });

    }
}