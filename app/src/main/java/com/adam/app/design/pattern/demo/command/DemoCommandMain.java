/**
 * Description: This class is used to define the demo command main activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.command;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoCommandMain extends BaseInstructionActivity {

    @Override
    public String getInstruction() {
        return getString(R.string.demo_command_instruction);

    }

    @Override
    public void startDemo() {
        //start demo command activity
        startActivity(new Intent(this, DemoCommandStart.class));
    }
}
