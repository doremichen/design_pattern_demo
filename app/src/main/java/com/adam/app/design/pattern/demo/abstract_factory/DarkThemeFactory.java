/**
 * Description: This is the dark theme factory. It contains the methods:
 *              createButton: ButtonComponent and createText: TextFieldComponent.
 *              It also contains the static inner classes for the dark theme components.
 *              The dark theme components are used to render the dark theme UI.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.abstract_factory;

import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.IButtonComponent;
import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.ITextComponent;
import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.IUIComponentFactory;

public class DarkThemeFactory implements IUIComponentFactory {
    @Override
    public IButtonComponent createButton() {
        return new DarkButtonComponent();
    }
    @Override
    public ITextComponent createText() {
        return new DarkTextComponent();
    }

    private static class DarkButtonComponent implements IButtonComponent {
        @Override
        public String render() {
            return "Dark Button";
        }
    }

    private static class DarkTextComponent implements ITextComponent {
        @Override
        public String render() {
            return "Dark Text";
        }
    }
}
