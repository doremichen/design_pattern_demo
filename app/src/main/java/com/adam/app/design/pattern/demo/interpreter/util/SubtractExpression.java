/**
 * Description: This class is the subtract expression class of the interpreter design pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.interpreter.util;

public class SubtractExpression implements IExpression {
    // Expression left, right
    private final IExpression mLeft, mRight;

    public SubtractExpression(IExpression left, IExpression right) {
        this.mLeft = left;
        this.mRight = right;
    }

    @Override
    public int interpret() {
        return mLeft.interpret() - mRight.interpret();
    }
}
