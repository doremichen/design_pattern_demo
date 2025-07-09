/**
 * Description: This is a demo facade main activity for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.facade;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoFacadeMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_facade_instruction);

    }

    @Override
    public void startDemo() {
        // start demo facade activity
        Util.startActivity(this, DemoFacadeStart.class);
    }
}
