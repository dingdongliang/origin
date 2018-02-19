package space.dyenigma.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import space.dyenigma.configure.shiro.ShiroProperties;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description : 该类提供redis cache。缓存 登录失败次数和用户权限。
 * 过期时间分别对应application.yml 中的 retry-expire-time-redis和 authorization-expire-time-redis
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:53
 */
public class RedisCacheManager implements CacheManager, Destroyable {

    private RedisTemplate redisTemplate;
    private long expireTime;

    @Autowired
    private ShiroProperties properties;

    public RedisCacheManager(RedisTemplate redisTemplateTemp) {
        redisTemplate = redisTemplateTemp;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {

        if (name.equals("passwordRetryCache")) {
            expireTime = properties.getRetryExpireTimeRedis();
        } else {
            expireTime = properties.getAuthorizationExpireTimeRedis();
        }
        return new RedisCache<K, V>(expireTime, redisTemplate, name);
    }

    @Override
    public void destroy() throws Exception {

    }

}  