/**
 * Description: This class is originator for memento pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.memento.editor;

public class TextEditor {
    // text
    private String mText = "";

    /**
     * set text
     * @param text text
     */
    public void setText(String text) {
        mText = text;
    }

    /**
     * get text
     * @return text
     */
    public String getText() {
        return mText;
    }

    /**
     * save state of text editor
     */
    public Memento save() {
        return new Memento(mText);
    }

    /**
     * restore state of text editor
     * @param memento memento
     */
    public void restore(Memento memento) {
        mText = memento.getText();
    }

    /**
     * Memento class of text editor
     */
    public static class Memento {
        private final String mText;
        public Memento(String text) {
            mText = text;
        }
        public String getText() {
            return mText;
        }
    }

}
