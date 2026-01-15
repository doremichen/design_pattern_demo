/**
 * Description: This class is demo proxy pattern activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.proxy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoProxyStartBinding;
import com.adam.app.design.pattern.demo.proxy.adapter.LogAdapter;
import com.adam.app.design.pattern.demo.proxy.view_model.ProxyDemoViewModel;

public class DemoProxyStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        ActivityDemoProxyStartBinding viewBinding = ActivityDemoProxyStartBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        // view model
        ProxyDemoViewModel vm = new ViewModelProvider(this).get(ProxyDemoViewModel.class);

        // recycler view
        viewBinding.recyclerLogs.setLayoutManager(new LinearLayoutManager(this));
        viewBinding.recyclerLogs.setAdapter(new LogAdapter());
        // data binding
        viewBinding.setVm(vm);
        viewBinding.setLifecycleOwner(this);

        // observer
        vm.getNavigateEvent().observe(this, this::handleNavigateEvent);


    }


    private void handleNavigateEvent(Util.Event<Util.NavigateEvent> event) {
        Util.NavigateEvent ev = event != null ? event.getContentIfNotHandled() : null;
        if (ev == Util.NavigateEvent.BACK_TO_MENU) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }


}