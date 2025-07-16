/**
 * Description: This class is used to define the demo chain start activity.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chain_of_responsibility;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.chain_of_responsibility.handler.HighLevelSupport;
import com.adam.app.design.pattern.demo.chain_of_responsibility.handler.LowLevelSupport;
import com.adam.app.design.pattern.demo.chain_of_responsibility.handler.MidLevelSupport;
import com.adam.app.design.pattern.demo.chain_of_responsibility.handler.SupportHandler;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoChainStartBinding;

public class DemoChainStart extends AppCompatActivity {

    // view binding
    private ActivityDemoChainStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDemoChainStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        SupportHandler supportHandler = buildChain();

        // set send request button click listener
        mBinding.btnSendRequest.setOnClickListener(v -> {
            // dismiss input keyboard
            Util.hideSoftKeyboard(this, v);

            // get request
            String request = mBinding.edtRequestInput.getText().toString();
            // handle request
            String result = supportHandler.handleRequest(this, request);
            // show result
            mBinding.txtResultLog.setText(result);
        });

        // set back to main button click listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });


    }

    /**
     * build chain: Low , Mid , High
     */
    private SupportHandler buildChain() {
        // Low
        SupportHandler lowLevelSupport = new LowLevelSupport();
        // Mid
        SupportHandler midLevelSupport = new MidLevelSupport();
        // High
        SupportHandler highLevelSupport = new HighLevelSupport();

        // set chain
        lowLevelSupport.setNextHandler(midLevelSupport);
        midLevelSupport.setNextHandler(highLevelSupport);

        return lowLevelSupport;
    }

}