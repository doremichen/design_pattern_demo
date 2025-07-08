/**
 * Description: this is the abstract class for the decorator
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

public abstract class absCoffeeDecorator implements ICoffee {

    protected ICoffee mCoffee;

    public absCoffeeDecorator(ICoffee coffee) {
        mCoffee = coffee;
    }

    @Override
    public String getDescription(Context context) {
        return mCoffee.getDescription(context);
    }

    @Override
    public double getCost() {
        return mCoffee.getCost();
    }
}
