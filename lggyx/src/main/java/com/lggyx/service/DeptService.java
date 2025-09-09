package com.lggyx.service;

import com.lggyx.domain.Dept;
import org.springframework.stereotype.Service;

@Service
public interface DeptService {
    Dept getDept(Long id);
}
