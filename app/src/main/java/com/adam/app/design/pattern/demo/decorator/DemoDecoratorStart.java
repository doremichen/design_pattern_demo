/**
 * Description: this is the start activity for the decorator demo
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoDecoratorStartBinding;
import com.adam.app.design.pattern.demo.decorator.coffee.ICoffee;
import com.adam.app.design.pattern.demo.decorator.coffee.MilkDecorator;
import com.adam.app.design.pattern.demo.decorator.coffee.SimpleCoffee;
import com.adam.app.design.pattern.demo.decorator.coffee.SugarDecorator;
import com.adam.app.design.pattern.demo.decorator.coffee.VanillaDecorator;

import java.util.HashMap;
import java.util.Map;

public class DemoDecoratorStart extends AppCompatActivity {

    // view binding
    private ActivityDemoDecoratorStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoDecoratorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set make coffee button listener
        mBinding.btnMakeCoffee.setOnClickListener(v -> makeCoffee());

        // set back to main list button listener
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }

    /**
     * make coffee by checkbox item
     */
    private void makeCoffee() {
        // simple coffee
        ICoffee coffee = new SimpleCoffee();
        // add milk
        if (mBinding.checkboxMilk.isChecked()) {
            coffee = new MilkDecorator(coffee);
        }
        // add sugar
        if (mBinding.checkboxSugar.isChecked()) {
            coffee = new SugarDecorator(coffee);
        }
        // add vanilla
        if (mBinding.checkboxVanilla.isChecked()) {
            coffee = new VanillaDecorator(coffee);
        }

        // show result
        mBinding.txtResult.setText(this.getString(R.string.demo_decorator_coffee_info_result, coffee.getDescription(this), coffee.getCost()));

    }

}