package space.dyenigma.configure.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * origin/space.dyenigma.configure.redis
 *
 * @Description: Redis集群session共享配置
 * @Author: dingdongliang
 * @Date: 2017/10/18 9:45
 */
@Configuration
@EnableRedisHttpSession
public class RedisClusterConfig {

}
