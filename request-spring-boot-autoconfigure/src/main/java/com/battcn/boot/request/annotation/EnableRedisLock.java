package com.battcn.boot.request.annotation;

import com.battcn.boot.request.configuration.redis.lock.RedisLockAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 基于 Redis 实现的分布式锁
 *
 * @author Levin
 * @since 2018-01-15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({RedisLockAutoConfiguration.class})
public @interface EnableRedisLock {

    /**
     * 是否开启 @RedisLock 的拦截器功能，开启使用注解意味着自动上锁和释放，如果不需要则自行手动
     *
     * @return true | false
     */
    boolean lockInterceptor() default true;

    /**
     * 是否开启默认的 KeyGenerator
     *
     * @return true | false
     */
    boolean defaultKeyGenerator() default true;

}
