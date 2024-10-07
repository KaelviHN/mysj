package cn.mysj.center.service;

import cn.mysj.center.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: KaelviHN
 * @created: 2024/10/7
 * @description:
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    /**
     * 根据用户手机号获取用户信息
     * @param account the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        return userRepository.findByPhone(account);
    }
}
