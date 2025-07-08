package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class SimpleCoffee implements ICoffee{
    @Override
    public String getDescription(Context context) {
        return context.getString(R.string.demo_decorator_simple_coffee);
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}
