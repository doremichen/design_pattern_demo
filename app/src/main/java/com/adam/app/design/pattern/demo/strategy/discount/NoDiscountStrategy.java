/**
 * Description: This class is for no discount strategy.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy.discount;

public class NoDiscountStrategy implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }

    @Override
    public String getBadgeText() {
        return ""; // no display
    }

    @Override
    public String getBadgeColor() {
        return "#9E9E9E";
    }
}
