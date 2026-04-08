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

package com.adam.app.design.pattern.demo.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.adapter.player.AudioPlayerAdapter;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoAdapterStartBinding;

public class DemoAdapterStart extends AppCompatActivity {

    // view binding
    private ActivityDemoAdapterStartBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoAdapterStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set media type spinner
        // build spinner adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.media_formats, R.layout.spinner_item_layout);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        mBinding.spinnerFormat.setAdapter(adapter);

        // set play button click listener
        mBinding.btnPlay.setOnClickListener(v -> {
                // get media type
                String mediaType = mBinding.spinnerFormat.getSelectedItem().toString();
                // get file name
                String fileName = mBinding.edtFilename.getText().toString();
                playMedia(mediaType, fileName);

        });
        // set back button click listener
        mBinding.backToMain.setOnClickListener(v -> {
            // back to main list
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }

    /**
     * Play media based on media type and file name
     * @param mediaType media type
     * @param fileName file name
     */
    private void playMedia(String mediaType, String fileName) {
        Util.log("Play media: " + mediaType + ", " + fileName);
        // audio player adapter
        AudioPlayerAdapter audioPlayerAdapter = new AudioPlayerAdapter();
        // play media
        audioPlayerAdapter.play(mediaType, fileName);
        // show result
        mBinding.txtLog.setText(Util.logMessage());
        Util.clearLog();

    }
}