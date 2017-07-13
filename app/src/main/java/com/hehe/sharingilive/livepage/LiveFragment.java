package com.hehe.sharingilive.livepage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hehe.sharingilive.R;
import com.hehe.sharingilive.livepage.adapter.MsgRoomAdapter;
import com.hehe.sharingilive.model.entity.LiveList;
import com.ucloud.ulive.UEasyStreaming;
import com.ucloud.ulive.UStreamingProfile;
import com.ucloud.uvod.UMediaProfile;
import com.ucloud.uvod.widget.UVideoView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 *
 * Created by tarena on 2017/7/11.
 */

public class LiveFragment extends Fragment implements LiveContract.View {
    /**
     * 主播的信息
     */
    private LiveList liveList;

    public static LiveFragment newInstance() {
        Bundle args = new Bundle();
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LiveContract.Presenter presenter;
    @Override
    public void setPresent(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    CircleImageView live_h;
    TextView live_w;
    RecyclerView msg_room;
    TextureView textureView;
    UEasyStreaming streaming;
    String mRtmpAddress;
    ImageView msg_btn, play_pause, sxt;
    RecyclerView recyclerView;
    UVideoView uVideoView;
    EditText msg_input;
    MsgRoomAdapter adapter;

    int type;
    String roomID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getActivity().getIntent();
        type = intent.getIntExtra("type", 0);
        liveList = (LiveList) intent.getSerializableExtra("liveList");
        roomID = intent.getStringExtra(liveList.getRoomId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.live_layout, container, false);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        textureView = view.findViewById(R.id.texture);
        uVideoView = view.findViewById(R.id.uVideo);
        live_h = view.findViewById(R.id.live_h);
        live_w = view.findViewById(R.id.live_w);
        msg_room = view.findViewById(R.id.msg_room);
        msg_input = view.findViewById(R.id.msg_input);
        msg_btn = view.findViewById(R.id.msg_btn);
        play_pause = view.findViewById(R.id.play_pause);
        sxt = view.findViewById(R.id.sxt);
        recyclerView = view.findViewById(R.id.msg_room);

        adapter = new MsgRoomAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        textureView.setKeepScreenOn(true);
        mRtmpAddress = "rtmp://publish3.cdn.ucloud.com.cn/ucloud/"+roomID;

        msg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = msg_input.getText().toString();
                InputMethodManager imm = (InputMethodManager) getActivity()
                        .getSystemService(getActivity().INPUT_METHOD_SERVICE);
                msg_input.setText("");
                msg_input.clearFocus();
                if (str.isEmpty()){
                    return;
                }
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                StringBuilder ssb = new StringBuilder();
                ssb.append("呵呵:");
                ssb.append("%");
                ssb.append(str);
                adapter.setList(ssb.toString());
                adapter.notifyDataSetChanged();

            }
        });

        if (type==0){
            textureView.setVisibility(View.VISIBLE);
            play_pause.setVisibility(View.VISIBLE);
            sxt.setVisibility(View.VISIBLE);
            textureView.setKeepScreenOn(true);
            streaming = UEasyStreaming.Factory.newInstance();
            UStreamingProfile mStreamingProfile = new UStreamingProfile.Builder().build(mRtmpAddress);
            streaming.prepare(mStreamingProfile);
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
                @Override
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
                    streaming.startPreview(surfaceTexture, i, i1);
                }

                @Override
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

                }

                @Override
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    return false;
                }

                @Override
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

                }
            });
            //暂停
            play_pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (streaming.isRecording()){
                        play_pause.setBackgroundResource(R.drawable.play_bg);
                        streaming.stopRecording();
                        //开始直播，更新网路状态
                        presenter.openLive(0);
                    }else {
                        play_pause.setBackgroundResource(R.drawable.pause_bg);
                        streaming.startRecording();
                        //关闭直播，更新网络状态
                        presenter.closeLive(liveList);
                    }
                }
            });
            sxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    streaming.switchCamera();
                }
            });
        }else {
            uVideoView.setVisibility(View.VISIBLE);
            UMediaProfile profile = new UMediaProfile();// 是否自动播放：0 - 需调用start开始播放；1 - 自动播放
            profile.setInteger(UMediaProfile.KEY_START_ON_PREPARED, 1);// 播放类型：0 - 点播；1 - 直播
            profile.setInteger(UMediaProfile.KEY_LIVE_STREAMING, 1);// 解码类型：0 - 软解；1 - 硬解
            profile.setInteger(UMediaProfile.KEY_MEDIACODEC, 0);// 是否允许后台播放：0 - 不允许；1 - 允许
            profile.setInteger(UMediaProfile.KEY_ENABLE_BACKGROUND_PLAY, 0);
            uVideoView.setMediaPorfile(profile);// 设置视频比例，默认VIDEO_RATIO_FIT_PARENT
            uVideoView.applyAspectRatio(UVideoView.VIDEO_RATIO_FIT_PARENT);
            uVideoView.setVideoPath(mRtmpAddress);
            //是否开始看直播
            uVideoView.start();
        }
        return view;
    }

    @Override
    public void onSaveDataEnd(LiveList liveList, int openOrWatch) {
    }
    @Override
    public void onPause() {
        super.onPause();
        streaming.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        streaming.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        streaming.onDestroy();
    }
}
