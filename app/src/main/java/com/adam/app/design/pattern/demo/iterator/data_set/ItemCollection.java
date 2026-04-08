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

package com.adam.app.design.pattern.demo.iterator.data_set;

import com.adam.app.design.pattern.demo.Util;

import java.util.Arrays;
import java.util.List;

public class ItemCollection {
    // item list
    private final List<String> items = Arrays.asList("Apple", "Banana", "Cherry", "Date");

    /**
     * Create a new ItemIterator
     * @return ItemIterator
     */
    public IItemIterator createIterator() {
        return new ItemIteratorImp();
    }


    /**
     * This class ItemIteratorImp is Iterator implementation for ItemIterator
     */
    private class ItemIteratorImp implements IItemIterator {
        // index
        private int index = 0;

        @Override
        public boolean hasNext() {
            Util.log("hasNext: " + (index < items.size()));
            return index < items.size();
        }

        @Override
        public String next() {
            Util.log("next: " + items.get(index));
            return items.get(index++);
        }

        public int getIndex() {
            return index;
        }
    }

}
