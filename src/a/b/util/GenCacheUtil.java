package a.b.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GenCacheUtil {

	public <K, Class> LoadingCache<K, Class> cached(CacheLoader<K, Class> cacheLoader) {
		LoadingCache<K, Class> cache = CacheBuilder.newBuilder().maximumSize(1000)
				.expireAfterWrite(30, TimeUnit.MINUTES)
				/*.removalListener(new RemovalListener<K, V>() {
					@Override
					public void onRemoval(RemovalNotification<K, V> rn) {
						System.out.println(rn.getKey() + "Be removed");

					}
				})*/
				.build(cacheLoader);
		return cache;
	}
	
	
}
