package com.qf.test;

import com.qf.dao.GradeDao;
import com.qf.dao.StuDao;
import com.qf.entity.Grade;
import com.qf.entity.Student;
import com.qf.utils.MybitsUtils;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void test11(){
        Student stu = MybitsUtils.getSqlSession().getMapper(StuDao.class).getStuById(2);
        System.out.println(stu);
    }

    @Test
    public void test12(){
        List<Student> stu = MybitsUtils.getSqlSession().getMapper(StuDao.class).getAllStu();
        System.out.println(stu.toString());
    }
    @Test
    public void test13(){
        List<Grade> stu = MybitsUtils.getSqlSession().getMapper(GradeDao.class).getAllGrade();
        System.out.println(stu.toString());
    }
}
