package com.gelin.oa.mapper;

import com.gelin.oa.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    public Employee selectById(Long employeeId);
    public List<Employee> selectByParams(Map map);
}
