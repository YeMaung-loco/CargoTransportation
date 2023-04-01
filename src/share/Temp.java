package share;

import java.util.List;
import javax.swing.table.TableRowSorter;

import Model.Order;
import TableModel.TableModel_OrderAssign;

public class Temp {
	static int lastTabPane = 0;
	static List<String> assignList;
	static boolean assign=false;
	static TableRowSorter<TableModel_OrderAssign> Ordersorter;
	static List<Order> orderList; 

	 public static void setAssign(boolean flag) {
		 assign=flag;
	 }
	 
	 public static boolean getAssign() {
		 return assign;
	 }
	 
	 public static TableRowSorter<TableModel_OrderAssign> getSorter(){
		 return Ordersorter;
	 }
	 
	 public static void setOrderList(List<Order> list) {
		 orderList=list;
	 }
	 public static List<Order> getOrderList(){
		 return orderList;
	 }
	 
	 public static void setSorter(TableRowSorter<TableModel_OrderAssign> ordersorter){
		 Ordersorter=ordersorter;
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
