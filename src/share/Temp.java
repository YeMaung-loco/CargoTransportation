package share;

import java.util.List;

public class Temp {
	static int lastTabPane = 0;
	static List<String> assignList;
	static boolean assign=false;

	 public static void setAssign(boolean flag) {
		 assign=flag;
	 }
	 
	 public static boolean getAssign() {
		 return assign;
	 }
	 
	public static void setAssignList(List<String> list) {
		assignList = list;
	}
	
	public static List<String> getAssignList(){
		return assignList;
	}

	public static void setLastTabPane(int i) {
		lastTabPane = i;
	}

	public static int getLastTabPane() {
		return lastTabPane;
	}

}
