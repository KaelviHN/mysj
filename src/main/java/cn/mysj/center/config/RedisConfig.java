package cn.mysj.center.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: KaelviHN
 * @created: 2024/10/7
 * @description:
 **/
//@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 设置 Key 的序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        // 设置 Value 的序列化方式
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        // 设置 Hash Key 的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        // 设置 Hash Value 的序列化方式
        template.setHashValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}