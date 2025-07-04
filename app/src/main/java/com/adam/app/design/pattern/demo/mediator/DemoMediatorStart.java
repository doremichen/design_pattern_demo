/**
 * Description: This class is used to define the demo mediator start activity.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.mediator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoMediatorStartBinding;
import com.adam.app.design.pattern.demo.mediator.user.ChatRoom;
import com.adam.app.design.pattern.demo.mediator.user.ConcreteUser;
import com.adam.app.design.pattern.demo.mediator.user.User;

public class DemoMediatorStart extends AppCompatActivity {

    //view binding
    private ActivityDemoMediatorStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDemoMediatorStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // init chat room
        ChatRoom chatRoom = new ChatRoom();
        // init user
        User[] users = new User[] {
                new ConcreteUser(chatRoom, "Adam"),
                new ConcreteUser(chatRoom, "Bob"),
                new ConcreteUser(chatRoom, "Scott"),
                new ConcreteUser(chatRoom, "Tom"),
                new ConcreteUser(chatRoom, "Jack"),
        };

        for (User user : users) {
            chatRoom.addUser(user);
            user.setMessageCallback((message, sender) -> {
                mBinding.txtLog.append(user.getName()
                        + getString(R.string.demo_mediator_receive_message)
                        + message
                        + getString(R.string.demo_mediator_from)
                        + sender
                        + "\n");
            });
        }

        // set send message button click listener
        mBinding.btnSend.setOnClickListener(v -> {
            String userName = mBinding.edtUserName.getText().toString();
            String message = mBinding.edtMessage.getText().toString();
            if (message.isEmpty() || userName.isEmpty()) {
                Util.toast(this, getString(R.string.toast_please_enter_your_name_and_message));
                return;
            }
            // init input user
            User inputUser = new ConcreteUser(chatRoom, userName);
            // send message
            inputUser.sendMessage(message);
        });
        // set back to main list button click listener
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            // back to main list
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // message callback should be null
        mBinding.edtUserName.setText("");
        mBinding.edtMessage.setText("");
        mBinding.txtLog.setText("");
        mBinding = null;

    }
}