/**
 * Description: This interface is the shap interface of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor.shap;

import android.content.Context;

public interface IShape {
    /**
     * accept
     *
     * @param context
     * @param visitor
     */
    void accept(Context context, IShapeVisitor visitor);
}
