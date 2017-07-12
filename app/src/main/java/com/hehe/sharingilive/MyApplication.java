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
        Bmob.initialize(this,"e8c8cf2d8f11e100ee821f5eb6ae6ced");
        EMOptions options = new EMOptions();
        EMClient.getInstance().init(this, options);




        context = getApplicationContext();
    }
}
