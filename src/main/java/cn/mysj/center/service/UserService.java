package cn.mysj.center.service;

import cn.mysj.center.domain.dto.LoginParams;
import cn.mysj.center.domain.model.SysUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author: KaelviHN
 * @created: 2024/9/28
 * @description:
 **/

@Service
public class UserService  {

    @Resource
    @Lazy
    private AuthenticationManager authenticationManager;

    @Resource
    private ObjectMapper objectMapper;

    public String signIn(LoginParams params) throws JsonProcessingException {
        // 传入账户和密码 && 调用loaderUser
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(params.getAccount(), params.getPassword());
        Authentication authenticate = null;
        try {
            authenticationManager.authenticate(token);
        } catch (AuthenticationException e) {
            throw new RuntimeException( "账号或密码错误");
        }
        // 获取返回的用户
        SysUser user = (SysUser) authenticate.getPrincipal();
        return objectMapper.writeValueAsString(user);
    }

}
