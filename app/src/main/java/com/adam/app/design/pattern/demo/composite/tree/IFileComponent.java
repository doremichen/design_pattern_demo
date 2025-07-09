/**
 * Description: This is the interface of file component for composite pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.composite.tree;

public interface IFileComponent {
    /**
     * Display file.
     * @param msg Message to display.
     * @return Display message.
     */
    String display(String msg);
}
