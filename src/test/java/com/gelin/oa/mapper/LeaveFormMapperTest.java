package com.gelin.oa.mapper;

import com.gelin.oa.pojo.LeaveForm;
import com.gelin.oa.utils.MybatisUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LeaveFormMapperTest {

    @Test
    public void insert() {
        MybatisUtil.executeUpdate(sqlSession -> {
            LeaveFormMapper mapper = sqlSession.getMapper(LeaveFormMapper.class);
            LeaveForm leaveForm=new LeaveForm();
            leaveForm.setEmployeeId(4l);
            leaveForm.setFormType(1);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime=null;
            Date endTime=null;
            try{
                startTime=sdf.parse("2020-02-25 08:08:02");
                endTime=sdf.parse("2020-04-01 08:08:08");
            }catch (ParseException e){
                e.printStackTrace();
            }

            leaveForm.setStartTime(startTime);
            leaveForm.setEndTime(endTime);
            leaveForm.setReason("回家");
            leaveForm.setCreateTime(new Date());
            leaveForm.setState("processing");
            mapper.insert(leaveForm);
            return  null;
        });
    }

    @Test
    public void selectByParams() {
        MybatisUtil.executeQuery(sqlSession -> {
            LeaveFormMapper mapper = sqlSession.getMapper(LeaveFormMapper.class);
            List<Map> process = mapper.selectByParams("process", 1l);
            System.out.println(process);
            return null;
        });


    }
}