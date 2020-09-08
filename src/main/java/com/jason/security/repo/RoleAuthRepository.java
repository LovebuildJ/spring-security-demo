package com.jason.security.repo;

import com.jason.security.model.RoleAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 角色-权限
 * @Date 2020/9/8 13:09
 * @Author by 尘心
 */
@Repository
public interface RoleAuthRepository extends JpaRepository<RoleAuth,Integer> {

    List<RoleAuth> findByRoleId(@Param("roleId") Integer roleId);

    List<RoleAuth> findByAuthId(@Param("authId") Integer authId);
}
