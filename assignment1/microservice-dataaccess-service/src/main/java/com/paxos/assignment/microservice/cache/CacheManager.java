package com.paxos.assignment.microservice.cache;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheManager {
	
    private LoadingCache<String, String> cache;
    
    private static CacheManager instance;
    
    /** Singleton constructor   **/
    private CacheManager() {
    	
    	if(cache==null){
    		
    		cache = CacheBuilder.newBuilder()
                    .concurrencyLevel(4).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return new String();
                }
            });
    	}
    }
    
    public static synchronized CacheManager getInstance(){
        if(instance == null){
            instance = new CacheManager();
        }
        return instance;
    }
    

    public String get(String key) throws ExecutionException{
    	
    	return cache.get(key);
    	
    }
    
    
    public void put(String key,String value) throws ExecutionException{
    	
    	 cache.put(key,value);
    	
    }
    
    
}
