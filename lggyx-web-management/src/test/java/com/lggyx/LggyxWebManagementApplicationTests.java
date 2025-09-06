package com.lggyx;

import com.lggyx.controller.DeptController;
import com.lggyx.mapper.EmpMapper;
import com.lggyx.pojo.Dept;
import com.lggyx.pojo.Emp;
import com.lggyx.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class LggyxWebManagementApplicationTests {

    @Autowired
    DeptController deptController;
    @Autowired
    private EmpMapper empMapper;

    @Test
    void deptList() {
        //获取部门列表
        Result rs = deptController.list();
        System.out.println(rs);
    }

    @Test
    void deptDelete() {
        //获取部门列表
        Result rs = deptController.list();
        System.out.println(rs);
        //删除部门
        rs = deptController.delete(1);
        System.out.println(rs);
        //获取部门列表
        rs = deptController.list();
        System.out.println(rs);
    }

    @Test
    void deptAdd() {
        //获取部门列表
        Result rs = deptController.list();
        System.out.println(rs);
        //添加部门
        rs = deptController.add(new Dept() {
            {
                setName("测试部");
            }
        });
        System.out.println(rs);
        //获取部门列表
        rs = deptController.list();
        System.out.println(rs);
    }

    @Test
    void deptGet() {
        //获取部门列表
        Result rs = deptController.list();
        System.out.println(rs);
        //获取部门
        rs = deptController.get(1);
        System.out.println(rs);
    }

    @Test
    void deptUpdate() {
        //获取部门列表
        Result rs = deptController.list();
        System.out.println(rs);
        //修改部门
        rs = deptController.update(new Dept() {
            {
                setId(1);
                setName("测试部");
            }
        });
        System.out.println(rs);
        //获取部门列表
        rs = deptController.list();
        System.out.println(rs);
    }
    @Test
    void addData(){
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            Emp emp = new Emp(){
                {
                    setName("员工"+ finalI);
                    setGender((short) (finalI%2==0?1:0));
                    setImage("https://picsum.photos/200/300?random="+finalI);
                    setJob((short) (finalI%4==0?1:finalI%4==1?2:finalI%4==2?3:4));
                    setEntrydate(LocalDate.of(2020,1,1).plusDays(finalI));
                    setDeptId(finalI%5==0?1:finalI%5==1?2:finalI%5==2?3:finalI%5==3?4:5);
                    setCreateTime(LocalDateTime.now());
                    setUpdateTime(LocalDateTime.now());
                    setUsername("员工"+ finalI);
                    setPassword("<PASSWORD>");
                }
            };
            empMapper.add(emp);
        }
    }
}
