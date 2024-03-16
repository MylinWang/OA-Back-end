package com.gelin.oa.service;

import com.gelin.oa.mapper.UserMapper;
import com.gelin.oa.pojo.User;
import com.gelin.oa.service.exception.LoginException;
import com.gelin.oa.utils.Md5Utils;

public class UserService {
    private UserMapper userMapper=new UserMapper();


    public User checkLogin(String username,String password){
        User user = userMapper.findByUsername(username);
        if(user==null){
            throw new LoginException("用户名不正确");
        }

        String md = Md5Utils.md5Digest(password, user.getSalt());
        if (!md.equals(user.getPassword())){
            throw new LoginException("密码不正确");
        }
        return user;
    }


}
