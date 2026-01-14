/**
 * File: Event.java
 * Description: This class is the event class for the view model.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.util;

public class Event<T> {
    private final T content;
    private boolean handled = false;
    public Event(T content) { this.content = content; }
    public T getContentIfNotHandled() {
        if (handled) return null;
        handled = true;
        return content;
    }
    public T peek() { return content; }
}

