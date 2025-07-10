/**
 * Description: This class is the demo flyweight main activity
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoFlyweightMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_flyweight_instruction);

    }

    @Override
    public void startDemo() {
       // start demo flyweight activity
        Util.startActivity(this, DemoFlyweightStart.class);
    }
}
