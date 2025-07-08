/**
 * Description: this is the sugar decorator class
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class SugarDecorator extends absCoffeeDecorator {
    public SugarDecorator(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(Context context) {
        return super.getDescription(context) + context.getString(R.string.demo_decorator_sugar);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }
}
