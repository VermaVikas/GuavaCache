package a.b.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class CacheManager {
	
	static Map<String, LoadingCache<String, Object>> cacheMAnager = new HashMap<String, LoadingCache<String, Object>>();
	
	
	/**
	 * Fetch Value from Cache
	 * @param entity
	 * @param id
	 * @return Object from cache
	 * @throws ExecutionException
	 */
	public static Object getFromChache(String entity, String id) throws ExecutionException{
		return cacheMAnager.get(entity).get(id);
	}
	
	
	/**
	 * Call this method to initialize all cache.
	 * Add loadCache method call in this method if you want to add cache in cacheManager 
	 * @throws ExecutionException
	 */
	public static void loadAllCache() throws ExecutionException{
		loadCache("Employee", "getFromDatabase");
		loadCache("Address", "getFromDatabase");
	}
	
	/**
	 * Adds 'key - Loading Cache' pair in cacheManager.
	 * @param entityClassName Entity class name as string, 
	 * this string will also be used for dao class name after appending 'Dao'.
	 * eg. if entityClassName is 'Entity' then dao will be 'EntityDao'.
	 * @param methodNameToFetchById name of method as string that will be used to 
	 * fetch object by using 'id' which is passed as parameter 
	 * to {@link #getFromChache(String, String)} method.
	 * @throws ExecutionException
	 */
	private static void loadCache(String entityClassName, String methodNameToFetchById) throws ExecutionException{
		cacheMAnager.put(entityClassName, buildCache(CacheLoaders.createCacheLoader(entityClassName + "Dao", methodNameToFetchById)) );
	}
	
	private static LoadingCache<String, Object> buildCache(CacheLoader cacheLoader) {
        LoadingCache<String, Object> customCache = CacheBuilder.newBuilder().maximumSize(100)
				.expireAfterAccess(30, TimeUnit.MINUTES)
				.build(cacheLoader);
		return customCache;
    }
}
