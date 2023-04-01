package TableModel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import org.apache.tools.ant.taskdefs.Java;

import Controller.DeliveryManage_Controller;
import Model.Order;
import Model.OrderAssign;
import Service.Order_service;

public class TableModel_OrderAssign extends AbstractTableModel {

	JButton btn_viewDetail;
	private static final long serialVersionUID = -4026402599426071004L;
	List<Order> orderList;
	String headerList[] = new String[] { "Selected", "No", "Order_Id", "Name", "Phone", "Destination", "Date", "Fee",
			"View Detail" };

	public TableModel_OrderAssign(List<Order> list, JButton btnDetail) {
		orderList = list;
		this.btn_viewDetail = btnDetail;
	}

	public TableModel_OrderAssign() {

	}

	@Override
	public int getRowCount() {
		return orderList.size();
	}

	@Override
	public int getColumnCount() {
		return headerList.length;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	/*
	 * public boolean isCellEditable(int col) {
	 * 
	 * return col == 6;
	 * 
	 * }
	 */
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	public void removeAllrow() {
		if (orderList != null) {
			orderList.clear();
			fireTableDataChanged();
		}
	}

	public void removeRow(int rowIndex) {
		orderList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(OrderAssign order) {
		orderList.add(order);
		fireTableRowsInserted(orderList.size() - 1, orderList.size() - 1);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Order entity = null;

		entity = orderList.get(rowIndex);

		switch (columnIndex) {
		case 0:

		{
			return new Boolean(entity.getAssign());
		}
		case 1:
			return rowIndex + 1;
		case 2:
			return entity.getOrder_no();
		case 3:
			return entity.getCustomer().getName();
		case 4:
			return entity.getCustomer().getPhone();
		case 5:
			return entity.getDestination().getDestinationName();
		case 6:
			return entity.getDate();
		case 7:
			return entity.getTransportationfees();
		case 8:
			return btn_viewDetail;
		default:
			return "";
		}

	}

	public String getOrder_no(int i) {
		Order order = orderList.get(i);
		return order.getOrder_no();
	}

	public int getCustomer_Id(int i) {
		return orderList.get(i).getCustomer().getId();
	}

	public void clearChecks(List<Integer> list) {
		// System.out.println("Row Count-" + rowCount);
		for (int index : list) {
			for (int j = 0; j < headerList.length; j++) {
				Order order = new Order();
				order = orderList.get(index);
				order.setAssign(false);

				System.out.println("i" + index + " j" + j);
				fireTableRowsUpdated(index, j);
			}
		}

//		for (int i = 0; i < rowCount; i++) {
//			for (int j = 0; j < 2; j++) {
//				Order order = new Order();
//				order = orderList.get(i);
//				order.setAssign(false);
//				System.out.println("i" + i + " j" + j);
//				fireTableRowsUpdated(i, j);
//			}
//		}

	}

	public void setValueAt(int rowIndex, int colIndex) {
		if (colIndex == 0) {
			Order order = orderList.get(rowIndex);
			boolean assign = (boolean) getValueAt(rowIndex, 0);
			if (assign) {
				order.setAssign(false);
				fireTableCellUpdated(rowIndex, 0);
			} else {
				order.setAssign(true);
				fireTableCellUpdated(rowIndex, 0);
			}

		}

	}

}
