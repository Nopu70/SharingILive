package com.hehe.sharingilive;

import android.app.Application;
import android.content.Context;

/**
 * Created by tarena on 2017/7/11.
 */

public class MyApplication extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
