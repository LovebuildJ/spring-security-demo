package com.jason.security.repo;

import com.jason.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description 用户信息dao
 * @Date 2020/9/8 12:46
 * @Author by 尘心
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    /**
     * 用户名查询
     * @param username 用户名
     */
    User findByUsername(@Param("username") String username);
}
