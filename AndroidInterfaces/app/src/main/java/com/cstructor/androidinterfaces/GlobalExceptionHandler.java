package com.cstructor.androidinterfaces;

import android.util.Log;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler previous;

    public GlobalExceptionHandler(){
        previous = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e("GlobalExceptionHandler", ex.toString());

        previous.uncaughtException(thread,ex);
    }
}
