package com.huangbin.gsarts.model.role;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.huangbin.gsarts.model.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色信息
 */
@Entity
@Table(name = "T_ROLE")
@Data
@Setter
@Getter
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20, nullable = false)
    private String name;
    private Long sortNo;
    @Column(length = 1, nullable = false)
    private String status;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_role_user", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> userList;
}
