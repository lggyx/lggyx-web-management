package com.lggyx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @TableName dept
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

}