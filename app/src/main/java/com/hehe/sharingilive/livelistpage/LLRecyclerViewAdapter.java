package com.hehe.sharingilive.livelistpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hehe.sharingilive.R;

/**
 * Created by tarena on 2017/7/11.
 */

public class LLRecyclerViewAdapter extends RecyclerView.Adapter<LLRecyclerViewAdapter.ViewHolder> {
    //ArrayList<> list =new ArrayList()；
    Context context;
    public LLRecyclerViewAdapter(Context context){
       this.context= context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder;
        View view = LayoutInflater.from(context).inflate(R.layout.ll_recyclerview_item,null);
        holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView anchor_img;
        private TextView anchor;
        private TextView people;

        public ViewHolder(View itemView) {
            super(itemView);
            anchor_img=itemView.findViewById(R.id.anchor_img);
            anchor=itemView.findViewById(R.id.anchor);
            people=itemView.findViewById(R.id.people);
        }
    }
}
