/**
 * Description: This is the leaf class of file component for composite pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.composite.tree;

public class FileLeaf implements IFileComponent {
    // file name
    private final String mFileName;

    public FileLeaf(String fileName) {
        mFileName = fileName;
    }

    @Override
    public String display(String msg) {
        return msg + "- File: " + mFileName + "\n";
    }
}
