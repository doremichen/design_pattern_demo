/**
 * Description: This class is used to define the chat room.
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.mediator.user;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private final List<User> mUsers;
    public ChatRoom() {
        this.mUsers = new ArrayList<>();
    }

    // add user
    public void addUser(User user) {
        this.mUsers.add(user);
    }

    // clear user
    public void clearUser() {
        this.mUsers.clear();
    }

    public void sendMessage(String message, User user) {
        for (User u : this.mUsers) {
            // message should not be sent to the user
            if (u != user) {
                u.getMessage(message, user);
            }
        }
    }

}
