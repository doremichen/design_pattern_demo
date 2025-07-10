/**
 * Description: This class is the main activity of the interpreter design pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.interpreter;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoInterpreterMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_interpreter_instruction);
    }

    @Override
    public void startDemo() {
        // start demo interpreter activity
        Util.startActivity(this, DemoInterpreterStart.class);
    }
}
