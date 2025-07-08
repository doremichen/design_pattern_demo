/**
 * Description: This class is for clearance discount strategy.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy.discount;

public class ClearanceDiscountStrategy implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.5;
    }
}
