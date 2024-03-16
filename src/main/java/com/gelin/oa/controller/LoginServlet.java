package com.gelin.oa.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gelin.oa.pojo.User;
import com.gelin.oa.service.UserService;
import com.gelin.oa.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseUtil resp =null;
        try{
            User user = userService.checkLogin(username, password);
            user.setPassword(null);
            user.setSalt(null);
           resp = new ResponseUtil().put("user", user);
        }catch (Exception e){
            resp=new ResponseUtil(e.getClass().getSimpleName(),e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());


    }
}
