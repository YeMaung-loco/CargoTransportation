package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Package;

public class TableModel_Orderdetail extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;
	List<Package> packageList;
	String headerList[] = new String[] { "No", "Package ID" };

	public TableModel_Orderdetail(List<Package> List) {
		this.packageList = List;
		for (Package pack : packageList) {
			System.out.println("Package Id"+pack.getPackage_id());

		}
	}

	public TableModel_Orderdetail() {

	}

	@Override
	public int getRowCount() {
		return packageList.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	

	public void insertRow(Package pack) {
		packageList.add(pack);
		fireTableRowsInserted(packageList.size() - 1, packageList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Package entity = new Package();

		entity = packageList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return entity.getPackage_id();

		default:
			return "";
		}
	}

	public int getPackage_id(int i) {
		return packageList.get(i).getPackage_id();
		
	}
public void setValueAt(Package e, int rowIndex) {
		Package pack = packageList.get(rowIndex);
		for (int i = 1; i < headerList.length; i++) {
			switch (i) {
			case 2:
				pack.setPackage_id(e.getPackage_id());
				fireTableCellUpdated(rowIndex, i);
				break;
			}

		}

	}
}
