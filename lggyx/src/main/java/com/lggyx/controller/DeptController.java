package com.lggyx.controller;

import com.lggyx.domain.Dept;
import com.lggyx.pojo.Result;
import com.lggyx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/getDept")
    public Result getDept(@RequestParam Long id) {
        Dept dept =deptService.getDept(id);
        Result result = dept == null ? Result.error("查询失败") : Result.success(dept);
        log.info("根据Id进行查询部门：{}", id);
        log.info("返回结果：{}",result);
        return result;
    }

}
