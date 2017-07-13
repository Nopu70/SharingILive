package com.hehe.sharingilive.livepage;

import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.LiveBiz;
import com.hehe.sharingilive.model.entity.LiveList;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class LivePresenter implements LiveContract.Presenter {

    LiveContract.View view;
    LiveBiz model;


    LivePresenter(LiveContract.View view, LiveBiz model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void closeLive(LiveList liveList) {
        model.closeLive(liveList);
    }

    @Override
    public void openLive(int openOrWatch) {
        model.saveLiveMessage(new LiveBiz.SaveListListener() {
            @Override
            public void onLiveListSaveEnd(LiveList liveList) {
                //直播状态信息更新
                //不通知UI更新
            }
        });
    }
}
