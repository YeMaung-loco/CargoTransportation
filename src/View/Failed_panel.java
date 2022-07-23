package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


public class Failed_panel extends JPanel {
	private JTextField txtSearch;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tblfail;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JButton btnExport;

	/**
	 * Create the panel.
	 */
	public Failed_panel() {
		setBackground(new Color(255, 102, 102));
		initialize();
		setTableDesign();
	}
	
	
	public void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("OrderID");
		dtm.addColumn("CustomerName");
		dtm.addColumn("Destination");
		dtm.addColumn("Date");
		dtm.addColumn("Transportation Fees");
		dtm.addColumn("View Detail");
	
		this.tblfail.setModel(dtm);
	}
	
		public void initialize() {
		setLayout(null);
		
		btnExport=new JButton("Export to Excel");
		btnExport.setBounds(20, 73, 150, 35);
		add(btnExport);
		
		lblNewLabel = new JLabel("Failed Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(480, 10, 183, 35);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(846, 73, 70, 25);
		add(lblNewLabel_1);
		tblfail=new JTable();
		
		txtSearch = new JTextField();
		txtSearch.setBounds(942, 71, 172, 35);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 128, 1093, 572);
		scrollPane.setViewportView(tblfail);
		add(scrollPane);

	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTable getTblfail() {
		return tblfail;
	}
	public JTextField getTxtSearch() {
		return txtSearch;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JButton getbtnExport() {
		return btnExport;
	}
}
