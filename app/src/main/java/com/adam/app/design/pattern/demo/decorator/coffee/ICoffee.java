/**
 * Description: this interface contains the methods for the coffee
 *            getDescription and getCost methods
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.decorator.coffee;

import android.content.Context;

public interface ICoffee {
    public String getDescription(Context context);
    public double getCost();
}
