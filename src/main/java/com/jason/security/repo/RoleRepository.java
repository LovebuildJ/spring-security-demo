package com.jason.security.repo;

import com.jason.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 角色
 * @Date 2020/9/8 13:06
 * @Author by 尘心
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
