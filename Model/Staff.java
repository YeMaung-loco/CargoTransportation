package Model;

import java.sql.Date;

public class Staff extends PersonInfo {

	private String nrc, departmentName, roleName;
	int roleId, departmentId;
	Date date;
	
	private boolean active;

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc, int roleId, int departmentId, boolean active,
			Date date) {

		super(name, phone, address);
		this.nrc = nrc;
		this.departmentId = departmentId;
		this.date = date;
		this.roleId = roleId;
		this.active = active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	public void setDepartmentName(String department) {
		this.departmentName = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int role) {
		this.roleId = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String role) {
		this.roleName = role;

	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
