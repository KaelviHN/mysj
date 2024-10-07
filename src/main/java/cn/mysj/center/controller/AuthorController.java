package cn.mysj.center.controller;

import cn.mysj.center.domain.common.Result;
import cn.mysj.center.domain.dto.LoginParams;
import cn.mysj.center.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KaelviHN
 * @created: 2024/10/7
 * @description:
 **/

@RestController
@RequestMapping("auth")
public class AuthorController {

    @Resource
    private UserService userService;


    /**
     * 用户登录
     * @param params
     * @return
     */
    @PostMapping("signIn")
    public Result<String> signIn(@RequestBody LoginParams params) throws JsonProcessingException {
        String data = userService.signIn(params);
        return Result.success(data);
    }
}