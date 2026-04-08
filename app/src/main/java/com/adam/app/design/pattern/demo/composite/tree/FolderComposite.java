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
