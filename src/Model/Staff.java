package Model;

import java.sql.Date;

public class Staff extends PersonInfo {

	private String nrc;
	private Role role;
	private Department department;
	Date  date;
	private boolean active;
	private String name;

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc, int roleId, Department depart,Role role, boolean active,
			Date date) {

		super(name, phone, address);
		this.nrc = nrc;
		this.department = depart;
		this.date = date;
		this.role = role;
		this.active = active;
	}

	public void setActive(boolean active) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDepartment(Department department) {
		this.department = department;

	}

	public Department getDepartment() {
		return department;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

}