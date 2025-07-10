/**
 * Description: This class is the main activity of the demo state pattern.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.state;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoStateMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_state_instruction);

    }

    @Override
    public void startDemo() {
        // start demo state activity
        Util.startActivity(this, DemoStateStart.class);

    }
}
