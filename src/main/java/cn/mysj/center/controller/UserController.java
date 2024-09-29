package cn.mysj.center.controller;

import cn.mysj.center.domain.model.SysUser;
import cn.mysj.center.repository.SysUserRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: anran.ma
 * @created: 2024/9/27
 * @description:
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private SysUserRepository sysUserRepository;

    @GetMapping("getById")
    public SysUser getUserById(String id) {
        return sysUserRepository.findById(id).orElse(null);
    }
}
