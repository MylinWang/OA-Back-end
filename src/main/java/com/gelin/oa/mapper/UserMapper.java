package com.gelin.oa.mapper;

import com.gelin.oa.pojo.User;
import com.gelin.oa.utils.MybatisUtil;

public class UserMapper {

    public User findByUsername(String username){
        User user = (User) MybatisUtil.executeQuery(sqlSession -> sqlSession.selectOne("UserMapper.selectOne", username));
        return user;
    }

}
