package com.adam.app.design.pattern.demo.proxy;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoProxyMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_proxy_instruction);
    }

    @Override
    public void startDemo() {
        // start demo proxy activity
        Intent intent = new Intent(this, DemoProxyStart.class);
        startActivity(intent);
    }
}
