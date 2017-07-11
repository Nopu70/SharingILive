package com.hehe.sharingilive.regpage;

import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class RegPresenter implements RegContract.Presenter {

    RegContract.View view;
    BaseModel model;

    RegPresenter(RegContract.View view, BaseModel model){
        this.view = view;
        this.model = model;
    }
}
