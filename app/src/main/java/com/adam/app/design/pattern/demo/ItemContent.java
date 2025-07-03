/**
 * Description: This is ItemContent that contains the title, class name and package name of the activity.
 * Author: Adam Chen
 * Date: 2025/07/02
 */
package com.adam.app.design.pattern.demo;

public class ItemContent {

    private String mTitle;
    private String mClassName;
    private String mPkgName;

    public ItemContent(String title, String className, String pkgName) {
        this.mTitle = title;
        this.mClassName = className;
        this.mPkgName = pkgName;

    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public String getPkgName() {
        return this.mPkgName;
    }

}
