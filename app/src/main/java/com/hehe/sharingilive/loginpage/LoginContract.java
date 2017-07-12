package com.hehe.sharingilive.loginpage;

import com.hehe.sharingilive.BasePresenter;
import com.hehe.sharingilive.BaseView;
import com.hehe.sharingilive.homepage.HomeContract;
import com.hehe.sharingilive.model.entity.User;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class LoginContract {

    interface View extends BaseView<LoginContract.Presenter> {
        void loginEnd(User user);
    }

    interface Presenter extends BasePresenter {
        void login(String username,String password);
        void register(String username,String password);
    }
}
