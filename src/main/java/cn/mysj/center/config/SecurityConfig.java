package cn.mysj.center.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author: anran.ma
 * @created: 2024/9/28
 * @description:
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("user")
//                .password("$2a$10$Vv7.yFAfacR4QoSf/J8EQOXdUny4x4SsLDQm0NS0ewuIvSiCU7MOm")
//                .roles("admin")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 关闭csrf机制
        http.csrf(CsrfConfigurer::disable);
        // 自定义登录页面
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/to_login")
                .permitAll()
                .anyRequest()
                .authenticated());
        // 表单，basic等等   跳转到自定义登录页
        http.formLogin(from -> from.loginPage("/to_login")
                // 处理前端请求
                .loginProcessingUrl("/doLogin")
                // 用户名
                .usernameParameter("username")
                // 密码
                .passwordParameter("password")
                // 成功跳转
                .successForwardUrl("/to_index"));
        return http.build();
    }
}
