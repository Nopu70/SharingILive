package com.hehe.sharingilive.regpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by tarena on 2017/7/11.
 */

public class RegFragment extends Fragment implements RegContract.View {

    public static RegFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RegFragment fragment = new RegFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public void setPresent(RegContract.Presenter presenter) {
        
    }
}
