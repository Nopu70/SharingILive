package com.hehe.sharingilive;

import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.ucloud.ulive.UStreamingContext;

import cn.bmob.v3.Bmob;

/**
 *
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
        UStreamingContext.init(context, "publish3-key");
    }
}
