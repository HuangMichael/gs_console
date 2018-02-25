package com.huangbin.gsarts.model.sysInfo;


/**
 * Created by 路丽民 on 2017/5/7 0007.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统信息表
 *
 * @author lulimin
 */
@Entity
@Table(name = "T_SYS_INFO")
@Data
public class SysInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(length = 30, nullable = false)
    private String sysName; //系统名称

    @Column(length = 100, nullable = false)
    private String sysDesc; //系统描述

    @Column(length = 100, nullable = false)
    private String logoUrl; //logo图标路径

    @Column(length = 1)
    private String status; //状态
}


