package com.lggyx.mapper;

import com.lggyx.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    List<Emp> list(@Param("name") String name,@Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    void delete(@Param("ids") String[] ids);

    void add(Emp emp);

    Emp selectById(Integer id);
}
