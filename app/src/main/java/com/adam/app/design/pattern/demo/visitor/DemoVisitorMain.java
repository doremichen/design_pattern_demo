/**
 * Description: This is a demo visitor main activity for visitor pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.visitor;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoVisitorMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_vistor_instruction);

    }

    @Override
    public void startDemo() {
        // start visitor demo activity
        Util.startActivity(this, DemoVisitorStart.class);
    }
}
