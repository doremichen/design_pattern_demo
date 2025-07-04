/**
 * Description: THis interface is used to define the user chat Mediator. This interface contains the method:
 * 1. sendMessage(message, user): This method is used to send a message to a user.
 *
 * Author: Adam Chen
 * Date: 2025/07/04
 */
package com.adam.app.design.pattern.demo.mediator.user;

public interface ChatMediator {
    void sendMessage(String message, User user);
}
