/**
 * Description: This class is the main activity of strategy demo.
 * Author: Adam Chen
 * Date: 2025/07/08
 */
package com.adam.app.design.pattern.demo.strategy;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoStrategyMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.strategy_description);
    }

    @Override
    public void startDemo() {
        //start demo activity
        startActivity(new Intent(this, DemoStrategyStart.class));
    }
}
