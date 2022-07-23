package Model;

import javax.swing.text.PasswordView;

public class Authenticate {
private int staffid;
private String username;
private String password;

public Authenticate(int staffid, String username, String password) {
	
	this.staffid = staffid;
	this.username = username;
	this.password = password;
}
public Authenticate() {
	
}
public int getStaffid() {
	return staffid;
}
public void setStaffid(int staffid) {
	this.staffid = staffid;
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

}
