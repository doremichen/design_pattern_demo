/**
 * Description: This class is subject for observer pattern.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.observer.temparature;

import java.util.ArrayList;
import java.util.List;

public class TemperatureData implements ISubject {
    // observer list
    private final List<IObserver> mObserverList = new ArrayList<>();
    // temperature
    private String mTemperature = "--";

    /**
     * set temperature
     * @param temperature temperature
     */
    public void setTemperature(String temperature) {
        mTemperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        mObserverList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        mObserverList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : mObserverList) {
            observer.update(mTemperature);
        }
    }
}
