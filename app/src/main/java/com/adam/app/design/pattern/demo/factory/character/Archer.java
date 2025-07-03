/**
 * Description: This class is used to define the archer class. This class implements the ICharacter interface.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.factory.character;

public class Archer implements ICharacter {
    @Override
    public String getName() {
        return "Archer";
    }

    @Override
    public String getSpecialAbility() {
        return "Arrow Storm";
    }
}
