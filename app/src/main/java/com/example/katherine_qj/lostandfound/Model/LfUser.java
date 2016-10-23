package com.example.katherine_qj.lostandfound.Model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Katherine-qj on 2016/8/8.
 */
public class LfUser extends BmobUser {
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
