package com.gelin.oa.service;

import com.gelin.oa.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService=new UserService();
    @Test
    public void checkLogin() {
        User user = userService.checkLogin("test1", "test");
        System.out.println(user);
    }
}