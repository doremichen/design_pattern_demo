/**
 * Description: This class is used to define the mage class. This class implements the ICharacter interface.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.factory.character;

public class Mage implements ICharacter {
    @Override
    public String getName() {
        return "Mage";
    }

    @Override
    public String getSpecialAbility() {
        return "Fireball Spell";
    }
}
