package com.huangbin.gsarts.model.log;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by huangbin on 2017/9/8.
 */

@Entity
@Table(name = "T_APP_ACCESS_LOG")
@Data
public class AppAccessLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(length = 20, nullable = false)
    private String appName; //应用名称

    @Column(length = 50)
    private String url; //访问地址

    @Column(length = 20)
    private String userName; //用户名称

    @Column(length = 20)
    private String ip; //ip地址

    @Column(length = 20)
    private Date accessTime; //获取时间


}
