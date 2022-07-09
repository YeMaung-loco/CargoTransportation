package Model;

public class Staff extends PersonInfo {

	private String nrc, date;
	private  Role role;
	private Department department;

	private boolean active;
	private String name;
	

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc, int roleId, Department depart, boolean active,
			String date) {

		super(name, phone, address);
		this.nrc = nrc;
		this.department = depart;
		this.date = date;
		this.role = role;
		this.active = active;
	}

	public void setActive(boolean active) {
		System.out.println("Staff.java" + active);
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDepartment(Department department) {
		this.department=department;
		
		
	}
	public Department getDepartment() {
		return department;
	}
	public void setRole(Role role) {
		this.role=role;
	}public Role getRole() {
		return role;
	}

	

}
