package Model;

public class Role {
	private int id;
	private String role_name;

	public Role() {

	}
	public Role(int id, String role_name) {
		this.id = id;
		this.role_name = role_name;
	}

	public int getRole_Id() {
		return id;
	}

	public void setRole_Id(int id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
