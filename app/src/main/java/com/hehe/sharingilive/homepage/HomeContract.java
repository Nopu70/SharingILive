package com.hehe.sharingilive.homepage;

import com.hehe.sharingilive.BasePresenter;
import com.hehe.sharingilive.BaseView;
import com.hehe.sharingilive.model.entity.User;

/**
 * 定义方法，用于数据交互
 * 保存view presenter 的父接口
 * 调用view中的方法，写抽象方法，然后在view中实现抽象方法，对UI进行更改
 * Created by tarena on 2017/7/11.
 */

public class HomeContract {

    interface View extends BaseView<Presenter>{
    }

    interface Presenter extends BasePresenter{
    }
}
