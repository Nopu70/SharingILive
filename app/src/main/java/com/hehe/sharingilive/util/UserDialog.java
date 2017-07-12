package com.hehe.sharingilive.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by tarena on 2017/7/12.
 */

public class UserDialog {

    public static enum TYPE {
        USER, ADMIN
    }

    public UserDialog(TYPE type, Context context){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .create();
    }
}
