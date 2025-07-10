/**
 * Description: This class is the demo interpreter start activity
 * Author: Adam Chen
 * Date: 2025/07/10
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