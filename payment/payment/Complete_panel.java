package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


public class Complete_panel extends JPanel {
	private JTextField textField;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tblrequest;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lbl_completeOrder;

	/**
	 * Create the panel.
	 */
	public Complete_panel() {
		setBackground(new Color(144, 238, 144));
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
		dtm.addColumn("Viewdetail");
		this.tblrequest.setModel(dtm);
	}
	
		public void initialize() {
		setLayout(null);
		
		lbl_completeOrder = new JLabel("Completed Order");
		lbl_completeOrder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_completeOrder.setBounds(480, 10, 183, 35);
		add(lbl_completeOrder);
		
		lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(846, 73, 70, 25);
		add(lblNewLabel);
		tblrequest=new JTable();
		
		textField = new JTextField();
		textField.setBounds(942, 71, 172, 35);
		add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 128, 1093, 572);
		scrollPane.setViewportView(tblrequest);
		add(scrollPane);

	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTextField getSearch() {
		return textField;
	}
	public JTable getTblcomplete() {
		return tblrequest;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel;
	}
	public JLabel getLbl_completeOrder() {
		return lbl_completeOrder;
	}
}
