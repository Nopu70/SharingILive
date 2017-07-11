package com.hehe.sharingilive.homepage;

import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View view;
    BaseModel model;

    HomePresenter(HomeContract.View view, BaseModel model){
        this.view = view;
        this.model = model;
    }
}
