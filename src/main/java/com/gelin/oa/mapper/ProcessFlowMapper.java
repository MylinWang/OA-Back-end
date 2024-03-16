package com.gelin.oa.mapper;

import com.gelin.oa.pojo.ProcessFlow;

import java.util.List;

public interface ProcessFlowMapper {
    public void insert(ProcessFlow processFlow);
    public void update(ProcessFlow processFlow);
    public List<ProcessFlow> selectByFormId(Long formId);
}
