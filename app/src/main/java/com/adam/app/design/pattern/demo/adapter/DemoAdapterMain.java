/**
 * Description: This class is the main activity for the demo adapter pattern.
 *              It displays an instruction and a button to start the demo.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.adapter;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoAdapterMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_adapter_instruction);
    }

    @Override
    public void startDemo() {
        //start demo activity
        startActivity(new Intent(this, DemoAdapterStart.class));
    }
}
