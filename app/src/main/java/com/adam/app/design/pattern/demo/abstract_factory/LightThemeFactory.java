/**
 * Description: This is the light theme factory. It contains the methods:
 *              createButton: ButtonComponent and createText: TextFieldComponent.
 *              It also contains the static inner classes for the light theme components.
 *              The light theme components are used to render the light theme UI.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.abstract_factory;

import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.IButtonComponent;
import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.ITextComponent;
import com.adam.app.design.pattern.demo.abstract_factory.uicomponent.IUIComponentFactory;

public class LightThemeFactory implements IUIComponentFactory {
    @Override
    public IButtonComponent createButton() {
        return new LightButtonComponent();
    }
    @Override
    public ITextComponent createText() {
        return new LightTextComponent();
    }

    private static class LightButtonComponent implements IButtonComponent {
        @Override
        public String render() {
            return "Light Button";
        }
    }
    private static class LightTextComponent implements ITextComponent {
        @Override
        public String render() {
            return "Light Text";
        }
    }
}
