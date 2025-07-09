/**
 * Description: This is a demo activity for iterator pattern.This activity has one instruction and start demo button.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.iterator;

import android.content.Intent;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;

public class DemoIteratorMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_iterator_instruction);
    }

    @Override
    public void startDemo() {
        // start demo iterator activity
        startActivity(new Intent(this, DemoIteratorStart.class));
    }
}
