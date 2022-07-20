package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Package;

public class TableModel_Package extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;
	List<String> packageList;
	String headerList[] = new String[] { "No", "Package ID" };

	public TableModel_Package(List<String> List) {
		this.packageList = List;
		for (String pack : packageList) {
			System.out.println("Package Id-"+pack);

		}
	}

	public TableModel_Package() {

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
	//	packageList.add(pack);
		fireTableRowsInserted(packageList.size() - 1, packageList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	//	Package entity = new Package();

		String entity = packageList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return entity;

		default:
			return "";
		}
	}

	public String getPackage_id(int i) {
		return packageList.get(i);
		
	}
	/*
	 * public void setValueAt(Package e, int rowIndex) { String pack =
	 * packageList.get(rowIndex); for (int i = 1; i < headerList.length; i++) {
	 * switch (i) { case 2: pack.setPackage_id(e.getPackage_id());
	 * fireTableCellUpdated(rowIndex, i); break; }
	 * 
	 * }
	 * 
	 * }
	 */
}
