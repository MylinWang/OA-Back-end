package com.gelin.oa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gelin.oa.pojo.LeaveForm;
import com.gelin.oa.service.LeaveFormService;
import com.gelin.oa.utils.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/api/leave/*")
public class LeaveFormServlet extends HttpServlet {
    private LeaveFormService leaveFormService = new LeaveFormService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String uri = request.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        if (methodName.equals("create")) {
            this.create(request, response);
        } else if (methodName.equals("list")) {
            this.list(request, response);
        } else if (methodName.equals("audit")) {
            this.audit(request, response);
        }
    }


    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strEmployeeId = request.getParameter("eid");
        String formType = request.getParameter("formType");
        //从1970年到现在的毫秒数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String reason = request.getParameter("reason");
        LeaveForm form = new LeaveForm();
        form.setEmployeeId(Long.parseLong(strEmployeeId));
        form.setStartTime(new Date(Long.parseLong(startTime)));
        form.setEndTime(new Date(Long.parseLong(endTime)));
        form.setFormType(Integer.parseInt(formType));
        form.setReason(reason);
        form.setCreateTime(new Date());
        ResponseUtil resp = null;
        try {
            leaveFormService.createLeaveForm(form);
            resp = new ResponseUtil();
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtil(e.getClass().getSimpleName(), e.getMessage());
        }

        response.getWriter().println(resp.toJsonString());
    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        ResponseUtil resp = null;
        try {
            List<Map> process = leaveFormService.getLeaveFormList("process", Long.parseLong(eid));
            resp = new ResponseUtil().put("list", process);

        } catch (Exception e) {
            resp = new ResponseUtil(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }

    protected void audit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        String formId = request.getParameter("formId");
        String reason = request.getParameter("reason");
        String result = request.getParameter("result");
        ResponseUtil resp=null;
        try {
            leaveFormService.audit(Long.parseLong(formId), Long.parseLong(eid), result, reason);
            resp=new ResponseUtil();
        }catch (Exception e){
            resp=new ResponseUtil(e.getClass().getSimpleName(),e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }
}
