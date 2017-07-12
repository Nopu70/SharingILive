package com.hehe.sharingilive.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.model.BaseModel;
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
        presenter = new HomePresenter(view, new RegisterBiz());
        view.setPresent(presenter);
    }
}
