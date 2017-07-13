package com.hehe.sharingilive.livepage;

import com.hehe.sharingilive.BasePresenter;
import com.hehe.sharingilive.BaseView;
import com.hehe.sharingilive.loginpage.LoginContract;
import com.hehe.sharingilive.model.entity.LiveList;

/**
 * Created by tarena on 2017/7/11.
 */

public class LiveContract {

    interface View extends BaseView<LiveContract.Presenter> {
        void onSaveDataEnd(LiveList liveList, int openOrWatch);
    }

    interface Presenter extends BasePresenter {
        /**
         * 关闭直播
         */
        void closeLive(LiveList liveList);
        /**
         * 开始直播
         * @param openOrWatch
         */
        void openLive(int openOrWatch);
    }
}
