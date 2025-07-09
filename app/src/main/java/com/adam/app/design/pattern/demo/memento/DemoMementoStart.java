/**
 * Description: This is a demo memento start activity for memento pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
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
            // get text from edit text
            String text = mBinding.edtText.getText().toString();
            // check if text is empty
            if (text.isEmpty()) {
                // show log
                Util.toast(this, getString(R.string.demo_memento_et_hint_enter_text));
                return;
            }

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