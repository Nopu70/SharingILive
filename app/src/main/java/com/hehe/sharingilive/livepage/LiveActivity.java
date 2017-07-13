package com.hehe.sharingilive.livepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.MyApplication;
import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.LiveBiz;
import com.hehe.sharingilive.model.entity.LiveList;

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

    public static Intent getStartIntent(int type, LiveList liveList){
        Intent intent = new Intent(MyApplication.context, LiveActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("liveList",liveList);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (LiveContract.View)fragment;
        presenter = new LivePresenter(view, new LiveBiz());
        view.setPresent(presenter);
    }
}
