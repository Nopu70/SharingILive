package com.hehe.sharingilive.livepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate()
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
