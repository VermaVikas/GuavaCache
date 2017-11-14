package a.b.main;

import java.util.concurrent.ExecutionException;

import a.b.util.CacheManager;

public class Application {

	public static void main(String args[]) {
		
		try {
			CacheManager.loadAllCache();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			String key = "Employee";
			// employee record
			System.out.println("Employee Invocation #1");
			System.out.println(CacheManager.getFromChache(key, "1"));
			System.out.println(CacheManager.getFromChache(key, "2"));
			System.out.println(CacheManager.getFromChache(key, "3"));

			// second invocation, data will be returned from cache
			System.out.println("\n\n Employee Invocation #2");
			System.out.println(CacheManager.getFromChache(key, "3"));
			System.out.println(CacheManager.getFromChache(key, "1"));
			System.out.println(CacheManager.getFromChache(key, "2"));
			
			
			key = "Address";
			// Address record
			System.out.println("\n\nAddress Invocation #1");
			System.out.println(CacheManager.getFromChache(key, "101"));
			System.out.println(CacheManager.getFromChache(key, "102"));
			System.out.println(CacheManager.getFromChache(key, "103"));

			// second invocation, data will be returned from cache
			System.out.println("\n\nAddress Invocation #1");
			System.out.println(CacheManager.getFromChache(key, "103"));
			System.out.println(CacheManager.getFromChache(key, "101"));
			System.out.println(CacheManager.getFromChache(key, "102"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
