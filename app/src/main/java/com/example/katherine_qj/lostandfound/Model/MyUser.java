package com.example.katherine_qj.lostandfound.Model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Katherine-qj on 2016/8/8.
 */
public class MyUser extends BmobUser {
    private String username;

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    private String nick;
    private String  introduce;



    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String  introduce) {
        this.introduce = introduce;
    }
}
