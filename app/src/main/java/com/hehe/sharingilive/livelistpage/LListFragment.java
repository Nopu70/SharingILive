package com.hehe.sharingilive.livelistpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tarena on 2017/7/11.
 */

public class LListFragment extends Fragment implements LListContract.View {

    public static LListFragment newInstance() {

        Bundle args = new Bundle();

        LListFragment fragment = new LListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LListContract.Presenter presenter;
    @Override
    public void setPresent(LListContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
