package com.adam.app.design.pattern.demo.mediator;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoMediatorMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_mediator_instruction);

    }

    @Override
    public void startDemo() {
        // start demo mediator start activity
        startActivity(new Intent(this, DemoMediatorStart.class));
    }
}
