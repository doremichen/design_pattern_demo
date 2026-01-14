/**
 * File: LogAdapter.java
 * Description: This class is the adapter for the recycler view.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adam.app.design.pattern.demo.R;

import java.util.ArrayList;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    private final List<String> datas = new ArrayList<>();

    @NonNull
    @Override
    public LogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView text = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_log_text, parent, false);
        return new ViewHolder(text);
    }

    @Override
    public void onBindViewHolder(@NonNull LogAdapter.ViewHolder holder, int position) {
        String data = datas.get(position);
        holder.mtextView.setText(data);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * Submit data to the adapter.
     * @param data the data to submit
     */
    public void submit(List<String> data) {
        if (data == null) {
            throw new NullPointerException("data cannot be null");
        }
        datas.clear();
        datas.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * View holder for the recycler view.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mtextView;
        public ViewHolder(@NonNull TextView itemView) {
            super(itemView);
            mtextView = itemView;
        }
    }
}
