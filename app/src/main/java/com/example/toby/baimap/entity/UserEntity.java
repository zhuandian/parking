package com.example.toby.baimap.entity;

import cn.bmob.v3.BmobUser;


public class UserEntity extends BmobUser {
    private String nikeName;
    private String userInfo;

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
