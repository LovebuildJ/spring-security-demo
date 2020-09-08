package com.jason.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Description web security 配置类
 * @Date 2020/8/7 16:01
 * @Author by 尘心
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /** 注入加密算法对象 */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 授权
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 授权
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/index")
//                .loginProcessingUrl("/login")
                // 登录请求以及静态资源放行
                .and().authorizeRequests().antMatchers("/loginPage","/css/**","/images/**","/js/**","/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").authenticated()
                .and()
                .authorizeRequests().anyRequest().permitAll();
        http.rememberMe();
    }

    /**
     * 认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    /**
     * 基于内存方式认证用户信息
     */
    @Bean
    public UserDetailsService getUserDetailsService() {
        InMemoryUserDetailsManager memory = new InMemoryUserDetailsManager();
        memory.createUser(User.withUsername("zhangsan").password(passwordEncoder.encode("123")).authorities("a1").build());
        return memory;
    }

    /**
     * 注入密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
