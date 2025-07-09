/**
 * Description: This is a demo activity for iterator pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.iterator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoIteratorStartBinding;
import com.adam.app.design.pattern.demo.iterator.data_set.IItemIterator;
import com.adam.app.design.pattern.demo.iterator.data_set.ItemCollection;

public class DemoIteratorStart extends AppCompatActivity {

    // view binding
    private ActivityDemoIteratorStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoIteratorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set show items button click listener
        mBinding.btnShowItems.setOnClickListener(v -> {
            //show items
            showItms();
        });

        // set back to main button click listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
        
    }

    private void showItms() {
        // ItemCollection instance
        ItemCollection itemCollection = new ItemCollection();
        // ItemIterator instance
        IItemIterator itemIterator = itemCollection.createIterator();
        // show items
        while (itemIterator.hasNext()) {
            String item = itemIterator.next();
        }
        // show result
        mBinding.txtResult.setText(Util.logMessage());
        // clear log
        Util.clearLog();
    }
}