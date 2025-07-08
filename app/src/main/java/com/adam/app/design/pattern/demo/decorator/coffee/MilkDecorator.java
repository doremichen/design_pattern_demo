/**
 * Description: this is the milk decorator class
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class MilkDecorator extends absCoffeeDecorator {
    public MilkDecorator(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(Context context) {
        return mCoffee.getDescription(context) + context.getString(R.string.demo_decorator_milk);
    }

    @Override
    public double getCost() {
        return mCoffee.getCost() + 0.5;
    }
}
