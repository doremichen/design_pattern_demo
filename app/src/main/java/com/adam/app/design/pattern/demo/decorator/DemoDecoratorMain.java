package com.adam.app.design.pattern.demo.decorator;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoDecoratorMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_decorator_instruction);
    }

    @Override
    public void startDemo() {
        //Start demo here
        Intent intent = new Intent(this, DemoDecoratorStart.class);
        startActivity(intent);
    }
}
