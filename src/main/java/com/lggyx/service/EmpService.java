package com.lggyx.service;

import com.lggyx.pojo.Emp;
import com.lggyx.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface EmpService {

    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);

    void delete(String[] idArray);

    void add(Emp emp);

    Emp selectById(Integer id);
}
