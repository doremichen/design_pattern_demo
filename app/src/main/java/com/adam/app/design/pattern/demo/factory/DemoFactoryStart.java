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

package com.adam.app.design.pattern.demo.factory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoFactoryStartBinding;
import com.adam.app.design.pattern.demo.factory.character.ICharacter;

public class DemoFactoryStart extends AppCompatActivity {

    // view binding
    private ActivityDemoFactoryStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoFactoryStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // build spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.character_types, R.layout.spinner_item_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        mBinding.spinnerType.setAdapter(adapter);

        // set create button listener
        mBinding.btnCreate.setOnClickListener(v -> {
           // selected in spinner
            final Object selectedItem = mBinding.spinnerType.getSelectedItem();
            // check if selected item is null
            if (selectedItem == null) {
                Util.toast(this, "No type selected item!!!");
                return;
            }


            String type = selectedItem.toString();
            // create character by SimpleCharacterFactory
            SimpleCharacterFactory factory = SimpleCharacterFactory.from(this , type);
            ICharacter character = factory.createCharacter();
            // show character name and special ability
            showResult(character);

        });

        // set back button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }

    private void showResult(ICharacter character) {
        StringBuilder resultBuf = new StringBuilder();
        resultBuf.append(getString(R.string.factory_result_character));
        resultBuf.append(character.getName());
        resultBuf.append("\n");
        resultBuf.append(getString(R.string.factory_result_special_ability));
        resultBuf.append(character.getSpecialAbility());
        mBinding.txtResult.setText(resultBuf.toString());
    }
}