package com.hehe.sharingilive.loginpage;

import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;
    BaseModel model;

    LoginPresenter(LoginContract.View view, BaseModel model){
        this.view = view;
        this.model = model;
    }
}
