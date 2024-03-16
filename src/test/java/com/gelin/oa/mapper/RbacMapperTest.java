package com.gelin.oa.mapper;

import com.gelin.oa.pojo.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RbacMapperTest {
    private RbacMapper rbacMapper=new RbacMapper();
    @Test
    public void selectNodeByUserId() {
        List<Node> node = rbacMapper.selectNodeByUserId(3l);
        System.out.println(node);
    }
}