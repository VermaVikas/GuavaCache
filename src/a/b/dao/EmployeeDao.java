package a.b.dao;

import java.util.HashMap;
import java.util.Map;

import a.b.entity.Employee;

public class EmployeeDao {
	
	static EmployeeDao empDao;
	public static EmployeeDao getInstance(){
		if(empDao == null){
			empDao = new EmployeeDao();
		}
		return empDao;
	}
	
	public Employee getFromDatabase(String empId) {
		
		Employee e1 = new Employee("Mahesh", "Finance", "100");
		Employee e2 = new Employee("Rohan", "IT", "103");
		Employee e3 = new Employee("Sohan", "Admin", "110");
		
		Map<String, Employee> database = new HashMap<String, Employee>();
		
		database.put("1", e1);
		database.put("2", e2);
		database.put("3", e3);
		
		System.out.println("-- Database hit for" + empId);
		
		return database.get(empId);
	}

}
