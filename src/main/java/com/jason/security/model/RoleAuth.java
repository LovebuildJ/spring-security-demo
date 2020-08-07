package com.jason.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @Description 角色-权限
 * @Date 2020/8/7 15:23
 * @Author by 尘心
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "s_role_auth")
public class RoleAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** 角色id */
    private int roleId;
    /** 权限id */
    private int authId;
}
