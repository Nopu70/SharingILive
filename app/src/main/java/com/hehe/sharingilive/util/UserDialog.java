package com.hehe.sharingilive.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import com.hehe.sharingilive.R;

/**
 * Created by tarena on 2017/7/12.
 */

public class UserDialog {

    AlertDialog dialog;

    public static enum TYPE {
        USER, ADMIN
    }

    public UserDialog(TYPE type, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = View.inflate(context, R.layout.user_dialog_view, null);
        builder.setView(view);
        ImageView cls_btn = view.findViewById(R.id.cls_btn);
        cls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
    }

    public void showDialog(){
        dialog.show();
    }
}
