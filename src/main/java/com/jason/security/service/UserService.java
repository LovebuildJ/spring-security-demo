package com.jason.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.jason.security.model.*;
import com.jason.security.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 用户业务类
 * @Date 2020/9/8 12:35
 * @Author by 尘心
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RoleAuthRepository roleAuthRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * 编码器：由于数据为明文密码，故要将密码加密后比较
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 判断用户名
        if (StrUtil.isNotBlank(username)) {
            User user = userRepository.findByUsername(username);
            // 判断是否查询到用户
            if (user!=null) {

                // 资源权限合集
                List<GrantedAuthority> authorities = new ArrayList<>();

                Integer id = user.getId();
                List<UserRole> urs = userRoleRepository.findByUserId(id);
                if (urs!=null&&urs.size()!=0) {

                    // 拿到用户对于的所有角色
                    List<Role> roles = new ArrayList<>();
                    for (UserRole ur : urs) {
                        Optional<Role> roleOptional = roleRepository.findById(ur.getRoleId());
                        if (roleOptional.isPresent()) {
                            Role role = roleOptional.get();
                            roles.add(role);
                        }
                    }

                    if (CollUtil.isNotEmpty(roles)) {
                        for (Role role : roles) {
                            List<RoleAuth> roleAuths = roleAuthRepository.findByRoleId(role.getId());
                            if (CollUtil.isNotEmpty(roleAuths)) {
                                for (RoleAuth roleAuth : roleAuths) {
                                    Optional<Authority> optional = authorityRepository.findById(roleAuth.getAuthId());
                                    if (optional.isPresent()) {
                                        // 获取用户的所有权限
                                        Authority authority = optional.get();
                                        authorities.add(new SimpleGrantedAuthority(authority.getCode()));
                                    }
                                }
                            }

                        }
                    }
                }

                authorities.forEach(System.out::println);

                /*
                    这里如果数据库存放的是密文, 则直接user.getPassword即可,
                    我们因为数据库存放的密码没有加密,所以需要加密后进行比较
                 */
                return new org.springframework.security.core.userdetails.User(username,passwordEncoder.encode(user.getPassword()),authorities);
            }

        }

        return null;
    }
}
