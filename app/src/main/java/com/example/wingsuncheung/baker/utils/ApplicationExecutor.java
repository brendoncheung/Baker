package com.example.wingsuncheung.baker.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationExecutor {

    private static final int THREAD_COUNT = 3;

    private static final Object LOCK = new Object();
    private static ApplicationExecutor sInstance;
    private final Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;


    public ApplicationExecutor(Executor diskIO, Executor mainThread, Executor networkIO) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public static ApplicationExecutor getsInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new ApplicationExecutor(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(THREAD_COUNT),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }
}
