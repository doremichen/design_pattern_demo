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
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.google.android.material.card.MaterialCardView;

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

    @BindingAdapter("handlerStrokeColor")
    public static void setHandlerStrokeColor(MaterialCardView card, int level) {
        int colorRes;
        switch (level) {
            case 1: colorRes = R.color.low_green; break;
            case 2: colorRes = R.color.mid_orange; break;
            case 3: colorRes = R.color.high_red; break;
            default: colorRes = R.color.grey_500; break;
        }
        card.setStrokeColor(ColorStateList.valueOf(
                ContextCompat.getColor(card.getContext(), colorRes)
        ));
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextView text, int level) {
        int colorRes;
        switch (level) {
            case 1: colorRes = R.color.low_green; break;
            case 2: colorRes = R.color.mid_orange; break;
            case 3: colorRes = R.color.high_red; break;
            default: colorRes = R.color.grey_500; break;
        }

        // set text color
        text.setTextColor(ContextCompat.getColor(text.getContext(), colorRes));

    }

    @BindingAdapter("cardBackgroundColor")
    public static void setCardBackgroundColor(MaterialCardView view, String colorString) {
        if (colorString != null && !colorString.isEmpty()) {
            try {
                view.setCardBackgroundColor(Color.parseColor(colorString));
            } catch (Exception e) {
                // default
                view.setCardBackgroundColor(Color.LTGRAY);
            }
        }
    }

}
