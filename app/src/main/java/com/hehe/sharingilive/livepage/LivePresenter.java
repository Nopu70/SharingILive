package com.hehe.sharingilive.livepage;

import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class LivePresenter implements LiveContract.Presenter {

    LiveContract.View view;
    BaseModel model;


    LivePresenter(LiveContract.View view, BaseModel model){
        this.view = view;
        this.model = model;
    }
}
