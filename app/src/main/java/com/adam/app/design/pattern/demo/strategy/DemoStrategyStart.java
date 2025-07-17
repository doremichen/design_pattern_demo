/**
 * Description: This class is the start activity of strategy demo.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoStrategyStartBinding;
import com.adam.app.design.pattern.demo.strategy.discount.ClearanceDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.IDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.NoDiscountStrategy;
import com.adam.app.design.pattern.demo.strategy.discount.SeasonalDiscountStrategy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DemoStrategyStart extends AppCompatActivity {

    // view binding
    private ActivityDemoStrategyStartBinding mBinding;

    // strategy map: key is strategy name, value is strategy object
    private Map<String, IDiscountStrategy> mStrategyMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoStrategyStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // build strategy map
        mStrategyMap.put(getString(R.string.label_no_discount), new NoDiscountStrategy());
        mStrategyMap.put(getString(R.string.label_clearance_discount), new ClearanceDiscountStrategy());
        mStrategyMap.put(getString(R.string.label_seasonal_discount), new SeasonalDiscountStrategy());

        // build spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.strategy_types, R.layout.spinner_item_black);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        mBinding.spinnerStrategy.setAdapter(adapter);


        // set calculate button click listener
        mBinding.btnCalculate.setOnClickListener(v -> {

            // hide soft keyboard
            Util.hideSoftKeyboard(this, v);

            // get price from edit text
            double price = Double.parseDouble(mBinding.edtPrice.getText().toString());
            // get strategy from spinner
            String strategyName = mBinding.spinnerStrategy.getSelectedItem().toString();
            // get strategy object from strategy map
            IDiscountStrategy strategy = mStrategyMap.get(strategyName);
            // apply discount
            double discountedPrice = strategy.applyDiscount(price);
            // show result
            mBinding.txtResult.setText(String.format(Locale.getDefault(), "%.2f", discountedPrice));
        });

        // set back button click listener
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
}