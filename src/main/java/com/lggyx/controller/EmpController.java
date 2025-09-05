package com.lggyx.controller;

import com.lggyx.pojo.Emp;
import com.lggyx.pojo.PageBean;
import com.lggyx.pojo.Result;
import com.lggyx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids){
        log.info("批量删除,参数:{}",ids);
        //将字符串转换成数组
        String[] idArray = ids.split(",");
        //调用service进行批量删除
        empService.delete(idArray);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("添加员工");
        empService.add(emp);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("根据ID查询员工");
        return Result.success(empService.selectById(id));
    }
}
