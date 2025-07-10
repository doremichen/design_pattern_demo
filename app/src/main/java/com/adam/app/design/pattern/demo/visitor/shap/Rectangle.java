/**
 * Description: This class is the rectangle class of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

public class Rectangle implements IShape {
    // width, height
    private int mWidth;
    private int mHeight;

    /**
     * constructor
     */
    public Rectangle(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    // get width
    public int getWidth() {
        return mWidth;
    }

    // get height
    public int getHeight() {
        return mHeight;
    }

    @Override
    public void accept(Context context, IShapeVisitor visitor) {
        visitor.visitRectangle(context, this);
    }
}
