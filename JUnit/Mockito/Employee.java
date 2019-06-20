package Mockito;

public class Employee {
	int id;
	String Name,Dept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	
	public void saveEmployeeDetails(int EmpId) {
		System.out.println("Save employee details into Databases");
	}
	
}
