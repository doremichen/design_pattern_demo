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

package com.adam.app.design.pattern.demo.abstractfactory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.abstractfactory.uicomponent.IButtonComponent;
import com.adam.app.design.pattern.demo.abstractfactory.uicomponent.ITextComponent;
import com.adam.app.design.pattern.demo.abstractfactory.uicomponent.IUIComponentFactory;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoAbstractFactoryStartBinding;

public class DemoAbstractFactoryStart extends AppCompatActivity {

    // view binding
    private ActivityDemoAbstractFactoryStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoAbstractFactoryStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // build spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.factory_types, R.layout.spinner_item_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        mBinding.spinnerFactory.setAdapter(adapter);


        // set generate button listener
        mBinding.btnGenerateUi.setOnClickListener(v -> {
            // generate components
            generateComponents();
        });
        
        
        // set back to main button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }

    private void generateComponents() {
        // get item from spinner
        final Object selectedItem = mBinding.spinnerFactory.getSelectedItem();
        // check if item is not null
        if (selectedItem == null) {
            Util.toast(this, getString(R.string.toast_error_no_item_selected));
            return;
        }
        // UIComponentFactory
        IUIComponentFactory factory = null;

        // convert item to string
        String item = selectedItem.toString();
        // check if item is dark theme
        if (item.equals(getString(R.string.dark_theme))) {
            factory = new DarkThemeFactory();
        } else if (item.equals(getString(R.string.light_theme))) {
            factory = new LightThemeFactory();
        }

        // check if factory is not null
        if (factory == null) {
            Util.toast(this, getString(R.string.toast_error_bit_flip));
            return;
        }
        // ButtonComponent and TextComponent
        IButtonComponent buttonComponent = factory.createButton();
        ITextComponent textComponent = factory.createText();
        // resultBuf: stringBuilder
        StringBuilder resultBuf = new StringBuilder();
        resultBuf.append(getString(R.string.abstract_factory_result_button));
        // append button component
        resultBuf.append(buttonComponent.render());
        resultBuf.append("\n");
        resultBuf.append(getString(R.string.abstract_factory_result_text));
        // append text component
        resultBuf.append(textComponent.render());
        // show result
        mBinding.txtResult.setText(resultBuf.toString());

    }
}