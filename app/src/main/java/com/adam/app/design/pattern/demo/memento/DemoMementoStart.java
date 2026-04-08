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

package com.adam.app.design.pattern.demo.memento;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoMementoStartBinding;
import com.adam.app.design.pattern.demo.memento.editor.EditorCaretaker;
import com.adam.app.design.pattern.demo.memento.editor.TextEditor;

public class DemoMementoStart extends AppCompatActivity {

    // text editor
    private TextEditor mTextEditor = new TextEditor();
    // text editor caretaker
    private EditorCaretaker mCaretaker = new EditorCaretaker();


    // view binding
    private ActivityDemoMementoStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoMementoStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set save button click listener
        mBinding.btnSave.setOnClickListener(v -> {

            // hide soft keyboard
            Util.hideSoftKeyboard(this, v);


            // get text from edit text
            String text = mBinding.edtText.getText().toString();
            // check if text is empty
            if (text.isEmpty()) {
                // show log
                Util.toast(this, getString(R.string.demo_memento_et_hint_enter_text));
                return;
            }

            // clear edit text
            mBinding.edtText.setText("");

            // set text to text editor
            mTextEditor.setText(text);
            // save text editor
            mCaretaker.save(mTextEditor.save());
            // show log
            mBinding.txtLog.setText(getString(R.string.demo_memento_state_log_save_success, text));
        });

        // set undo button click listener
        mBinding.btnUndo.setOnClickListener(v -> {

            // check if has history
            if (!mCaretaker.hasHistory()) {
                // show log
                mBinding.txtLog.setText(getString(R.string.demo_memento_state_log_undo_fail));

                // update edit text
                mBinding.edtText.setText("");

                return;
            }
            // get last state
            TextEditor.Memento lastState = mCaretaker.undo();
            // restore text editor
            mTextEditor.restore(lastState);
            String restoredText = mTextEditor.getText();
            // update edit text
            mBinding.edtText.setText(restoredText);
            // show log
            mBinding.txtLog.setText(getString(R.string.demo_memento_state_log_undo_success, restoredText));
        });

        // set back button click listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });

    }


}