package a.b.entity;

public class Address {
	private String employee;
	private String address;
	

	public Address(String employee, String address) {
		this.employee = employee;
		this.address = address;
	}

	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [employee=" + employee + ", address=" + address + "]";
	}

	
}
