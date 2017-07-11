package com.hehe.sharingilive.regpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class RegActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return null;
    }

    RegContract.View view;
    RegContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (RegContract.View)fragment;
        presenter = new RegPresenter(view, new BaseModel());
        view.setPresent(presenter);
    }
}
