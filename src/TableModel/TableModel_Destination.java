package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Destination;
import Model.Destination;

public class TableModel_Destination extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;
	List<Destination> destinationList;
	String headerList[] = new String[] { "No", "Destination", "Price"};

	public TableModel_Destination(List<Destination> list) {
		destinationList = list;
	}

	public TableModel_Destination() {

	}

	@Override
	public int getRowCount() {
		return destinationList.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	public void removeRow(int rowIndex) {
		destinationList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(Destination destination) {
		destinationList.add(destination);
		fireTableRowsInserted(destinationList.size() - 1, destinationList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Destination entity = null;

		entity = destinationList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return entity.getDestinationName();
		case 2:
			return entity.getPrice();
		
		default:
			return "";
		}
	}

	public int getDestination_Id(int i) {
		Destination destination = destinationList.get(i);
		return destination.getId();
	}

	

	public void setValueAt(Destination e, int rowIndex) {
		Destination destination = destinationList.get(rowIndex);
		for (int i = 1; headerList.length > i; i++)
			switch (i) {
			case 1:
				destination.setDestinationName(e.getDestinationName());
				fireTableCellUpdated(rowIndex, i);
				break;

			case 2:
				destination.setPrice(e.getPrice());
				fireTableCellUpdated(rowIndex, i);
				break;

		
			}

	}

}
