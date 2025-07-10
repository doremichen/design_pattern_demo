/**
 * Description: This class is draw visitor
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class DrawVisitor implements IShapeVisitor {

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
        mStrBuf.append(context.getString(R.string.demo_visitor_draw_circle_with_radius)).append(circle.getRadius()).append("\n");
    }

    @Override
    public void visitRectangle(Context context, Rectangle rectangle) {
        mStrBuf.append(context.getString(R.string.demo_visitor_draw_rectangle)).append(rectangle.getWidth())
                .append(context.getString(R.string.demo_visitor_x)).append(rectangle.getHeight()).append("\n");
    }
}
