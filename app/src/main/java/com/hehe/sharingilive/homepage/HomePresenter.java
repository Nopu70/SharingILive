package com.hehe.sharingilive.homepage;

import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.LiveBiz;
import com.hehe.sharingilive.model.RegisterBiz;
import com.hehe.sharingilive.model.entity.LiveList;
import com.hehe.sharingilive.model.entity.User;

import java.util.List;

/**
 * view调用此类，此类调用model
 * Created by tarena on 2017/7/11.
 */

public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View view;
    LiveBiz liveBiz;

    HomePresenter(HomeContract.View view, LiveBiz liveBiz){
        this.view = view;
        this.liveBiz = liveBiz;
    }

    @Override
    public void openLive(final int openOrWatch) {
        liveBiz.saveLiveMessage(new LiveBiz.SaveListListener() {
            @Override
            public void onLiveListSaveEnd(LiveList liveList) {
                view.onSaveDataEnd(liveList,openOrWatch);
            }
        });
    }

    @Override
    public void updateLiveInfo() {
        liveBiz.getLivingInfo(new LiveBiz.QueryLivingInfoListener() {
            @Override
            public void onLivingInfoQueryEnd(List<LiveList> liveLists) {
                view.onUpateDataEnd(liveLists);
            }
        });
    }

}
