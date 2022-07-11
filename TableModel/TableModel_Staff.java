package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Staff;
import Utility.Department_enum;

public class TableModel_Staff extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;
	List<Staff> staffList;
	String headerList[] = new String[] { "Id", "Name", "Phone", "Department", "Role", "Active"};

	public TableModel_Staff(List<Staff> list) {
		staffList = list;
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

	public void insertRow(Staff emp) {
		staffList.add(emp);
		fireTableRowsInserted(staffList.size() - 1, staffList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Staff entity = null;
		entity = staffList.get(rowIndex);
		switch (columnIndex) {
		case 0:{
			System.out.println("Id"+entity.getId());
			return entity.getId();
		}
		case 1:
			return entity.getName();
		case 2:
			return entity.getPhone();
		case 3:
			return entity.getDepartment().getDepartmentName();
		case 4:
			return entity.getRole().getRole_name();
		case 5:
			return entity.getActive();
		default:
			return "";
		}
	}
	
	public int getStaff_Id(int rowIndex) {
		Staff staff = staffList.get(rowIndex);
		return staff.getId();
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
				staff.getDepartment().setDepartmentName(e.getDepartment().getDepartmentName());
				fireTableCellUpdated(rowIndex, i);
				
			case 4:
				staff.getRole().setRole_name(e.getRole().getRole_name());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 5:
				staff.setActive(e.getActive());
				fireTableCellUpdated(rowIndex, i);
				break;
			}

	}

}
