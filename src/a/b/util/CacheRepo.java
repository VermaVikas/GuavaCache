package a.b.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import a.b.dao.AddressDao;
import a.b.dao.EmployeeDao;
import a.b.entity.Address;
import a.b.entity.Employee;

// ONLY FOT UNDERSTANDING
@Deprecated
public class CacheRepo {
	
	Map<String, LoadingCache<String, Object>> cacheMAnager;
	
	CacheUtil<Employee> eC = new CacheUtil<Employee>();
	
	public Employee getFromEmployeeCache(String id) throws ExecutionException{
		return CacheUtil.employeeCache.get(id);
	}
	
	public Address getFromAddressCache(String id) throws ExecutionException{
		return CacheUtil.addressCache.get(id);
	}
	
	public Employee getFromEmployeeCacheGC(String id) throws ExecutionException{
		
		CacheLoader<String, Employee> cL = new CacheLoader<String, Employee>() { // build the cacheloader
			@Override
			public Employee load(String empId) throws Exception {
				// make the expensive call
				return EmployeeDao.getInstance().getFromDatabase(empId);
			}
		};
		return (Employee) eC.getValueGenCache(cL, "1"); 
	}
	
}
