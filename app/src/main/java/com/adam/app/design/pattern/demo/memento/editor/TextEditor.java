/*
 * Copyright (c) 2026 Adam Chen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
