/**
 * Description: This class is demo proxy pattern activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.proxy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoProxyStartBinding;
import com.adam.app.design.pattern.demo.proxy.model.IGamePlayer;
import com.adam.app.design.pattern.demo.proxy.model.ProxyPlayer;

public class DemoProxyStart extends AppCompatActivity {

    // view binding
    private ActivityDemoProxyStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoProxyStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set start button listener
        mBinding.btnPlay.setOnClickListener(v -> {
            // start demo
            startDemo();
        });

        // set back to main button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main
            Intent intent = new Intent(DemoProxyStart.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        });

    }

    private void startDemo() {
        //start demo
        IGamePlayer player = new ProxyPlayer("Adam");
        player.play();
        mBinding.txtResult.setText(Util.logMessage());
        // clear log
        Util.clearLog();

    }
}