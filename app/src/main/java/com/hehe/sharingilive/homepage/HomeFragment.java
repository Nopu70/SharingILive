package com.hehe.sharingilive.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tarena on 2017/7/11.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    HomeContract.Presenter presenter;
    @Override
    public void setPresent(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
