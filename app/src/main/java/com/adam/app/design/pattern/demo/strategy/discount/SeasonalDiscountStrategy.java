/**
 * Description: This class is for seasonal discount strategy.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy.discount;

public class SeasonalDiscountStrategy implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }

    @Override
    public String getBadgeText() {
        return "-10%";
    }

    @Override
    public String getBadgeColor() {
        return "#FB8C00";  // Orange
    }
}
