package com.hehe.sharingilive.livepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class LiveActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return LiveFragment.newInstance();
    }

    LiveContract.Presenter presenter;
    LiveContract.View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (LiveContract.View)fragment;
        presenter = new LivePresenter(view, new BaseModel());
        view.setPresent(presenter);
    }
}
