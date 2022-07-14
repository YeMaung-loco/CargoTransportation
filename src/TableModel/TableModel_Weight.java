package TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Weight;
import Model.Weight;

public class TableModel_Weight extends AbstractTableModel {

	private static final long serialVersionUID = -4026402599426071004L;
	List<Weight> weightList;
	String headerList[] = new String[] { "No", "Weight", "Price"};

	public TableModel_Weight(List<Weight> list) {
		weightList = list;
	}

	public TableModel_Weight() {

	}

	@Override
	public int getRowCount() {
		return weightList.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int col) {
		return headerList[col];
	}

	public void removeRow(int rowIndex) {
		weightList.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void insertRow(Weight weight) {
		weightList.add(weight);
		fireTableRowsInserted(weightList.size() - 1, weightList.size() - 1);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Weight entity = null;

		entity = weightList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return entity.getWeight_kg();
		case 2:
			return entity.getWeightprice();
		
		default:
			return "";
		}
	}

	public int getWeight_Id(int i) {
		Weight weight = weightList.get(i);
		return weight.getId();
	}

	

	public void setValueAt(Weight e, int rowIndex) {
		Weight weight = weightList.get(rowIndex);
		for (int i = 1; headerList.length > i; i++)
			switch (i) {
			case 1:
				weight.setWeight_kg(i);
				fireTableCellUpdated(rowIndex, i);
				break;

			case 2:
				weight.setWeightprice(i);
				fireTableCellUpdated(rowIndex, i);
				break;

		
			}

	}

}
