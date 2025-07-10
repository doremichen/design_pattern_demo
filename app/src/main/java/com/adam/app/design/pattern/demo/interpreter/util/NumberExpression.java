/**
 * Description: This class is the number expression class of the interpreter design pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.interpreter.util;

public class NumberExpression implements IExpression {

    // number
    private final int mNumber;

    public NumberExpression(int number) {
        this.mNumber = number;
    }

    @Override
    public int interpret() {
        return mNumber;
    }
}
