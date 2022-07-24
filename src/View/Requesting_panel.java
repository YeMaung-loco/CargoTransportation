package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


public class Requesting_panel extends JPanel {
	private JTextField textField;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tblrequesting;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Requesting_panel() {
		setBackground(new Color(102, 102, 204));
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
		dtm.addColumn("Approve");
		
		this.tblrequesting.setModel(dtm);
	}
	
		public void initialize() {
		setLayout(null);
		
		lblNewLabel = new JLabel("Requesting Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(480, 10, 183, 35);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Filter by OrderId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(780, 73, 150, 25);
		add(lblNewLabel_1);
		tblrequesting=new JTable();
		
		textField = new JTextField();
		textField.setBounds(942, 71, 172, 35);
		add(textField);
		textField.setColumns(10);
		
		tblrequesting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblrequesting.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 128, 1093, 571);
		scrollPane.setViewportView(tblrequesting);
		add(scrollPane);

	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTable getTblrequesting() {
		return tblrequesting;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JTextField getTextField() {
		return textField;
	}
}
