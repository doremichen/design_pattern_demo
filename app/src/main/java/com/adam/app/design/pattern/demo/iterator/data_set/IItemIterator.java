/**
 * Description: This interface is used to define the iterator pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.iterator.data_set;

public interface IItemIterator {
    // hasNext: boolean
    boolean hasNext();
    // next: String
    String next();
}
