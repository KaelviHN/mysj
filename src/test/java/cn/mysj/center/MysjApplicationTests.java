package cn.mysj.center;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootTest
class MysjApplicationTests {
    @Resource
    public PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String password = "123456";
        password = passwordEncoder.encode(password);
        System.out.println(password);
        System.out.println(UUID.randomUUID());
    }

}
