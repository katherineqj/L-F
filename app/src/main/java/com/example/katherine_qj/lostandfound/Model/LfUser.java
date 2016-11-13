package com.example.katherine_qj.lostandfound.Model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Katherine-qj on 2016/8/8.
 */
public class LfUser extends BmobUser {
    private String nick;
    private String  introduce;
    private String sex;
    private String place;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

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
