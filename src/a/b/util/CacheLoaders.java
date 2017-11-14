package a.b.util;

import java.lang.reflect.Method;

import com.google.common.cache.CacheLoader;

public class CacheLoaders {
	
	static Class dao;
	static Method method;
	static Object daoObject;
	
	
	/**
	 * Create cache loader
	 * @param daoClass Dao class name as string
	 * @param methodNameToFetchById method name which will find object by using objId
	 * @return CacheLoader<String, Object>
	 */
	public static CacheLoader<String, Object> createCacheLoader(final String daoClassName, final String methodNameToFetchById){
		CacheLoader<String, Object> cL = new CacheLoader<String, Object>() { // build the cacheloader
			@Override
			public Object load(String objId) throws Exception {
				System.out.println("in load Cache :: " + daoClassName);
				dao = Class.forName("a.b.dao."+daoClassName);
				method = dao.getMethod(methodNameToFetchById, String.class);
				daoObject = dao.newInstance();
				return (Object) method.invoke(daoObject, objId);
			}
		};
		return cL;
	}
}
