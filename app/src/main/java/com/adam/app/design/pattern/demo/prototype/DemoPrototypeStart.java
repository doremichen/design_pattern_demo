/**
 * Description: This class is demo prototype pattern activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.prototype;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoPrototypeStartBinding;
import com.adam.app.design.pattern.demo.prototype.data.GameCharacter;

public class DemoPrototypeStart extends AppCompatActivity {

    // view binding
    private ActivityDemoPrototypeStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoPrototypeStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // set clone character button listener
        mBinding.btnCloneCharacter.setOnClickListener(v -> {
            // clone character
            cloneCharacter();
        });

        // set back to main button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main
            Intent intent = new Intent(DemoPrototypeStart.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            
        });



    }

    private void cloneCharacter() {
        // Game character
        GameCharacter orig = new GameCharacter("Default", "Warrior", 100);
        // clone character
        GameCharacter clone = orig.clone();
        // set clone name
        clone.setName("Clone");
        // set clone level
        clone.setLevel(200);
        // set clone type
        clone.setType("Clone Warrior");
        // set result
        mBinding.txtResult.setText(getString(orig, clone));

    }

    @NonNull
    private static String getString(GameCharacter org, GameCharacter clone) {
        return org.toString() +
                "\n" +
                clone.toString();
    }
}