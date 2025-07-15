/**
 * Description: This class is the main activity of the singleton demo.
 * Author: Adam Chen
 * Date: 2025/07/15
 */
package com.adam.app.design.pattern.demo.singleton;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoSingletonMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_singleton_instruction);
    }

    @Override
    public void startDemo() {
        // start demo singleton activity
        Util.startActivity(this, DemoSingletonStart.class);
    }
}
