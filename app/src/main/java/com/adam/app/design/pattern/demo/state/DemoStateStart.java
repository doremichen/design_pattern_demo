/**
 * Description: This class is the start activity of the state design pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/10
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