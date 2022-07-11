package Model;

public class Department {
	private int id;
	private String departmentName;
	

	public int getDepartment_Id() {
		return id;
	}

	public void setDepartment_Id(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

	public Department(int id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	
	}

	public Department() {
	}
}
