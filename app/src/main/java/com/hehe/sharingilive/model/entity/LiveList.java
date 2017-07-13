package com.hehe.sharingilive.model.entity;

import cn.bmob.v3.BmobObject;
/**
 * 直播列表
 * Created by tarena on 2017/7/11.
 */

public class LiveList extends BmobObject{
    /**
     * 直播用户信息
     */
    private User user;
    /**
     * 直播房间号
     */
    private String roomId;
    /**
     * 房间描述
     */
    private String roomDescription;
    /**
     * 是否在直播的状态标识
     */
    private boolean isOpenLive;

    private String coverImgPath;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public boolean isOpenLive() {
        return isOpenLive;
    }

    public void setOpenLive(boolean openLive) {
        isOpenLive = openLive;
    }

    public String getCoverImgPath() {
        return coverImgPath;
    }

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }
}
