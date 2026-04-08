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

package com.adam.app.design.pattern.demo.prototype.data;

import androidx.annotation.NonNull;

public class GameCharacter implements Cloneable {

    // name
    private String mName;
    // type
    private String mType;
    // level
    private int mLevel;
    // prototype ID
    private final String mPrototypeId;


    // constructor
    public GameCharacter(String name, String type, int level) {
        mName = name;
        mType = type;
        mLevel = level;
        mPrototypeId = "PROTO-" + System.currentTimeMillis();
    }

    @NonNull
    @Override
    public GameCharacter clone() {
        try {
            return (GameCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // set name
    public void setName(String name) {
        mName = name;
    }

    // set type
    public void setType(String type) {
        mType = type;
    }

    // set level
    public void setLevel(int level) {
        mLevel = level;
    }

    // --- getter ---
    // get name
    public String getName() {
        return mName;
    }
    // get type
    public String getType() {
        return mType;
    }
    // get level
    public int getLevel() {
        return mLevel;
    }
    // get prototype ID
    public String getPrototypeId() {
        return mPrototypeId;
    }

    // get hash code
    public int getHashCode() {
        return System.identityHashCode(this);
    }


    // toString
    @NonNull
    @Override
    public String toString() {
        return "GameCharacter{" +
                "mName='" + mName + '\'' +
                ", mType='" + mType + '\'' +
                ", mLevel=" + mLevel + '\'' +
                ", From: " + mPrototypeId + '\'' +
                ", HashCode=" + System.identityHashCode(this) +
                '}';
    }

}
