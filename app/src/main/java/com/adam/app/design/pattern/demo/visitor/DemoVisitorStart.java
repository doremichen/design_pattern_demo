/**
 * Description: This class is the start activity of visitor pattern demo
 * Author: Adam Chen
 * Date: 2025/07/09
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