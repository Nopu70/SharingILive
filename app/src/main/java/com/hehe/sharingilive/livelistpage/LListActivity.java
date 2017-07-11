package com.hehe.sharingilive.livelistpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class LListActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return LListFragment.newInstance();
    }

    LListContract.View view;
    LListContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (LListContract.View)fragment;
        presenter = new LListPresenter(view, new BaseModel());
        view.setPresent(presenter);
    }
}
