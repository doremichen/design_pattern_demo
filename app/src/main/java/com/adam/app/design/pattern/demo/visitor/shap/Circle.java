/**
 * Description: This class is the circle class of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

public class Circle implements IShape {
    // radius
    private float mRadius;

    public Circle(float radius) {
        mRadius = radius;
    }

    /**
     * get radius
     */
    public float getRadius() {
        return mRadius;
    }


    @Override
    public void accept(Context context, IShapeVisitor visitor) {
        visitor.visitCircle(context, this);
    }
}
