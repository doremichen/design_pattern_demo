/**
 * Description: This is the main activity of the factory pattern demo.
 *            It shows the instruction and a button to start the demo.
 * Author: Adam Chen
 * Date: 2025/07/15
 */
package com.adam.app.design.pattern.demo.factory;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoFactoryMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_factory_instruction);
    }

    @Override
    public void startDemo() {
        // start demo factory activity
        Util.startActivity(this, DemoFactoryStart.class);
    }
}
