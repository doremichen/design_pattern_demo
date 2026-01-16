/**
 * Description: This class is used to define the demo chain main activity.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.chainofresponsibility;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoChainMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_chain_instruction);
    }

    @Override
    public void startDemo() {
        // Start demo here
        startActivity(new Intent(this, DemoChainStart.class));
    }
}
