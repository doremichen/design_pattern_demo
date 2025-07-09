/**
 * Description: This subject interface is for observer pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.observer.temparature;

public interface ISubject {

    /**
     * register observer
     * @param observer observer
     */
    void registerObserver(IObserver observer);
    /**
     * remove observer
     * @param observer observer
     */
    void removeObserver(IObserver observer);
    /**
     * notify observer
     */
    void notifyObservers();

}
