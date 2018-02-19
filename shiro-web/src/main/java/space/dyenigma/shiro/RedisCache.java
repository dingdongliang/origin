package space.dyenigma.shiro;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import space.dyenigma.util.Constants;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:53
 */
public class RedisCache<K, V> implements Cache<K, V> {
    // 缓存的超时时间，单位为s
    private long expireTime = 120;
    private String name;
    // 通过构造方法注入该对象
    private RedisTemplate<String, V> redisTemplate;

    public RedisCache() {
        super();
    }

    public RedisCache(long expireTime, RedisTemplate<String, V> redisTemplate, String name) {
        super();
        this.expireTime = expireTime;
        this.redisTemplate = redisTemplate;
        this.name = name;
    }

    /**
     * @param key
     * @return V
     * @Description : 通过key来获取对应的缓存对象,shiro需要的key的类型为Object，V的类型为AuthorizationInfo对象
     * @author dingdongliang
     * @date 2018/2/15 8:59
     */
    @Override
    public V get(K key) throws CacheException {
        V obj = redisTemplate.opsForValue().get(name + new String(SerializationUtils.serialize(getCacheKey(key))));
        if (obj != null) {
            System.out.println(obj.toString());
        }
        return obj;
    }

    /**
     * @param key
     * @param value
     * @return V
     * @Description : 将权限信息加入缓存中
     * @author dingdongliang
     * @date 2018/2/15 8:59
     */
    @Override
    public V put(K key, V value) throws CacheException {

        redisTemplate.opsForValue().set(name + new String(SerializationUtils.serialize(getCacheKey(key))), value, this.expireTime, TimeUnit.SECONDS);
        return value;
    }

    /**
     * @param key
     * @return V
     * @Description : 将权限信息从缓存中删除
     * @author dingdongliang
     * @date 2018/2/15 8:59
     */
    @Override
    public V remove(K key) throws CacheException {

        V v = redisTemplate.opsForValue().get(name + new String(SerializationUtils.serialize(getCacheKey(key))));
        redisTemplate.opsForValue().getOperations().delete(name + new String(SerializationUtils.serialize(getCacheKey(key))));

        System.out.println("====removeremove=========" + key + "===============");
        return v;
    }

    @Override
    public void clear() throws CacheException {
        System.out.println("clearclearclearclearclearclearclearclearclear");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private String getCacheKey(Object key) {
        return Constants.REDIS_SHIRO_CACHE + ":" + key;
    }

}  