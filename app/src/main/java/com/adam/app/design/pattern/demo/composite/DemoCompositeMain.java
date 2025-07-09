/**
 * Description: This is a demo activity for composite pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.composite;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoCompositeMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_composite_instruction);
    }

    @Override
    public void startDemo() {
        // start demo composite activity
        Util.startActivity(this, DemoCompositeStart.class);
    }
}
