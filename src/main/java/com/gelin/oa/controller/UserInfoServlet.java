package com.gelin.oa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gelin.oa.pojo.Department;
import com.gelin.oa.pojo.Employee;
import com.gelin.oa.pojo.Node;
import com.gelin.oa.service.DepartmentService;
import com.gelin.oa.service.EmployeeService;
import com.gelin.oa.service.RbacService;
import com.gelin.oa.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/api/user_info")
public class UserInfoServlet extends HttpServlet {
    private RbacService rbacService=new RbacService();
    private EmployeeService employeeService=new EmployeeService();
    private DepartmentService departmentService=new DepartmentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String uid = request.getParameter("uid");
        String eid = request.getParameter("eid");
        List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Map> list=new ArrayList<>();
        Map map=null;
        for (Node node: nodes) {
            if (node.getNodeType()==1){
                map=new LinkedHashMap();
                map.put("node",node);
                map.put("children",new ArrayList());
                list.add(map);
            }else if(node.getNodeType()==2){
                List children = (List) map.get("children");
                children.add(node);
            }
        }
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        Department department = departmentService.selectById(employee.getDepartmentId());
        String nodeList = new ResponseUtil().put("nodeList", list).put("employee",employee).put("department",department).toJsonString();
        response.getWriter().println(nodeList);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);


    }
}
