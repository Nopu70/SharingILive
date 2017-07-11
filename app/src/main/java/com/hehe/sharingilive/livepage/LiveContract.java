package com.hehe.sharingilive.livepage;

import com.hehe.sharingilive.BasePresenter;
import com.hehe.sharingilive.BaseView;
import com.hehe.sharingilive.loginpage.LoginContract;

/**
 * Created by tarena on 2017/7/11.
 */

public class LiveContract {

    interface View extends BaseView<LiveContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
