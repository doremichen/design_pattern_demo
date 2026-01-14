/**
 * File: BindingAdapters.java
 * Description: This class is the binding adapter for the recycler view.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.util;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.proxy.adapter.LogAdapter;

import java.util.List;

public class BindingAdapters {
    // TAG
    private static final String TAG = "BindingAdapters";

    @BindingAdapter("items")
    public static void setItems(RecyclerView view, List<String> items) {
        Util.logDebug(TAG + ": set items: " + items);
        LogAdapter adapter = (LogAdapter) view.getAdapter();
        if (adapter != null) {
            Util.logDebug(TAG + ": submit items: " + items);
            adapter.submit(items);
        }
    }
}
