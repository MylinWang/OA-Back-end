package com.gelin.oa.mapper;

import com.gelin.oa.pojo.Notice;
import com.gelin.oa.utils.MybatisUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoticeMapperTest {

    @Test
    public void insert() {
        MybatisUtil.executeUpdate(sqlSession -> {
            NoticeMapper mapper = sqlSession.getMapper(NoticeMapper.class);
            mapper.insert(new Notice(29l,"测试"));
            return null;
        });
    }
}