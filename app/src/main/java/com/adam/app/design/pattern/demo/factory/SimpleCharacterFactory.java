package com.adam.app.design.pattern.demo.factory;

import com.adam.app.design.pattern.demo.factory.character.Archer;
import com.adam.app.design.pattern.demo.factory.character.Hero;
import com.adam.app.design.pattern.demo.factory.character.ICharacter;
import com.adam.app.design.pattern.demo.factory.character.Mage;

public enum SimpleCharacterFactory {
    HERO {
        @Override
        public ICharacter createCharacter() {
            return new Hero();
        }

    },
    MAGE {
        @Override
        public ICharacter createCharacter() {
            return new Mage();
        }
   },
    ARCHER {
        @Override
        public ICharacter createCharacter() {
            return new Archer();
        }
    };

    public abstract ICharacter createCharacter();

    /**
     * Create a SimpleCharacterFactory from a string.
     * @param type The type of character to create.
     * @return The SimpleCharacterFactory for the given type.
     */
    public static SimpleCharacterFactory from(String type) {
        switch (type.toLowerCase()) {
            case "hero": return HERO;
            case "mage": return MAGE;
            case "archer": return ARCHER;
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

}


