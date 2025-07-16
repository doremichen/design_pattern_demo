/**
 * Description: This is demo factory pattern activity. It contains a spinner to select the character type,
 *              and a button to create the character. The character is created by the SimpleCharacterFactory.
 *              The result is shown in a text view.
 *              The activity also has a back button to return to the main activity.
 * Author: Adam Chen
 * Date: 2025/07/03
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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.character_types, R.layout.spinner_item_black);
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