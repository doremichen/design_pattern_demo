package com.adam.app.design.pattern.demo.factory;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;
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
     *
     * @param context
     * @param type    The type of character to create.
     * @return The SimpleCharacterFactory for the given type.
     */
    public static SimpleCharacterFactory from(Context context, String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (type.equals(context.getString(R.string.demo_factory_type_hero))) {
            return HERO;
        } else if (type.equals(context.getString(R.string.demo_factory_type_mage))) {
            return MAGE;
        } else if (type.equals(context.getString(R.string.demo_factory_type_archer))) {
            return ARCHER;
        } else {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

}


