package com.example.task.common;

import android.app.Application;

import com.example.task.di.Injector;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       Injector.init(getApplicationContext());
    }
}
