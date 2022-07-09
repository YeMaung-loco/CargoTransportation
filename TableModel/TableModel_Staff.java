package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Staff;

public class TableModel_Staff extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;

	List<Staff> staffList;
	// View_Staff view_Staff;
	String headerList[] = new String[] { "Id", "Name", "Phone", "Role", "Department", "Is Active"};

	public TableModel_Staff(List<Staff> list) {
		staffList = list;
		// view_Staff = vStaff;
	}

	public TableModel_Staff() {

	}

	@Override
	public int getRowCount() {
		return staffList.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	public void removeRow(int rowIndex) {
		staffList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(Staff staff) {
		staffList.add(staff);
		fireTableRowsInserted(staffList.size() - 1, staffList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Staff entity = null;
		entity = staffList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return entity.getId();
		case 1:
			return entity.getName();
		case 2:
			return entity.getPhone();
		case 3:
			return entity.getRoleName();
		case 4:
			return entity.getDepartmentName();
		case 5:
			return entity.getActive();
		default:
			return "";
		}
	}

	public void setValueAt(Staff e, int rowIndex) {
				Staff staff = staffList.get(rowIndex);
		for (int i = 1; headerList.length > i; i++)
			switch (i) {
			case 1:
				staff.setName(e.getName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 2:
				staff.setPhone(e.getPhone());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 3:
				staff.setRoleName(e.getRoleName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 4:
				staff.setDepartmentName(e.getDepartmentName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 5:
				staff.setActive(e.getActive());
				fireTableCellUpdated(rowIndex, i);
				break;
			}

	}

}
