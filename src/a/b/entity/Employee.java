package a.b.entity;

public class Employee {
	private String name;
	private String dept;
	private String emplD;

	public Employee(String name, String dept, String empID) {
		this.name = name;
		this.dept = dept;
		this.emplD = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmplD() {
		return emplD;
	}

	public void setEmplD(String emplD) {
		this.emplD = emplD;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", emplD=" + emplD + "]";
	}

}
