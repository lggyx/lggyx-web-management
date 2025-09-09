package com.lggyx.service.impl;

import com.lggyx.domain.Dept;
import com.lggyx.mapper.DeptMapper;
import com.lggyx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept getDept(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }
}
