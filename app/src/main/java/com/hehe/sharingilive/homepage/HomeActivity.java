package com.hehe.sharingilive.homepage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.MyApplication;
import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.LiveBiz;
import com.hehe.sharingilive.model.RegisterBiz;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class HomeActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return HomeFragment.newInstance();
    }

    HomeContract.Presenter presenter;
    HomeContract.View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = (HomeContract.View) fragment;
        presenter = new HomePresenter(view, new LiveBiz());
        view.setPresent(presenter);
        checkStorage();
    }
    /**
     * 获取数据存储的权限
     */
    public void checkStorage() {
        //如果已经授权，则存储数据，没有授权，请求授权
        if (ContextCompat.checkSelfPermission(MyApplication.context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
            }
        }
    }
}
