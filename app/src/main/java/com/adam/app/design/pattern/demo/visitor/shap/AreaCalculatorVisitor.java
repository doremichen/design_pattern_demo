/**
 * Description: This class is the area calculator class of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class AreaCalculatorVisitor implements IShapeVisitor {

    // strBuf: stringBuilder
    private StringBuilder mStrBuf = new StringBuilder();

    /**
     * getResult
     * @return String
     */
    @Override
    public String getResult() {
        return mStrBuf.toString();
    }


    @Override
    public void visitCircle(Context context, Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        mStrBuf.append(context.getString(R.string.demo_visitor_circle_area)).append(area).append("\n");

    }

    @Override
    public void visitRectangle(Context context, Rectangle rectangle) {
        int area = rectangle.getWidth() * rectangle.getHeight();
        mStrBuf.append(context.getString(R.string.demo_visitor_rectangle_area)).append(area).append("\n");
    }
}
