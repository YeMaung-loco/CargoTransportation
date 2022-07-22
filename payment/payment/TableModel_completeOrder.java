package TableModel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Model.Order;

public class TableModel_completeOrder extends AbstractTableModel{
	private static final long serialVersionUID = -4026402599426071004L;
	List<Order> orderList;
    JButton btn_viewdetail;
	String headerList[] = new String[] { "No", "Order_Id", "Name", "Phone", "Destination", "Date", "Fee",
			"View Detail" };
	

	
	public TableModel_completeOrder(List<Order>list,JButton btn_viewDetail) {
		orderList=list;
		this.btn_viewdetail=btn_viewDetail;
	}

	public TableModel_completeOrder() {

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
	 * public boolean isCellEditable(EventObject e) { return true; }
	 */
	
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
	public void setValueAt(Order e, int rowIndex) {
		Order order = orderList.get(rowIndex);
		for (int i = 1; headerList.length > i; i++)
			switch (i) {
			case 2:
				order.getCustomer().setName(e.getCustomer().getName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 3:
				order.getCustomer().setPhone(e.getCustomer().getPhone());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 4:
				order.getDestination().setDestinationName(e.getDestination().getDestinationName());
				fireTableCellUpdated(rowIndex, i);

			case 5:
				order.setDate(e.getDate());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 6:
				order.setTransportationfees(e.getTransportationfees());
				fireTableCellUpdated(rowIndex, i);
				break;
				
			/*
			 * case 7: this.btn_viewDetail;
			 */
			}

	}

}
