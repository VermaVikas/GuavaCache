package a.b.util;

import a.b.dao.AddressDao;
import a.b.dao.EmployeeDao;
import a.b.entity.Address;
import a.b.entity.Employee;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

//ONLY FOT UNDERSTANDING
@Deprecated
public class CacheUtil<T> {
	
	LoadingCache<Object, Class<T>> genCache;
	
	static LoadingCache<String, Employee> employeeCache = CacheBuilder.newBuilder().maximumSize(100) // maximum 100 records can be cached
			.expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
			.build(new CacheLoader<String, Employee>() { // build the cacheloader
				@Override
				public Employee load(String empId) throws Exception {
					// make the expensive call
					return EmployeeDao.getInstance().getFromDatabase(empId);
				}
			});

	static LoadingCache<String, Address> addressCache = CacheBuilder.newBuilder().maximumSize(100) // maximum 100 records can be cached
			.expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
			.build(new CacheLoader<String, Address>() { // build the cacheloader
				@Override
				public Address load(String addId) throws Exception {
					// make the expensive call
					return AddressDao.getInstance().getFromDatabase(addId);
				}
			});
	
	
	
	public LoadingCache<Object, Class<T>> accessGenCache(CacheLoader cacheLoader){
		genCache = CacheBuilder.newBuilder().maximumSize(100)
				.expireAfterAccess(30, TimeUnit.MINUTES)
				.build(cacheLoader);
		return genCache;
	}
	public Object getValueGenCache(CacheLoader<?, ?> cacheLoader, Object key){
		
		try {
			return accessGenCache(cacheLoader).get(key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static LoadingCache<String, Employee> buildEmployeeCache() {
        LoadingCache<String, Employee> employeeCache = CacheBuilder.newBuilder().maximumSize(100) // maximum 100 records can be cached
				.expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
				.build(new CacheLoader<String, Employee>() { // build the cacheloader
					@Override
					public Employee load(String empId) throws Exception {
						// make the expensive call
						return EmployeeDao.getInstance().getFromDatabase(empId);
					}
				});
		return employeeCache;
    }
	
	public static LoadingCache<String, Address> buildAddressCache() {
		LoadingCache<String, Address> addressCache = CacheBuilder.newBuilder().maximumSize(100) // maximum 100 records can be cached
				.expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
				.build(new CacheLoader<String, Address>() { // build the cacheloader
					@Override
					public Address load(String addId) throws Exception {
						// make the expensive call
						return AddressDao.getInstance().getFromDatabase(addId);
					}
				});
		return addressCache;
    }
	
}
