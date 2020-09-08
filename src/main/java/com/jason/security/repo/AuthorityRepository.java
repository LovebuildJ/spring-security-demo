package com.jason.security.repo;

import com.jason.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description 权限
 * @Date 2020/9/8 13:07
 * @Author by 尘心
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
