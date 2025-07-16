/**
 * Description: This is a demo facade start activity for facade pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
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