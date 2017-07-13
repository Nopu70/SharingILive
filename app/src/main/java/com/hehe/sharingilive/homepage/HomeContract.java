package com.hehe.sharingilive.homepage;

import com.hehe.sharingilive.BasePresenter;
import com.hehe.sharingilive.BaseView;
import com.hehe.sharingilive.model.entity.LiveList;
import com.hehe.sharingilive.model.entity.User;

import java.util.List;

/**
 * 定义方法，用于数据交互
 * 保存view presenter 的父接口
 * 调用view中的方法，写抽象方法，然后在view中实现抽象方法，对UI进行更改
 * Created by tarena on 2017/7/11.
 */

public class HomeContract {

    interface View extends BaseView<Presenter> {
        void onSaveDataEnd(LiveList liveList, int openOrWatch);

        /**
         * 正在直播的列表信息更新完毕
         *
         * @param liveLists
         */
        void onUpateDataEnd(List<LiveList> liveLists);
    }

    interface Presenter extends BasePresenter {
        /**
         * 开始直播
         * @param openOrWatch
         */
        void openLive(int openOrWatch);
        /**
         * 获取正在直播的信息
         */
        void updateLiveInfo();
    }
}
