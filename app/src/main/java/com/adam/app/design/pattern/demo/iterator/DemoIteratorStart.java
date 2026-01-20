/**
 * Description: This is a demo activity for iterator pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.iterator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoIteratorStartBinding;
import com.adam.app.design.pattern.demo.iterator.data_set.IItemIterator;
import com.adam.app.design.pattern.demo.iterator.data_set.ItemCollection;
import com.adam.app.design.pattern.demo.iterator.viewmodel.IteratorViewModel;

public class DemoIteratorStart extends AppCompatActivity {

    // view binding
    private ActivityDemoIteratorStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoIteratorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // init view model
        IteratorViewModel viewModel = new ViewModelProvider(this).get(IteratorViewModel.class);
        // data binding to vew model
        mBinding.setVm(viewModel);
        // set lifecycle owner
        mBinding.setLifecycleOwner(this);

        // observer
        viewModel.getNavigateEvent().observe(this, this::onNavigate);

        
    }

    private void onNavigate(Util.Event<Util.NavigateEvent> event) {
        Util.NavigateEvent navigateEvent = event.getContentIfNotHandled();
        if (navigateEvent != null) {
            if (navigateEvent == Util.NavigateEvent.BACK_TO_MENU) {
                Util.backToMainActivity(this);
            }
        }
    }

}