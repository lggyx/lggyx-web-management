package com.lggyx;

import com.lggyx.controller.DeptController;
import com.lggyx.domain.Dept;
import com.lggyx.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LggyxApplicationTests {

    @Autowired
    DeptController deptController;
    @Test
    void getDeptById(){
        for (long i = 0L; i < 7; i++) {
            deptController.getDept(i);
        }
    }

}
