/**
 * Description: This is a demo instruction activity for observer pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.observer;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoObserverMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_observer_instruction);

    }

    @Override
    public void startDemo() {
        // start demo observer activity
        Util.startActivity(this, DemoObserverStart.class);
    }
}
