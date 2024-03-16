package com.gelin.oa.service;

import com.gelin.oa.mapper.EmployeeMapper;
import com.gelin.oa.pojo.Employee;
import com.gelin.oa.utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {


    public Employee selectById(Long employeeId){
        Employee result = (Employee) MybatisUtil.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            return employee;
        });
        return result;
    }

    public Employee selectLeader(Long employeeId){
        Employee employee1 = (Employee) MybatisUtil.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            Map map = new HashMap();
            Employee leader = null;
            if (employee.getLevel() < 7) {
                map.put("level", 7);
                map.put("departmentId", employee.getDepartmentId());
                List<Employee> employees = mapper.selectByParams(map);
                leader = employees.get(0);
            } else if (employee.getLevel() == 7) {
                map.put("level", 8);
                List<Employee> employees = mapper.selectByParams(map);
                leader = employees.get(0);
            } else if (employee.getLevel() == 8) {
                leader = employee;
            }
            return leader;
        });
        return employee1;
    }


}
