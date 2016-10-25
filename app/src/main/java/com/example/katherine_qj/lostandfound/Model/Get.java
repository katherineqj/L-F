package com.example.katherine_qj.lostandfound.Model;

import cn.bmob.v3.BmobObject;

/**
 * Created by Katherine-qj on 2016/10/25.
 */
public class Get extends BmobObject {
    private String stu;
    private String get_title;
    private String get_time_place;
    private String get_question;
    private String get_answer;
    private String get_contact;
    private String type;

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getGet_title() {
        return get_title;
    }

    public void setGet_title(String get_title) {
        this.get_title = get_title;
    }

    public String getGet_time_place() {
        return get_time_place;
    }

    public void setGet_time_place(String get_time_place) {
        this.get_time_place = get_time_place;
    }

    public String getGet_question() {
        return get_question;
    }

    public void setGet_question(String get_question) {
        this.get_question = get_question;
    }

    public String getGet_answer() {
        return get_answer;
    }

    public void setGet_answer(String get_answer) {
        this.get_answer = get_answer;
    }

    public String getGet_contact() {
        return get_contact;
    }

    public void setGet_contact(String get_contact) {
        this.get_contact = get_contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
