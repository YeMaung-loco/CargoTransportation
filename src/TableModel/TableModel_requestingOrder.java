package TableModel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Model.Order;

public class TableModel_requestingOrder extends AbstractTableModel {
	private static final long serialVersionUID = -4026402599426071004L;
	List<Order> orderList;
	JButton btn_viewdetail;
	JButton btn_approve;
	String headerList[] = new String[] { "No", "Order_Id", "Name", "Phone", "Destination", "Date", "Fee", "Approve",
			"View Detail" };

	public TableModel_requestingOrder(List<Order> list, JButton btn_viewDetail, JButton btn_approve) {
		orderList = list;
		this.btn_viewdetail = btn_viewDetail;
		this.btn_approve = btn_approve;
	}

	public TableModel_requestingOrder() {

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

//	public boolean isCellEditable(int col) {
//		return col==7;
//	}

	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	public void removeRow(int rowIndex) {
		orderList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(Order order) {
		orderList.add(order);
		fireTableRowsInserted(orderList.size() - 1, orderList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order entity = null;

		entity = orderList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return entity.getOrder_no();
		case 2:
			return entity.getCustomer().getName();
		case 3:
			return entity.getCustomer().getPhone();
		case 4:
			return entity.getDestination().getDestinationName();
		case 5:
			return entity.getDate();
		case 6:
			return entity.getTransportationfees();
		case 7:
			if (entity.getStatus().equals("Delivering"))
				return btn_approve;

			else {
				return entity.getStatus();
			}
		case 8:
			return btn_viewdetail;
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

	public void setValueAt(int rowIndex, int colIndex) {
		if (colIndex == 7) {
			Order order = orderList.get(rowIndex);
			// boolean assign = (boolean) getValueAt(rowIndex, 0);
			order.setStatus("Completed");
			fireTableCellUpdated(rowIndex, 0);

		}

	}

}
