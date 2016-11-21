package com.zyk.domain;

import java.io.Serializable;

/**
 * @author zyk
 * @create 2016-10-22 17:11
 */
public class User implements Serializable{

    private static final long serialVersionUID = -5128177849717685803L;
    private String studentSn;
    private String studentName;

    public String getStudentSn() {
        return studentSn;
    }

    public void setStudentSn(String studentSn) {
        this.studentSn = studentSn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public User(){}

    public User(String studentSn, String studentName){
        this.studentSn = studentSn;
        this.studentName = studentName;
    }
}