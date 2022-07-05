package Model;

public class Staff extends PersonInfo {

	private String nrc, departmentId, date, username, password, role;

	private boolean active;

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc, String username, String password, String role,
			String departmentId, boolean active, String date) {

		super(name, phone, address);
		this.nrc = nrc;
		this.departmentId = departmentId;
		this.date = date;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	public void setActive(boolean active) {
		System.out.println("employee.java" + active);
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
