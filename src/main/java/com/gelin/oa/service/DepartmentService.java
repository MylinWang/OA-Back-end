package com.gelin.oa.service;

import com.gelin.oa.mapper.DepartmentMapper;
import com.gelin.oa.pojo.Department;
import com.gelin.oa.utils.MybatisUtil;

public class DepartmentService {

    public Department selectById(Long departmentId){
        Department department = (Department) MybatisUtil.executeQuery(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
        return department;
    }


}
