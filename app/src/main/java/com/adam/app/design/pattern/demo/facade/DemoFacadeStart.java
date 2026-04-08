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

package com.adam.app.design.pattern.demo.facade;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoFacadeStartBinding;
import com.adam.app.design.pattern.demo.facade.audio.AudioPlayerFacade;

public class DemoFacadeStart extends AppCompatActivity {

    // view binding
    private ActivityDemoFacadeStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoFacadeStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set play button click listener
        mBinding.btnPlay.setOnClickListener(v -> {

            // dismiss soft keyboard
            Util.hideSoftKeyboard(this, v);

            // get song name
            String songName = mBinding.edtSongName.getText().toString();

            // check if song name is empty
            if (songName.isEmpty()) {
                Util.toast(this, getString(R.string.demo_facade_et_hint_enter_song_name));
                return;
            }

            // play song
            mBinding.txtLog.setText(new AudioPlayerFacade().playSound(this, songName));
        });

        // set back button click listener
        mBinding.btnBack.setOnClickListener(v -> {
            // back to main activity
            Util.backToMainActivity(this);
        });



    }
}