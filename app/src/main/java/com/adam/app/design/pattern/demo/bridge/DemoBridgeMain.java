/**
 * Description: This class is the main activity of the demo bridge pattern
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.bridge;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoBridgeMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_bridge_instruction);

    }

    @Override
    public void startDemo() {
        // start demo bridge activity
        Util.startActivity(this, DemoBridgeStart.class);

    }
}
