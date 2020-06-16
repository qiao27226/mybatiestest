package com.qf.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student {
    private Integer stuId;
    private String stuName;
    private Date stuBir;
    private int stuAge;
    private String stuHobby;
    private String psw;

    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public Student(Integer stuId, String stuName, String stuBir, int stuAge, String stuHobby, String psw, Grade grade) throws ParseException {
        this.stuId = stuId;
        this.stuName = stuName;
        java.util.Date time = new SimpleDateFormat("yyyy-MM-dd").parse(stuBir);
        Date now = new Date(time.getTime());
        this.stuBir = now;
        this.stuAge = stuAge;
        this.stuHobby = stuHobby;
        this.psw = psw;
        this.grade = grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuBir=" + stuBir +
                ", stuAge=" + stuAge +
                ", stuHobby='" + stuHobby + '\'' +
                ", psw='" + psw + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student() {
    }



    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getStuBir() {
        return stuBir;
    }

    public void setStuBir(Date stuBir) {
        this.stuBir = stuBir;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuHobby() {
        return stuHobby;
    }

    public void setStuHobby(String stuHobby) {
        this.stuHobby = stuHobby;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


}
