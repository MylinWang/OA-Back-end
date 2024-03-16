package com.gelin.oa.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.function.Function;

public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory=null;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object executeQuery(Function<SqlSession,Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Object result = func.apply(sqlSession);
            return result;
        }finally {
            sqlSession.close();
        }
    }

    public static Object executeUpdate(Function<SqlSession,Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try{
            Object result = func.apply(sqlSession);
            sqlSession.commit();
            return result;
        }catch (Exception e){
            sqlSession.rollback();
            throw e;
        }finally {
            sqlSession.close();
        }
    }

}
