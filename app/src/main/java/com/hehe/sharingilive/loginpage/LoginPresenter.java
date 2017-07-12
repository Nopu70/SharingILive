package com.hehe.sharingilive.loginpage;

import com.hehe.sharingilive.model.RegisterBiz;
import com.hehe.sharingilive.model.entity.User;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;
    RegisterBiz registerBiz;

    LoginPresenter(LoginContract.View view, RegisterBiz registerBiz){
        this.view = view;
        this.registerBiz = registerBiz;
    }

    @Override
    public void login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        registerBiz.login(user, new RegisterBiz.LoginEnd() {
            @Override
            public void loginend(User user) {
                view.loginEnd(user);
            }
        });
    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        registerBiz.register(user, new RegisterBiz.LoginEnd() {
            @Override
            public void loginend(User user) {
                view.loginEnd(user);
            }
        });
    }
}
