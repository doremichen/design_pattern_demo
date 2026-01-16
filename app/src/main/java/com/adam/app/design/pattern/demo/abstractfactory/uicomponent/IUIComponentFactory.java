/**
 * Description: This is the abstract factory interface for the UI component factory. It contains the methods:
 *              createButton: ButtonComponent and createText: TextFieldComponent.
 */
package com.adam.app.design.pattern.demo.abstractfactory.uicomponent;

public interface IUIComponentFactory {
    public IButtonComponent createButton();
    public ITextComponent createText();
}
