package com.huangbin.gsarts.model.sysInfo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统参数信息表
 * 设置系统全局参数
 *
 * @author huangbin
 */
@Entity
@Table(name = "T_SYS_PARAMS")
@Data
public class SysParams implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(length = 30, nullable = false)
    private String paramName; //系统参数名称

    @Column(length = 100, nullable = false)
    private String paramDesc; //系统参数描述

    @Column(length = 100, nullable = false)
    private String paramValue; //系统参数值

    @Column(length = 1)
    private String status; //状态
}


