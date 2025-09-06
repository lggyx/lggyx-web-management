package com.lggyx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lggyx.mapper.EmpMapper;
import com.lggyx.pojo.Emp;
import com.lggyx.pojo.PageBean;
import com.lggyx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), Collections.singletonList(p.getResult()));
        return pageBean;
    }

    @Override
    public void delete(String[] ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setEntrydate(LocalDate.now());
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        //调用dao层功能：登录
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);

        //返回查询结果给Controller
        return loginEmp;
    }
}
