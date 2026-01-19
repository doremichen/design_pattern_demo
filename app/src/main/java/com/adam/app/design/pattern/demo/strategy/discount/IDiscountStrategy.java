/**
 * Description: This interface is for discount strategy that contains the discount method.
 *        applyDiscount(price: double): double method.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy.discount;

public interface IDiscountStrategy {
    double applyDiscount(double price);
    String getBadgeText(); // get badge text
    String getBadgeColor(); // get badge color
}
