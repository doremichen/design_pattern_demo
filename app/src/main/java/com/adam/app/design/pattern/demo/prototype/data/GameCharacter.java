/**
 * Description: This class is used to demo prototype pattern.
 * Author: Adam Chen
 * Date: 2025/07/04
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
