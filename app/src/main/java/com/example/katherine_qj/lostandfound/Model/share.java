package com.example.katherine_qj.lostandfound.Model;

import java.util.Objects;

import cn.bmob.v3.BmobObject;

/**
 * Created by Katherine-qj on 2016/11/6.
 */
public class share extends BmobObject{
    private String rVstu;
    private String rVuserid;
    private String rVtype;


    private String rVget_title;
    private String rVget_time_place;
    private String rVget_question;
    private String rVget_answer;
    private String rVget_contact;


    private String rVlost_title;
    private String rVlost_time_place;
    private String rVlost_mailbox;
    private String rVlost_phone;

    public String getrVlost_describe() {
        return rVlost_describe;
    }

    public void setrVlost_describe(String rVlost_describe) {
        this.rVlost_describe = rVlost_describe;
    }

    private String rVlost_describe;

    public String getrVstu() {
        return rVstu;
    }

    public void setrVstu(String rVstu) {
        this.rVstu = rVstu;
    }

    public String getrVuserid() {
        return rVuserid;
    }

    public void setrVuserid(String rVuserid) {
        this.rVuserid = rVuserid;
    }

    public String getrVtype() {
        return rVtype;
    }

    public void setrVtype(String rVtype) {
        this.rVtype = rVtype;
    }

    public String getrVget_title() {
        return rVget_title;
    }

    public void setrVget_title(String rVget_title) {
        this.rVget_title = rVget_title;
    }

    public String getrVget_time_place() {
        return rVget_time_place;
    }

    public void setrVget_time_place(String rVget_time_place) {
        this.rVget_time_place = rVget_time_place;
    }

    public String getrVget_question() {
        return rVget_question;
    }

    public void setrVget_question(String rVget_question) {
        this.rVget_question = rVget_question;
    }

    public String getrVget_answer() {
        return rVget_answer;
    }

    public void setrVget_answer(String rVget_answer) {
        this.rVget_answer = rVget_answer;
    }

    public String getrVget_contact() {
        return rVget_contact;
    }

    public void setrVget_contact(String rVget_contact) {
        this.rVget_contact = rVget_contact;
    }

    public String getrVlost_title() {
        return rVlost_title;
    }

    public void setrVlost_title(String rVlost_title) {
        this.rVlost_title = rVlost_title;
    }

    public String getrVlost_time_place() {
        return rVlost_time_place;
    }

    public void setrVlost_time_place(String rVlost_time_place) {
        this.rVlost_time_place = rVlost_time_place;
    }

    public String getrVlost_mailbox() {
        return rVlost_mailbox;
    }

    public void setrVlost_mailbox(String rVlost_mailbox) {
        this.rVlost_mailbox = rVlost_mailbox;
    }

    public String getrVlost_phone() {
        return rVlost_phone;
    }

    public void setrVlost_phone(String rVlost_phone) {
        this.rVlost_phone = rVlost_phone;
    }
}
