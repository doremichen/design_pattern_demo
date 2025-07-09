/**
 * Description: This class contains one data list and iterator
 * Author: Adam Chen
 * Date: 2025/07/09
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
    }

}
