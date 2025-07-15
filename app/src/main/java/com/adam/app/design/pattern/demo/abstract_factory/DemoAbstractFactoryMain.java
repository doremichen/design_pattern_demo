/**
 * Description: This is the main activity of the demo abstract factory pattern.
 * Author: Adam cHEN
 * Date: 2025/07/15
 */
package com.adam.app.design.pattern.demo.abstract_factory;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoAbstractFactoryMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_abstract_factory_instruction);
    }

    @Override
    public void startDemo() {
        // Start demo abstract factory activity
        Util.startActivity(this, DemoAbstractFactoryStart.class);

    }
}
