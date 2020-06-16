package com.qf.entity;

import java.util.List;

public class Grade {
    private Integer gId;
    private String gNmae;

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gId=" + gId +
                ", gNmae='" + gNmae + '\'' +
                ", students=" + students +
                '}';
    }

    public Grade(Integer gId, String gNmae) {
        this.gId = gId;
        this.gNmae = gNmae;
    }

    public Grade(Integer gId, String gNmae, List<Student> students) {
        this.gId = gId;
        this.gNmae = gNmae;
        this.students = students;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgNmae() {
        return gNmae;
    }

    public void setgNmae(String gNmae) {
        this.gNmae = gNmae;
    }
}
