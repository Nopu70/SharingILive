package com.hehe.sharingilive.homepage;

import com.hehe.sharingilive.model.BaseModel;
import com.hehe.sharingilive.model.LiveBiz;
import com.hehe.sharingilive.model.RegisterBiz;
import com.hehe.sharingilive.model.entity.User;

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
    public void openLive() {
        
    }
}
