package com.huangbin.gsarts.model.user;

import com.huangbin.gsarts.model.role.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_USER")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 1, nullable = false)
    private String gender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date birthday;

    @Column(length = 100)
    private String password;

    @Column(length = 1, nullable = false)
    private long sortNo;


    @Column(length = 1, nullable = false)
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_user", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;

}
