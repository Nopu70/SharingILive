package com.hehe.sharingilive.livepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tarena on 2017/7/11.
 */

public class LiveFragment extends Fragment implements LiveContract.View {

    public static LiveFragment newInstance() {

        Bundle args = new Bundle();

        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LiveContract.Presenter presenter;
    @Override
    public void setPresent(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
