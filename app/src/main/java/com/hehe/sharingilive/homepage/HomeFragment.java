package com.hehe.sharingilive.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hehe.sharingilive.R;
import com.hehe.sharingilive.loginpage.LoginActivity;

/**
 * Created by tarena on 2017/7/11.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    private Button btn;
    private View view;
    private Button btnOpenLive;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        initView();
        addListener();
        return view;
    }

    private void addListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
        btnOpenLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开启直播
            }
        });
    }

    private void initView() {
        btn = view.findViewById(R.id.btn_register);
        btnOpenLive = view.findViewById(R.id.btn_open_live);
        RecyclerView rv = view.findViewById(R.id.LL_RecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        LiveListRecycleAdapter adapter = new LiveListRecycleAdapter(getContext());
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(adapter);
    }
}
