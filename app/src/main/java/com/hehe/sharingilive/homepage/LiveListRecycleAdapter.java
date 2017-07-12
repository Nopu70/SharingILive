package com.hehe.sharingilive.homepage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hehe.sharingilive.R;
import com.hehe.sharingilive.model.entity.DemoLiveList;
import com.hehe.sharingilive.model.entity.LiveList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/7/12.
 */

public class LiveListRecycleAdapter extends RecyclerView.Adapter<LiveListRecycleAdapter.ViewHolder> {
    private Context mContext;
    private List<LiveList> mList;

    public LiveListRecycleAdapter(Context mContext) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList = DemoLiveList.getDemoLiveList();
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ll_recyclerview_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LiveList liveList = mList.get(position);
        holder.tvRoomUsername.setText(liveList.getUser().getUsername());
        holder.tvRoomId.setText(liveList.getRoomId());
        if (!TextUtils.isEmpty(liveList.getRoomDescription())) {
            holder.tvRoomDescription.setText(liveList.getRoomDescription());
        }
        Glide.with(mContext).load(liveList.getUser().getHeaderImg()).into(holder.ivRoomImg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRoomImg;
        TextView tvRoomId;
        TextView tvWatchNum;
        TextView tvRoomUsername;
        TextView tvRoomDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            ivRoomImg = itemView.findViewById(R.id.iv_live);
            tvRoomId = itemView.findViewById(R.id.tv_live_room_id);
            tvWatchNum = itemView.findViewById(R.id.tv_room_watch_num);
            tvRoomUsername = itemView.findViewById(R.id.tv_live_username);
            tvRoomDescription = itemView.findViewById(R.id.tv_live_description);
        }
    }

    public void addData(List<LiveList> liveLists) {
        mList.addAll(3,liveLists);
        notifyDataSetChanged();
    }
}
