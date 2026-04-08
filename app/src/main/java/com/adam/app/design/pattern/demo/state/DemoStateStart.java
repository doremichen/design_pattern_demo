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

package com.adam.app.design.pattern.demo.state;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoStateStartBinding;
import com.adam.app.design.pattern.demo.state.audio_player.PlayerContext;

public class DemoStateStart extends AppCompatActivity {

    // view binding
    private ActivityDemoStateStartBinding mBinding;

    // player status context
    private PlayerContext mPlayerContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoStateStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // init player context
        mPlayerContext = new PlayerContext();
        updateStatus();

        // set play button listener
        mBinding.btnPlay.setOnClickListener(v -> {
            String info = mPlayerContext.play(this);
            updateUI(info);
        });

        // set pause button listener
        mBinding.btnPause.setOnClickListener(v -> {
            String info = mPlayerContext.pause(this);
            updateUI(info);
        });

        // set stop button listener
        mBinding.btnStop.setOnClickListener(v -> {
            String info = mPlayerContext.stop(this);
            updateUI(info);
        });

        // set back button listener
        mBinding.btnBack.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });

    }

    /**
     * update the status of player
     */
    private void updateStatus() {
        // get the current state
        String state = mPlayerContext.getState().toString();
        // show the current state
        mBinding.txtStatus.setText(getString(R.string.demo_state_tv_current_state, state));
    }

    /**
     * update log view
     * @param log log string
     */
    private void updateUI(String log) {
        mBinding.txtLog.setText(log);
        // update status
        updateStatus();
    }

}