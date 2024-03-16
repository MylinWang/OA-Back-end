package com.gelin.oa.mapper;

import com.gelin.oa.pojo.Employee;
import com.gelin.oa.utils.MybatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeMapperTest {
    @Test
    public void selectById() {
        Employee result = (Employee) MybatisUtil.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(1l);
            return employee;
        });

        System.out.println(result.getName());

    }
}