/**
 * Description: This is a demo memento main activity for memento pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.memento;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoMementoMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_memento_instruction);
                
    }

    @Override
    public void startDemo() {
        // start demo memento activity
        Util.startActivity(this, DemoMementoStart.class);
    }
}
