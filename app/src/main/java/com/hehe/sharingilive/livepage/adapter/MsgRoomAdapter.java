package com.hehe.sharingilive.livepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hehe.sharingilive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/7/12.
 */

public class MsgRoomAdapter extends RecyclerView.Adapter<MsgRoomAdapter.ViewHolder> {



    List<String> list;
    Context context;

    public void setList(String msg) {
        list.add(msg);
    }

    public MsgRoomAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @Override
    public MsgRoomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_msg_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MsgRoomAdapter.ViewHolder holder, int position) {
        String string = list.get(position);
        final String[] split_str = string.split("%");

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(split_str[0]);
        int l = ssb.length();
        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, split_str[0]+"被点击", Toast.LENGTH_SHORT).show();
            }
        };
        ssb.setSpan(cs, 0, l-1, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ssb.append(split_str[1]);

        holder.textView.setText(ssb);
        holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.msg_i);
        }
    }
}
