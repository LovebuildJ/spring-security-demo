package com.jason.security.repo;

import com.jason.security.model.User;
import com.jason.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户-角色
 * @Date 2020/9/8 13:10
 * @Author by 尘心
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

    /**
     * 角色id查询
     * @return
     */
    List<UserRole> findByRoleId(@Param("roleId") Integer roleId);

    /**
     * 用户id查询
     * @return
     */
    List<UserRole> findByUserId(@Param("userId") Integer userId);
}
