package com.myjava.bean;

import java.util.Date;

/**
 * @Author: wufan
 * @Date: 2019/2/25 10:24
 * @Version 1.0
 */
/*
*
* 学生对象封装bean*/
public class Student {
    private int sid;
    public Student(){}
    public Student(String sname, String gender, String phone, String hobby, String info, Date date) {
        setSname(sname);
        setGender(gender);
        setPhone(phone);
        setHobby(hobby);
        setInfo(info);
        setBirthday(date);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private String sname;
    private String gender;
    private String phone;
    private String hobby;
    private String info;
    private Date birthday;

}
