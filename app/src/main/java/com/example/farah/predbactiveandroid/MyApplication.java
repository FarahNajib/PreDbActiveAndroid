package com.example.farah.predbactiveandroid;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by farah on 4/29/2017.
 */

public class MyApplication extends Application {

    /*
    Initialized ActiveAndroid Library
     */

    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Active Android
        ActiveAndroid.initialize(this);
    }
}