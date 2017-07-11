package com.hehe.sharingilive.loginpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tarena on 2017/7/11.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LoginContract.Presenter presenter;
    @Override
    public void setPresent(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
