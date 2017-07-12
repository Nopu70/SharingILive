package com.hehe.sharingilive.model.entity;

import cn.bmob.v3.BmobUser;

/**
 * 用户实体类
 * Created by tarena on 2017/7/11.
 */

public class User extends BmobUser{
    /**
     * 头像路径
     */
    private String headerImg;

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }


}
