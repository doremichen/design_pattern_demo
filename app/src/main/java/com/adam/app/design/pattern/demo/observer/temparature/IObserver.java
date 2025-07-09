/**
 * Description: This observer interface is for observer pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.observer.temparature;

public interface IObserver {
    /**
     * update temperature
     * @param newTemp new temperature
     */
    void update(String newTemp);
}
