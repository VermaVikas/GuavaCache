package a.b.dao;

import java.util.HashMap;
import java.util.Map;

import a.b.entity.Address;
import a.b.entity.Employee;

public class AddressDao {
	
	static AddressDao addDao;
	public static AddressDao getInstance(){
		if(addDao == null){
			addDao = new AddressDao();
		}
		return addDao;
	}
	
	public Address getFromDatabase(String addressId) {
		
		Address e1 = new Address("Mahesh", "Address1");
		Address e2 = new Address("Rohan", "Address2");
		Address e3 = new Address("Sohan", "Address3");
		
		Map<String, Address> database = new HashMap<String, Address>();
		
		database.put("101", e1);
		database.put("102", e2);
		database.put("103", e3);
		
		System.out.println("Database hit for" + addressId);
		
		return database.get(addressId);
	}

}
