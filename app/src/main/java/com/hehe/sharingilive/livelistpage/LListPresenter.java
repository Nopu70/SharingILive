package com.hehe.sharingilive.livelistpage;

import com.hehe.sharingilive.livepage.LiveContract;
import com.hehe.sharingilive.model.BaseModel;

/**
 * Created by tarena on 2017/7/11.
 */

public class LListPresenter implements LListContract.Presenter {

    LListContract.View view;
    BaseModel model;

    LListPresenter(LListContract.View view, BaseModel model){
        this.view = view;
        this.model = model;
    }
}
