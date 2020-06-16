package com.qf.test;

import com.qf.dao.IUserDao;
import com.qf.dao.StuDao;
import com.qf.entity.Student;
import com.qf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class testDao {
    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        //5.调用接口中的方法
//        List<Student> allStu = stuDao.getAllStu();
//        for (Student student : allStu) {
//            System.out.println(student);
//        }
        StuDao stu=sqlSession.getMapper(StuDao.class);
        System.out.println(stu.getStuById(1));

    }

    public SqlSession getSqlSession() throws IOException {
        //1.获得mybatis配置文件的流对象
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //2.构建SqlSession链接对象的工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        //3.通过工厂获得链接对象
        return factory.openSession(true);
    }

    @Test
    public void test2()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        StuDao studao=sqlSession.getMapper(StuDao.class);
        Student student = new Student(null,"123", "2005-06-09",12,"555","222",null);
        int result = studao.insertStuByall(student);
        sqlSession.commit();
        System.out.println(student);
    }
    @Test
    public void test3()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        int result = stuDao.delStuById(1);
        sqlSession.commit();
        System.out.println(result);

    }
//实现模糊查询
    @Test
    public void test4()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        List<Student> students= stuDao.getStuByName("二");
        for (Student student : students) {
            System.out.println(student);
        }

    }
    //实现更改学生信息
    @Test
    public void test5()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        int result = stuDao.modifyPwd(3,"123456");
        sqlSession.commit();
        System.out.println(result);

    }
    //    实现分页查询
    @Test
    public void test6()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        StuDao stuDao = sqlSession.getMapper(StuDao.class);
        Map<String ,Object> map = new HashMap<>();
        map.put("begin" , 0);
        map.put("end", 3);
        List<Student> result = stuDao.getStuByPage(map);
        System.out.println(result.toString());
    }
    //添加用户信息
    @Test
    public void test7()throws Exception {
        //1.获得mybatis配置文件的流对象
        SqlSession sqlSession = getSqlSession();
        //4.通过链接对象获得接口实现类对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User(null,"qxm");
        int result = userDao.addUser(user);
        System.out.println(user);
    }
}
