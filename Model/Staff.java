package Model;

import java.sql.Date;
<<<<<<< Updated upstream

public class Staff extends PersonInfo {
=======

public class Staff extends PersonInfo {

	private String nrc, date;
	int departmentId;
	int roleId;
>>>>>>> Stashed changes

	private String nrc, departmentName, roleName;
	int roleId, departmentId;
	Date date;
	
	private boolean active;

	public Staff() {
		super();
	}

	public Staff(String name, String phone, String address, String nrc, int roleId, int departmentId, boolean active,
<<<<<<< Updated upstream
			Date date) {
=======
			String date) {
>>>>>>> Stashed changes

		super(name, phone, address);
		this.nrc = nrc;
		this.departmentId = departmentId;
		this.date = date;
		this.roleId = roleId;
		this.active = active;
		this.date = date;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

<<<<<<< Updated upstream
	public void setDepartmentName(String department) {
		this.departmentName = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public int getRoleId() {
=======
	public int getRole() {
>>>>>>> Stashed changes
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
