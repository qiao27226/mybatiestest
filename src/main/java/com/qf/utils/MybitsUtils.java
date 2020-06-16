package com.qf.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybitsUtils {
    //获得session工厂
    private static SqlSessionFactory factory;

    //创建ThreadLocal绑定当前线程中的SqlSession对象
    private static final ThreadLocal<SqlSession> SQL_SESSION_THREAD_LOCAL = new ThreadLocal<SqlSession>();
    static {
        //
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获得sqlsession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = SQL_SESSION_THREAD_LOCAL.get();
        if (sqlSession == null){
            sqlSession = factory.openSession();
            SQL_SESSION_THREAD_LOCAL.set(sqlSession);
        }
        return sqlSession;
    }


    //释放当前线程中的sqlsession
    public static void close(){
        getSqlSession().close();
        SQL_SESSION_THREAD_LOCAL.remove();
    }

    //提交事务，提交当前线程中sqlsession所管理的事务
    public static void commit(){
        getSqlSession().commit();
        close();
    }
    //获得接口实现类对象
    public static <T> T getMapper(Class<T> t){
        return getSqlSession().getMapper(t);
    }
}
