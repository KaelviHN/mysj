package cn.mysj.center;

import jakarta.annotation.Resource;
import org.hibernate.annotations.Source;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MysjApplicationTests {
    @Resource
    public PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String password = "123456";
        password = passwordEncoder.encode(password);
        System.out.println(password);
    }

}
