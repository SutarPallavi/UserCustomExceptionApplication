package com.springbeanexample.beanexample.config;

import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class HazelcastCacheConfig {

	public Config config() {
		Config config = new Config(); 
		config.setInstanceName("hazelCast");
		
		EvictionConfig evictionConfig = new EvictionConfig(); 
		evictionConfig.setEvictionPolicy(EvictionPolicy.LRU); 
		evictionConfig.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE);
		
		MapConfig mapConfig = new MapConfig(); 
		mapConfig.setName("user-map")
		.setBackupCount(2)
		.setTimeToLiveSeconds(300)
		.setEvictionConfig(evictionConfig); 
		
		config.addMapConfig(mapConfig); 
		
		return config; 
	}
}
