package com.mindtree.DoctorApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import net.sf.ehcache.config.CacheConfiguration;

@SpringBootApplication
@EnableCaching
@Configuration
public class DoctorApplication extends CachingConfigurerSupport{

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}
//	
//	@Bean
//	public net.sf.ehcache.CacheManager ehCacheManager()
//	{
//		CacheConfiguration conf1 = new CacheConfiguration();
//		conf1.setName("cache");
//		conf1.setMemoryStoreEvictionPolicy("LRU");
//		conf1.setMaxEntriesLocalHeap(1000);
//		conf1.setTimeToLiveSeconds(10);
//		
//		net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
//		configuration.addCache(conf1);
//		
//		return net.sf.ehcache.CacheManager.newInstance(configuration);
//	}
//
//	@Bean
//	public CacheManager cacheManager()
//	{
//		return new EhCacheCacheManager(ehCacheManager());
//	}
}
