package com.hehe.sharingilive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by tarena on 2017/7/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Fragment fragment;
    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);

        FragmentManager manager = getSupportFragmentManager();
        fragment = manager.findFragmentById(R.id.container);
        if (fragment==null){
            fragment = createFragment();
            manager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}
