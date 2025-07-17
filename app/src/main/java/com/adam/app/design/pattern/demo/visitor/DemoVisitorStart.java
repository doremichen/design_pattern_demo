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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoVisitorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // build spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.visitor_type_options, R.layout.spinner_item_black);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        mBinding.spinnerVisitorType.setAdapter(adapter);

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
        // shape list
        List<IShape> shapes = new ArrayList<>();
        // add circle
        shapes.add(new Circle(10.0f));
        // add rectangle
        shapes.add(new Rectangle(10, 20));

        //selected visitor from spinner
        String visitorType = mBinding.spinnerVisitorType.getSelectedItem().toString();

        IShapeVisitor visitor = null;
        if (visitorType.equals(getString(R.string.demo_visitor_draw_visitor))) {
            // draw visitor
            visitor = new DrawVisitor();
            // accept all shapes
            for (IShape shape : shapes) {
                shape.accept(this, visitor);
            }
        } else if (visitorType.equals(getString(R.string.demo_visitor_area_visitor))) {
            // area visitor
            visitor = new AreaCalculatorVisitor();
            // accept all shapes
            for (IShape shape : shapes) {
                shape.accept(this, visitor);
            }
        }

        // set result
        mBinding.txtResult.setText(visitor.getResult());

    }
}