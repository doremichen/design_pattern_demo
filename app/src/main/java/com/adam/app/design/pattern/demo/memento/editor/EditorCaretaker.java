/**
 * Description: This class is caretaker for memento pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.memento.editor;

import java.util.Stack;

public class EditorCaretaker {
    // edit text memento state
    private final Stack<TextEditor.Memento> mMementoStack = new Stack<>();

    /**
     * save state
     * @param state last state
     */
    public void save(TextEditor.Memento state) {
        mMementoStack.push(state);
    }

    /**
     * undo state
     * @return last state
     */
    public TextEditor.Memento undo() {
        if (mMementoStack.isEmpty()) {
            return null;
        }
        return mMementoStack.pop();
    }

    /**
     * hasHistory
     * @return true if has history
     */
    public boolean hasHistory() {
        return !mMementoStack.isEmpty();
    }


}
