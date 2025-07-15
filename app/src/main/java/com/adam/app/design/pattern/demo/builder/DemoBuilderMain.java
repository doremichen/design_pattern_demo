/**
 * Description: This class is the instruction activity of builder demo.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.builder;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoBuilderMain extends BaseInstructionActivity {


    @Override
    public String getInstruction() {
        return getString(R.string.demo_builder_instruction);
    }

    @Override
    public void startDemo() {
        Intent intent = new Intent(this, DemoBuilderStart.class);
        startActivity(intent);
    }
}
