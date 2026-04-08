/*
 * Copyright (c) 2026 Adam Chen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.adam.app.design.pattern.demo.interpreter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoInterpreterStartBinding;
import com.adam.app.design.pattern.demo.interpreter.util.IExpression;
import com.adam.app.design.pattern.demo.interpreter.util.InterpreterUtil;

public class DemoInterpreterStart extends AppCompatActivity {

    // view binding
    private ActivityDemoInterpreterStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoInterpreterStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set evaluating button click listener
        mBinding.btnEval.setOnClickListener(view -> {

            // hide soft keyboard
            Util.hideSoftKeyboard(this, view);

           // get user input
           String expression = mBinding.edtInput.getText().toString();
            try {
                // evaluate the expression
                int value = InterpreterUtil.evaluate(expression);
                // show the result
                mBinding.txtResult.setText(String.valueOf(value));
            } catch (Exception e) {
                // show error message
                mBinding.txtResult.setText(R.string.demo_interpreter_error_invalid_expression);
            }

        });

        // set simple calculate button click listener
        mBinding.btnSimple.setOnClickListener(view1 -> {

            // hide soft keyboard
            Util.hideSoftKeyboard(this, view1);

            // get user input
            String expression = mBinding.edtInput.getText().toString();
            try {
                IExpression expression1 = InterpreterUtil.parse(expression);
                int value = expression1.interpret();
                // show the result
                mBinding.txtResult.setText(String.valueOf(value));

            } catch (Exception e) {
                // show error message
                mBinding.txtResult.setText(R.string.demo_interpreter_error_invalid_expression);
            }
        });

        // set back to main button click listener
        mBinding.btnBackToMain.setOnClickListener(view1 -> {
            Util.backToMainActivity(this);
        });


    }
}