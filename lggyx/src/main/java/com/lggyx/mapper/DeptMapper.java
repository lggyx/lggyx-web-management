package com.lggyx.mapper;

import com.lggyx.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 29145
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2025-09-09 20:37:44
* @Entity com.lggyx.domain.Dept
*/
@Mapper
public interface DeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

}
