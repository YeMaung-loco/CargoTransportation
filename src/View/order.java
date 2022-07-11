package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class order {
	private JFrame frame;
	private JTextField txtc_name, txtc_phone, txtc_address;
	private JTable tblorder;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JComboBox Jcombo_destination;
	private JLabel lbl_transporation, lblc_name, lblNewLabel, lblTransportationFees, lbldestination,
			lblorder, lblc_address, lblc_phone;
	private JLabel lblorder_id;
	private JPanel panel_customer, panel_orderlist, panel_order;
	private JScrollPane scrollpane_orderlist;
	private JTextField txt_searchorder;
	private JLabel lbl_searchorder;
	private JComboBox<Object> Jcombo_destination_1;
	private JLabel lbldestination_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnDone;
	private JButton btnDelete;
	private JButton btnNewButton;

	public order() {
		initialize();
		properties();
		addComponents();
		setTableDesign();

	}

	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("OrderID");
		dtm.addColumn("CustomerName");
		dtm.addColumn("Phone");
		dtm.addColumn("Destination");
		dtm.addColumn("Package");
		dtm.addColumn("Total Package");
		dtm.addColumn("Transportation Fees");
		this.tblorder.setModel(dtm);
	}

	private void initialize() {
		frame = new JFrame();
		panel_customer = new JPanel();
		panel_order = new JPanel();
		panel_orderlist = new JPanel();
		lbl_transporation = new JLabel();
		lbl_transporation.setText("23000");
		lbl_transporation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel = new JLabel();
		lblc_name = new JLabel();
		lblc_phone = new JLabel();
		lblc_address = new JLabel();
		lbldestination = new JLabel();
		lblorder = new JLabel();
		lblorder_id = new JLabel();
		lblTransportationFees = new JLabel();

		txtc_name = new JTextField();
		txtc_address = new JTextField();
		txtc_phone = new JTextField();
		Jcombo_destination = new JComboBox<>();
		scrollpane_orderlist = new JScrollPane();
		lbl_searchorder = new JLabel();
		txt_searchorder = new JTextField();
		txt_searchorder.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void properties() {
		frame.setTitle("Order Form");
		frame.setBounds(0, 0, 1200, 794);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel_customer = new JPanel();
		panel_customer.setBackground(Color.ORANGE);
		panel_customer.setBounds(0, 0, 572, 370);
		panel_customer.setLayout(null);

		lblc_name.setText("Customer Name");
		lblc_name.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_name.setBounds(10, 89, 159, 40);

		lblNewLabel.setText("Customer Input Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(164, 10, 243, 35);

		txtc_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtc_name.setBounds(229, 89, 227, 40);
		txtc_name.setColumns(10);

		lblc_phone.setText("Customer Phone");
		lblc_phone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_phone.setBounds(10, 167, 159, 40);

		txtc_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtc_phone.setColumns(10);
		txtc_phone.setBounds(229, 167, 227, 40);

		lblc_address.setText("Customer Address");
		lblc_address.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_address.setBounds(10, 244, 183, 40);

		txtc_address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtc_address.setColumns(10);
		txtc_address.setBounds(229, 244, 227, 40);

		panel_order.setBackground(new Color(0, 139, 139));
		panel_order.setBounds(572, 0, 572, 370);
		panel_order.setLayout(null);

		lblorder_id.setText("OrderId");
		lblorder_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblorder_id.setBounds(195, 10, 86, 33);

		lbldestination.setText("Destination City");
		lbldestination.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbldestination.setBounds(56, 53, 159, 40);

		lblTransportationFees.setText("Transportation Fees");
		lblTransportationFees.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTransportationFees.setBounds(56, 237, 199, 40);

		Jcombo_destination.setFont(new Font("Tahoma", Font.BOLD, 17));
		String city[] = new String[] { "KyalGaung", "Musal", "Mandalay", "Yangon" };

		Jcombo_destination.setBounds(275, 53, 227, 40);

		lbl_transporation.setBackground(Color.LIGHT_GRAY);
		lbl_transporation.setForeground(Color.LIGHT_GRAY);
		lbl_transporation.setBounds(275, 237, 227, 40);

		panel_orderlist.setBackground(new Color(30, 144, 255));
		panel_orderlist.setBounds(0, 370, 1144, 370);
		panel_orderlist.setLayout(null);

		scrollpane_orderlist.setBounds(0, 63, 1144, 307);
		
		lbl_searchorder.setText("Search OrderId");
		lbl_searchorder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_searchorder.setBounds(739, 13, 142, 40);
		
		
		txt_searchorder.setBounds(891, 10, 212, 40);

		tblorder = new JTable();
//		{
//			
//			    @Override
//			       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//			           Component component = super.prepareRenderer(renderer, row, column);
//			           int rendererWidth = component.getPreferredSize().width;
//			           TableColumn tableColumn = getColumnModel().getColumn(column);
//			           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
//			           return component;
//			        }
//			    
//		};
//		tblorder.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblorder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollpane_orderlist.setViewportView(tblorder);

	}

	private void addComponents() {
		frame.getContentPane().add(panel_customer);
		frame.getContentPane().add(panel_order);
		frame.getContentPane().add(panel_orderlist);

		panel_customer.add(lblc_address);
		panel_customer.add(lblNewLabel);
		panel_customer.add(lblc_name);
		panel_customer.add(lblc_phone);
		panel_customer.add(txtc_name);
		panel_customer.add(txtc_address);
		panel_customer.add(txtc_phone);

		panel_order.add(lblorder_id);
		panel_order.add(lbldestination);
		panel_order.add(Jcombo_destination);
		panel_order.add(lblTransportationFees);
		panel_order.add(lbl_transporation);
		
		lblNewLabel_2 = new JLabel("order_ 01");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(291, 13, 111, 28);
		panel_order.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 113, 446, 124);
		panel_order.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("Add Item");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(56, 301, 111, 40);
		panel_order.add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(235, 301, 111, 40);
		panel_order.add(btnDelete);
		
		btnDone = new JButton("Done");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDone.setBounds(391, 301, 111, 40);
		panel_order.add(btnDone);
		panel_orderlist.add(scrollpane_orderlist);
		
		
		
		panel_orderlist.add(lbl_searchorder);
		
		
		panel_orderlist.add(txt_searchorder);
		txt_searchorder.setColumns(10);
		
		Jcombo_destination_1 = new JComboBox<Object>();
		Jcombo_destination_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Jcombo_destination_1.setBounds(491, 13, 203, 40);
		panel_orderlist.add(Jcombo_destination_1);
		
		lbldestination_1 = new JLabel();
		lbldestination_1.setText("Destination City");
		lbldestination_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldestination_1.setBounds(315, 15, 166, 38);
		panel_orderlist.add(lbldestination_1);
		
		lblNewLabel_1 = new JLabel("Filter by:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1.setBounds(199, 15, 106, 32);
		panel_orderlist.add(lblNewLabel_1);

	}

	public JTextField getTxtc_name() {
		return txtc_name;
	}

	public JTextField getTxtc_phone() {
		return txtc_phone;
	}

	public JTextField getTxtc_address() {
		return txtc_address;
	}

	public JComboBox getJcombo_destination() {
		return Jcombo_destination;
	}

	public JLabel getLbl_transporation() {
		return lbl_transporation;
	}
	
	public JLabel getLbl_searchorder() {
		return lbl_searchorder;
	}
	public JTextField getTxt_searchorder() {
		return txt_searchorder;
	}
	public JButton getBtnDone() {
		return btnDone;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
	public JComboBox getJcombo_destination_1() {
		return Jcombo_destination_1;
	}
}
