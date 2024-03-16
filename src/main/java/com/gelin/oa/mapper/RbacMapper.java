package com.gelin.oa.mapper;

import com.gelin.oa.pojo.Node;
import com.gelin.oa.utils.MybatisUtil;

import java.util.List;

public class RbacMapper {
    public List<Node> selectNodeByUserId(Long userId){
        List list = (List) MybatisUtil.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId", userId));
        return list;
    }
}
