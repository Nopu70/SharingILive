package com.hehe.sharingilive.model;

import android.os.Looper;
import android.util.Log;

import com.hehe.sharingilive.model.entity.User;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 注册登录数据处理
 * Created by tarena on 2017/7/11.
 */

public class RegisterBiz extends BaseModel {
    /**
     * 登录到Bmob，环信
     */
    public void login(User user, final LoginEnd loginEnd) {
        user.login(new SaveListener<User>() {
            @Override
            public void done(final User user, BmobException e) {
                if (e == null) {
                    loginEnd.loginend(user);
                    new Thread() {
                        @Override
                        public void run() {
                            EMClient.getInstance().login(user.getUsername(), Const.HX_PASSWORD, new EMCallBack() {
                                @Override
                                public void onSuccess() {
                                }
                                @Override
                                public void onError(int code, String error) {
                                }
                                @Override
                                public void onProgress(int progress, String status) {
                                }
                            });
                        }
                    }.start();
                } else {
                    loginEnd.loginend(null);
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 注册到Bmob，环信
     */
    public void register(User user, final LoginEnd loginEnd) {
        //// TODO: 2017/7/12  暂且设置默认图像，后面可以更新
        user.setHeaderImg("http://img.hb.aicdn.com/22249e2a72a324115deb7600b081b82ae25426605ead0-d3WsIS_fw658");
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(final User user, BmobException e) {
                if (e == null) {
                    loginEnd.loginend(user);
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                EMClient.getInstance().createAccount(user.getUsername(), Const.HX_PASSWORD);
                            } catch (HyphenateException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    loginEnd.loginend(null);
                    e.printStackTrace();
                }
            }
        });
    }

    public interface LoginEnd {
        void loginend(User user);
    }
}
