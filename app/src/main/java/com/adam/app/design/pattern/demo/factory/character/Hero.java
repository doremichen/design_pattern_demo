/**
 * Description: This class is used to define the hero class. This class implements the ICharacter interface.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.factory.character;

public class Hero implements ICharacter {
    @Override
    public String getName() {
        return "Hero";
    }

    @Override
    public String getSpecialAbility() {
        return "Bravery Slash";
    }
}
