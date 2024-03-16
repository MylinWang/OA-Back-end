package com.gelin.oa.service;

import com.gelin.oa.mapper.RbacMapper;
import com.gelin.oa.pojo.Node;

import java.util.List;

public class RbacService {

    private RbacMapper rbacMapper=new RbacMapper();


    public List<Node> selectNodeByUserId(Long UserId){
        List<Node> node = rbacMapper.selectNodeByUserId(UserId);
        return node;
    }

}
