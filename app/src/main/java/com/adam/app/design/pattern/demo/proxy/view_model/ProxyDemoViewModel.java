/**
 * File: ProxyDemoViewModel.java
 * Description: This class is the view model of the proxy demo.
 *
 * @author Adam Chen
 * @version 1.0 - 2026-01-13
 */
package com.adam.app.design.pattern.demo.proxy.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.proxy.model.IGamePlayer;
import com.adam.app.design.pattern.demo.proxy.model.PlayerFactory;
import com.adam.app.design.pattern.demo.proxy.util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class ProxyDemoViewModel extends AndroidViewModel {
    // TAG
    private static final String TAG = "ProxyDemoViewModel";

    private final List<String> mBuffer = new ArrayList<>();
    // live data
    private final MutableLiveData<Boolean> mUseProxy = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> useProxy = mUseProxy; // for data binding in layout

    private final MutableLiveData<Boolean> mLoading = new MutableLiveData<>(false);
    private final MutableLiveData<String> mStatusText = new MutableLiveData<>("Ready");
    private final MutableLiveData<List<String>> mLogs = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Util.Event<Util.NavigateEvent>> mNavigateEvent = new MutableLiveData<>(new Util.Event<>(Util.NavigateEvent.NONE));
    public ProxyDemoViewModel(@NonNull Application application) {
        super(application);

    }


    // --- get live data ---

    public LiveData<Boolean> getLoading() {
        return mLoading;
    }

    public LiveData<String> getStatusText() {
        return mStatusText;
    }

    public LiveData<List<String>> getLogs() {
        return mLogs;
    }

    public LiveData<Util.Event<Util.NavigateEvent>> getNavigateEvent() {
        return mNavigateEvent;
    }

    public void onClearClicked() {
        mBuffer.clear();
        mLogs.setValue(new ArrayList<>(mBuffer));
        mStatusText.setValue("Cleared");
    }

    public void onPlayClicked() {
        mLoading.setValue(true);
        mStatusText.setValue("Playing...");
        append("=== Play start (useProxy=" + mUseProxy.getValue() + ") ===");
        // start demo
        // work thread

        ThreadUtils.workByIO(() -> {
            try {
                startDemo();
                ThreadUtils.workByMain(this::updateStatus);
            } catch (Exception e) {
                ThreadUtils.workByMain(() -> handleException(e));
            }
        });

//        try {
//            ThreadUtils.workByIO(this::startDemo);
//        } catch (Exception e) {
//            ThreadUtils.workByMain(this::handleException);
//        }

    }

    public void onBackMainClicked() {
        // back to main
        //mNavigateEvent.setValue(NavigateEvent.BACK_TO_MENU);
        mNavigateEvent.setValue(new Util.Event<>(Util.NavigateEvent.BACK_TO_MENU));
    }


    private void handleException(Exception e) {
        mLoading.setValue(false);
        append("=== Play failed: " + (e != null ? e.getMessage() : "unknown") + " ===");
        mStatusText.setValue("Play Failed");
    }


    private void handleException() {
        ThreadUtils.workByMain(() -> {
            mLoading.postValue(false);
            append("=== Play failed ===");
            mStatusText.postValue("Play Failed");
        });
    }

    private void startDemo() {
        Util.logDebug(TAG + ": start demo");
        // check if use proxy
        boolean useProxy = Boolean.TRUE.equals(mUseProxy.getValue());
        // create player
        IGamePlayer player = PlayerFactory.createPlayer(useProxy, "Adam");
        player.play(new IGamePlayer.LogSink() {
            @Override
            public void add(String msg) {
                Util.logDebug(TAG + ": add log: " + msg);
                append(TAG + ":");
                append(msg);
            }
        });
        // update status
        ThreadUtils.workByMain(this::updateStatus);

    }

    private void updateStatus() {
        mLoading.postValue(false);
        append("=== Play done ===");
        mStatusText.postValue("Play Done");
    }

    private void append(String msg) {
        synchronized (mBuffer) {
            mBuffer.add(msg);
            mLogs.postValue(new ArrayList<>(mBuffer));
        }
    }

}
