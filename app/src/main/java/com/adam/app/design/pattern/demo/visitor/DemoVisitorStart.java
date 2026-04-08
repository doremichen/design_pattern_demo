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

package com.adam.app.design.pattern.demo.visitor;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoVisitorStartBinding;
import com.adam.app.design.pattern.demo.visitor.shap.AreaCalculatorVisitor;
import com.adam.app.design.pattern.demo.visitor.shap.Circle;
import com.adam.app.design.pattern.demo.visitor.shap.DrawVisitor;
import com.adam.app.design.pattern.demo.visitor.shap.IShape;
import com.adam.app.design.pattern.demo.visitor.shap.IShapeVisitor;
import com.adam.app.design.pattern.demo.visitor.shap.Rectangle;

import java.util.ArrayList;
import java.util.List;

import com.adam.app.design.pattern.demo.R;

public class DemoVisitorStart extends AppCompatActivity {

    // view binding
    private ActivityDemoVisitorStartBinding mBinding;

    // shapes list
    private final List<IShape> mShapes = new ArrayList<>() {
        {
            add(new Circle(10.0f));
            add(new Rectangle(10, 20));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoVisitorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // create adapter for auto complete text view
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.visitor_type_options,
                android.R.layout.simple_dropdown_item_1line
        );
        mBinding.autoCompleteVisitor.setAdapter(adapter);

        // show the first item in the auto complete text view
        mBinding.autoCompleteVisitor.setText(adapter.getItem(0), false);


        // set run button click listener
        mBinding.btnRun.setOnClickListener(v -> {
            runDemo(); 
        });

        // set back button click listener
        mBinding.btnBack.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });

    }

    private void runDemo() {
        // get selected visitor type
        String visitorType = mBinding.autoCompleteVisitor.getText().toString();

        IShapeVisitor visitor = null;
        if (visitorType.equals(getString(R.string.demo_visitor_area_visitor))) {
            visitor = new AreaCalculatorVisitor();
        } else if (visitorType.equals(getString(R.string.demo_visitor_draw_visitor))) {
            visitor = new DrawVisitor();
        }

        // accept each shape in the list
        for (IShape shape : mShapes) {
            shape.accept(this, visitor);
        }

        if (visitor == null) {
            // show error message
            mBinding.txtResult.setText(R.string.demo_visitor_show_no_select_msg);
            return;
        }

        mBinding.txtResult.setText(visitor.getResult());
    }
}