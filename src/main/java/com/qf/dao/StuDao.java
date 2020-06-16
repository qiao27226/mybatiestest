package com.qf.dao;

import com.qf.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StuDao {
    //获取所有学生的方法
    public List<Student> getAllStu();
    //获得指定编号的学生信息；
    public Student getStuById(@Param("id") int id);
    //模糊查询
    public List<Student> getStuByName(@Param("name")String name);

    //插入数据
    public int insertStuByall(Student stu);

    //删除学生信息

    public int delStuById(@Param("id")int id);

    //更改学生信息密码
    public int modifyPwd(@Param("id")int id, @Param("pwd")String pwd);

    //分页查询学生信息
    public List<Student> getStuByPage(Map<String,Object> map);
}
