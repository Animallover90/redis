package redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisConfig redisConfig;

    @Test
    void redisDTOTest() {
        RedisDTO redisDTO = new RedisDTO("1", "abc", "ROLE_USER");
        redisUtil.setDTOOps("USER123456", redisDTO, 30, TimeUnit.SECONDS);
        RedisDTO redisData = redisUtil.getDTOOps("USER123456");
        log.info("redisData = {}", redisData);
    }

    @Test
    void redisStringTest() {
        RedisConnectionFactory redisConnectionFactory = redisConfig.redisConnectionFactory();
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
        stringRedisTemplate.opsForValue().set("abc", "bbbbb");
    }
}
