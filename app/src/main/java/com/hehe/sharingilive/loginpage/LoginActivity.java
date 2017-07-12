package com.hehe.sharingilive.loginpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hehe.sharingilive.BaseActivity;
import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.RegisterBiz;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class LoginActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return LoginFragment.newInstance();
    }

    LoginContract.Presenter presenter;
    LoginContract.View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (LoginContract.View)fragment;
        presenter = new LoginPresenter(view,new RegisterBiz());
        view.setPresent(presenter);
    }
}
