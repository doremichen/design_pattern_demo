/**
 * Description: This is the main activity of the template pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/15
 */
package com.adam.app.design.pattern.demo.template;

import com.adam.app.design.pattern.demo.BaseInstructionActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;

public class DemoTemplateMain extends BaseInstructionActivity {
    @Override
    public String getInstruction() {
        return getString(R.string.demo_template_instruction);
    }

    @Override
    public void startDemo() {
        // start demo template activity
        Util.startActivity(this, DemoTemplateStart.class);
    }
}
