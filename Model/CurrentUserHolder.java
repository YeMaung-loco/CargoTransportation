package utils;

import Model.Staff;

public class CurrentUserHolder {

	private static Staff staff;
	
	private CurrentUserHolder() {}
	
	public static Staff getCurrentUser() {
		return staff;
	}
	
	public static void setLoggedInUser(Staff staff) {
		CurrentUserHolder.staff = staff;
	}
}
