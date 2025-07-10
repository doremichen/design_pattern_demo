/**
 * Description: This class is the shap visitor class of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

public interface IShapeVisitor {
    // circle visitor
    void visitCircle(Context context, Circle circle);
    // rectangle visitor
    void visitRectangle(Context context, Rectangle rectangle);
    // get result
    String getResult();

}
