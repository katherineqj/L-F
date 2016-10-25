package com.example.katherine_qj.lostandfound.Model;

import cn.bmob.v3.BmobObject;

/**
 * Created by Katherine-qj on 2016/9/8.
 */
public class Lost extends BmobObject {
    private String stu;
    private String lost_title;
    private String lost_time_place;
    private String lost_mailbox;
    private String lost_phone;
    private String lost_describe;
    private String userid;
    private String type;

    public String getLost_mailbox() {
        return lost_mailbox;
    }

    public void setLost_mailbox(String lost_mailbox) {
        this.lost_mailbox = lost_mailbox;
    }

    public String getLost_phone() {

        return lost_phone;
    }

    public void setLost_phone(String lost_phone) {
        this.lost_phone = lost_phone;
    }

    public String getLost_time_place() {
        return lost_time_place;
    }

    public void setLost_time_place(String lost_time_place) {
        this.lost_time_place= lost_time_place;
    }

    public String getLost_title() {
        return lost_title;
    }

    public void setLost_title(String lost_title) {
        this.lost_title = lost_title;
    }


    public String getLost_describe() {
        return lost_describe;
    }

    public void setLost_describe(String lost_describe) {
        this.lost_describe = lost_describe;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
