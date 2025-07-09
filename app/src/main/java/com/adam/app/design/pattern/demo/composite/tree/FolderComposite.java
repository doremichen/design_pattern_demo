/**
 * Description: This is the composite class of file component for composite pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.composite.tree;

import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements IFileComponent {
    // folder name
    private final String mFolderName;
    // file component list
    private final List<IFileComponent> children = new ArrayList<>();

    /**
     * Constructor.
     * @param msg Message to display.
     * @return Display message.
     */
    public FolderComposite(String msg) {
        mFolderName = msg;
    }

    /**
     * Add file component.
     * @param IFileComponent File component to add.
     */
    public void add(IFileComponent IFileComponent) {
        children.add(IFileComponent);
    }


    @Override
    public String display(String msg) {
        StringBuilder result = new StringBuilder(msg + "+ Folder: " + mFolderName + "\n");
        for (IFileComponent child : children) {
            result.append(child.display(msg + "  "));
        }
        return result.toString();
    }
}
