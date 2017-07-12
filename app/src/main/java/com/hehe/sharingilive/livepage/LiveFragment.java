package com.hehe.sharingilive.livepage;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hehe.sharingilive.R;
import com.ucloud.ulive.UEasyStreaming;
import com.ucloud.ulive.UStreamingProfile;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by tarena on 2017/7/11.
 */

public class LiveFragment extends Fragment implements LiveContract.View {

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

    TextureView textureView;
    CircleImageView live_h;
    TextView live_w;
    RecyclerView msg_room;
    EditText text_input;
    ImageView msg_btn;
    String mRtmpAddress;
    UEasyStreaming streaming;

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
        live_h = view.findViewById(R.id.live_h);
        live_w = view.findViewById(R.id.live_w);
        msg_room = view.findViewById(R.id.msg_room);
        text_input = view.findViewById(R.id.text_input);
        msg_btn = view.findViewById(R.id.msg_btn);

        textureView.setKeepScreenOn(true);
        mRtmpAddress = "rtmp://publish3.cdn.ucloud.com.cn/ucloud/demo";

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

        return view;
    }
}
