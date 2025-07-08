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
}
