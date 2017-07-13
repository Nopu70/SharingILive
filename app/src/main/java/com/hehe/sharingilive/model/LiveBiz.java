package com.hehe.sharingilive.model;

import android.text.TextUtils;
import android.widget.Toast;

import com.hehe.sharingilive.MyApplication;
import com.hehe.sharingilive.model.entity.LiveList;
import com.hehe.sharingilive.model.entity.User;

import java.util.List;
import java.util.Random;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 直播逻辑
 * Created by tarena on 2017/7/12.
 */

public class LiveBiz {
    /**
     * 开启直播的业务处理
     *
     * @param saveListListener
     */
    public void saveLiveMessage(final SaveListListener saveListListener) {
        //保存直播信息到Bmob
        User user = BmobUser.getCurrentUser(User.class);
        if (user != null) {
            //从网络获取最新的用户信息
            BmobQuery<User> query = new BmobQuery<>();
            query.getObject(user.getObjectId(), new QueryListener<User>() {
                @Override
                public void done(User user, BmobException e) {
                    if (e == null) {
                        setLiveInfo(user, saveListListener);
                    } else {
                        //查询最新用户信息失败
                    }
                }
            });
        } else {
            //提示用户登录
            Toast.makeText(MyApplication.context, "请您登录账号开启直播", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 设置直播信息
     *
     * @param user
     * @param saveListListener
     */
    private void setLiveInfo(User user, final SaveListListener saveListListener) {
        if (TextUtils.isEmpty(user.getLiveListId())) {
            saveLiveList(user, saveListListener);
        } else {
            //开启过直播，从LiveList获取直播信息，更新直播状态
            BmobQuery<LiveList> query = new BmobQuery<>();
            query.getObject(user.getLiveListId(), new QueryListener<LiveList>() {
                @Override
                public void done(LiveList liveList, BmobException e) {
                    if (e == null) {
                        //获取直播信息成功,更新直播状态
                        updateLiveState(liveList, true, saveListListener);
                    } else {
                        //获取直播信息失败
                    }
                }
            });
        }
    }

    /**
     * 保存直播信息到LiveList
     *
     * @param user
     * @param saveListListener
     */
    private void saveLiveList(User user, final SaveListListener saveListListener) {
        final LiveList liveList = new LiveList();
        //没有开启过直播，保存直播信息到LiveList
        liveList.setUser(user);
        liveList.setOpenLive(true);
        liveList.setCoverImgPath("http://imgtu.5011.net/uploads/content/20161009/9945911475981985.jpg");
        liveList.setRoomDescription("赞赞赞的直播");
        Random random = new Random();
        int roomID = random.nextInt(10000);
        liveList.setRoomId(String.valueOf(roomID));
        liveList.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    //直播信息保存成功，更新用户与直播列表的关联信息
                    updataUser(s);
                    saveListListener.onLiveListSaveEnd(liveList);
                } else {
                    //直播信息保存失败
                }
            }
        });
    }

    /**
     * 更新开启直播前的状态信息
     */
    public void updateLiveState(final LiveList liveliset, final boolean isLive, final SaveListListener saveListListener) {
        liveliset.setOpenLive(isLive);
        liveliset.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null&&isLive) {
                    //直播状态更新完毕，开始直播
                    saveListListener.onLiveListSaveEnd(liveliset);
                } else {
                    //直播状态更新失败
                }
            }
        });
    }
    /**
     * 更新用户与直播列表的关联信息
     *
     * @param s 用户在直播列表的objectID
     */
    private void updataUser(String s) {
        User newUser = new User();
        newUser.setLiveListId(s);
        User user = BmobUser.getCurrentUser(User.class);
        newUser.update(user.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {

            }
        });
    }

    public interface SaveListListener {
        void onLiveListSaveEnd(LiveList liveList);

    }
    public interface QueryLivingInfoListener{
        void onLivingInfoQueryEnd(List<LiveList> liveLists);
    }

    /**
     * 查询正在直播的列表信息
     */
    public void getLivingInfo(final QueryLivingInfoListener queryLivingInfoListener) {
        BmobQuery<LiveList> query = new BmobQuery<>();
        query.addWhereEqualTo("isOpenLive", true);
        query.findObjects(new FindListener<LiveList>() {
            @Override
            public void done(List<LiveList> list, BmobException e) {
                if (e==null){
                    //查询成功
                    queryLivingInfoListener.onLivingInfoQueryEnd(list);
                }else {
                    //查询失败
                }
            }
        });
    }

    /**
     * 关闭直播
     */
    public void closeLive(LiveList liveList) {
        updateLiveState(liveList,false,null);
    }
}
