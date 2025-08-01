package com.example.caching.weather;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("weathercache");
    }
}
