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


