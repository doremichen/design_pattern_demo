/**
 * Description: This class is demo prototype pattern main activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.prototype;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoPrototypeMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_prototype_instruction);
    }

    @Override
    public void startDemo() {
        // start demo prototype activity
        startActivity(new Intent(this, DemoPrototypeStart.class));
    }
}
