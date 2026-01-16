/**
 * File: BindingUtils.java
 * Description: This class is used to define the binding utils.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-16
 */
package com.adam.app.design.pattern.demo;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

public class BindingUtils {
    @BindingAdapter("tint")
    public static void setImageViewTint(ImageView view, int colorResId) {
        if (colorResId == 0) {
            return;
        }

        int finalColor;
        try {
            // (R.color.xxx)
            finalColor = ContextCompat.getColor(view.getContext(), colorResId);
        } catch (Resources.NotFoundException e) {
            // (example 0xFF9E9E9E)
            finalColor = colorResId;
        }

        view.setImageTintList(ColorStateList.valueOf(finalColor));
    }
}
