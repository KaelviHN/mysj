package cn.mysj.center.config;

import cn.mysj.center.service.UserDetailServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author: KaelviHN
 * @created: 2024/9/28
 * @description: Spring Security 自定义配置
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Resource
    private UserDetailServiceImpl userDetailServiceImpl;

    /**
     * 认证管理器
     * @return
     */
    @Bean
    public AuthenticationManager authorizationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 关联UserDetailService
        provider.setUserDetailsService(userDetailServiceImpl);
        // 关联密码解码器
        provider.setPasswordEncoder(passwordEncoder);
        // 注入验证提供者，此处为username + password 认证
        return new ProviderManager(provider);
    }

    /**
     * 密码解析器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 过滤器
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 禁用csrf
        http.csrf(AbstractHttpConfigurer::disable);
        // 放行登录接口,其他全部需要认证
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/signIn").permitAll().anyRequest().authenticated());

        return http.build();
    }


}
