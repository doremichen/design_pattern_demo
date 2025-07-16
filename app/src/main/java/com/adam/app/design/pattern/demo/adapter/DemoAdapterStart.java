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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.media_formats, R.layout.spinner_item_black);
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