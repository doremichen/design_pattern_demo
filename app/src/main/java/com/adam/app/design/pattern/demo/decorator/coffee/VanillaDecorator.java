/**
 * Description: this is the vanilla decorator class
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class VanillaDecorator extends absCoffeeDecorator{
    public VanillaDecorator(ICoffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(Context context) {
        return super.getDescription(context) + context.getString(R.string.demo_decorator_vanilla);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }
}
