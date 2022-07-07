package Model;

public class Staff extends PersonInfo {

	private String nrc, departmentId, date, username, password;
	int roleId;

	private boolean active;

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc,int roleId,String departmentId, boolean active, String date) {

		super(name, phone, address);
		this.nrc = nrc;
		this.departmentId = departmentId;
		this.date = date;
		this.roleId = roleId;
		this.active = active;
	}

	public void setActive(boolean active) {
		System.out.println("Staff.java" + active);
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	

	public int getRole() {
		return roleId;
	}

	public void setRole(int role) {
		this.roleId = role;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
