package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Utility.RoundedBorder;

public class Order_Panel {
	private JFrame frame;
	private JTable tblorder;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JComboBox<String> Jcombo_destination;
	private JLabel lbl_transporation, lblTransportationFees, lbldestination, lblorder;
	private JLabel lblorder_id;
	private JPanel panel_customer, panel_orderlist, panel_order;
	private JScrollPane scrollpane_orderlist;
	private JTextField txt_searchorder;
	private JLabel lbl_searchorder;
	private JComboBox<String> Jcombo_destination_1;
	private JLabel lbldestination_1;
	private JLabel lblNewLabel_1;
	private JLabel lblOrderId;
	private JButton btnDone;
	private JButton btnDelete;
	private JButton btnNewButton;
	private JPanel panel;
	private JTextField txtc_name;
	private JTextField txtc_phone;
	private JButton btnClear;
	JTextArea txtc_address;
	private JButton btnUpdate;
	private JButton btnRemove;

	public Order_Panel(JFrame frame) {
		this.frame = frame;
		initialize();
		properties();
		addComponents();
		setTableDesign();

		this.frame.revalidate();
		this.frame.repaint();

	}

	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("OrderID");
		dtm.addColumn("CustomerName");
		dtm.addColumn("Phone");
		dtm.addColumn("Destination");
		dtm.addColumn("Date");
		dtm.addColumn("Transportation Fees");
		this.tblorder.setModel(dtm);
	}

	private void initialize() {
		// frame = new JFrame();
		panel_customer = new JPanel();
		panel_order = new JPanel();
		panel_orderlist = new JPanel();
		tblorder = new JTable();

		lbl_transporation = new JLabel();
		lbl_transporation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldestination = new JLabel();
		lblorder = new JLabel();
		lblorder_id = new JLabel();
		lblTransportationFees = new JLabel();
		Jcombo_destination = new JComboBox<>();
		scrollpane_orderlist = new JScrollPane();
		lbl_searchorder = new JLabel();
		txt_searchorder = new JTextField();
		txt_searchorder.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	private void properties() {

//		frame.setTitle("Order Form");
//		frame.setBounds(0, 0, 1344, 794);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		// panel_customer.setBorder();

		// Border orderTitleBorder = BorderFactory.createTitledBorder("Order Form");
		panel_order.setBackground(new Color(255, 255, 204));
		panel_order.setBounds(200, 0, 1144, 310);
		panel_order.setLayout(null);
		// panel_order.setBorder(orderTitleBorder);

		lblorder_id.setText("OrderId");
		lblorder_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblorder_id.setBounds(477, 10, 86, 33);

		lbldestination.setText("Destination -");
		lbldestination.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbldestination.setBounds(477, 70, 125, 40);

		lblTransportationFees.setText("Fee -");
		lblTransportationFees.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTransportationFees.setBounds(477, 251, 60, 40);

		// String city[] = new String[] { "KyalGaung", "Musal", "Mandalay", "Yangon" };
		Jcombo_destination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Jcombo_destination.setBounds(650, 71, 272, 40);

		lbl_transporation.setBackground(new Color(0, 0, 0));
		lbl_transporation.setForeground(new Color(0, 0, 0));
		lbl_transporation.setBounds(536, 251, 146, 40);

		// panel_orderlist.setBackground(new Color(30, 144, 255));
		panel_orderlist.setBounds(200, 310, 1144, 430);
		panel_orderlist.setBorder(new RoundedBorder(20));
		panel_orderlist.setLayout(null);

		// scrollPane.setBounds(10, 46, 1110, 370);

		lbl_searchorder.setText("OrderId");
		lbl_searchorder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_searchorder.setBounds(849, 13, 72, 40);

		txt_searchorder.setBounds(941, 10, 203, 40);

		tblorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblorder.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

		scrollpane_orderlist.setViewportView(tblorder);
		scrollpane_orderlist.setBounds(10, 63, 1110, 343);

	}

	private void addComponents() {
		frame.getContentPane().add(panel_order);
		frame.getContentPane().add(panel_orderlist);

		panel_order.add(lblorder_id);
		panel_order.add(lbldestination);
		panel_order.add(Jcombo_destination);
		panel_order.add(lblTransportationFees);
		panel_order.add(lbl_transporation);

		lblOrderId = new JLabel("order_ 01");
		lblOrderId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrderId.setBounds(573, 13, 159, 28);
		panel_order.add(lblOrderId);

		panel = new JPanel();
		panel.setBounds(477, 134, 446, 98);
		panel_order.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnNewButton = new JButton("Add Item");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(976, 71, 125, 40);
		panel_order.add(btnNewButton);

		btnDelete = new JButton("Delete Item");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(976, 134, 125, 40);
		panel_order.add(btnDelete);

		btnDone = new JButton("Done");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDone.setBounds(976, 252, 125, 40);
		panel_order.add(btnDone);

		JLabel lblc_name_1 = new JLabel();
		lblc_name_1.setText("Name");
		lblc_name_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_name_1.setBounds(56, 70, 98, 40);
		panel_order.add(lblc_name_1);

		txtc_name = new JTextField();
		txtc_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtc_name.setColumns(10);
		txtc_name.setBounds(165, 71, 262, 40);
		panel_order.add(txtc_name);

		JLabel lblc_phone_1 = new JLabel();
		lblc_phone_1.setText("Phone");
		lblc_phone_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_phone_1.setBounds(56, 134, 98, 40);
		panel_order.add(lblc_phone_1);

		txtc_phone = new JTextField();
		txtc_phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtc_phone.setColumns(10);
		txtc_phone.setBounds(165, 134, 262, 40);
		panel_order.add(txtc_phone);

		JLabel lblc_address_1 = new JLabel();
		lblc_address_1.setText("Address");
		lblc_address_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblc_address_1.setBounds(56, 192, 98, 40);
		panel_order.add(lblc_address_1);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(976, 192, 125, 40);
		panel_order.add(btnClear);

		Border border = BorderFactory.createLineBorder(SystemColor.activeCaptionBorder);
		txtc_address = new JTextArea();
		txtc_address.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		txtc_address.setBounds(165, 197, 262, 94);
		txtc_address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_order.add(txtc_address);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(976, 252, 125, 40);
		panel_order.add(btnUpdate);

		panel_orderlist.add(scrollpane_orderlist);
		panel_orderlist.add(lbl_searchorder);
		panel_orderlist.add(txt_searchorder);

		txt_searchorder.setColumns(10);

		Jcombo_destination_1 = new JComboBox<String>();
		Jcombo_destination_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Jcombo_destination_1.setBounds(491, 13, 203, 40);
		panel_orderlist.add(Jcombo_destination_1);

		lbldestination_1 = new JLabel();
		lbldestination_1.setText("Destination -");
		lbldestination_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldestination_1.setBounds(360, 14, 121, 38);
		panel_orderlist.add(lbldestination_1);

		lblNewLabel_1 = new JLabel("Filter by:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(244, 16, 106, 32);
		panel_orderlist.add(lblNewLabel_1);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(53, 13, 125, 40);
		panel_orderlist.add(btnRemove);

	}

	public JTextField getTxtc_name() {
		return txtc_name;
	}

	public JTextField getTxtc_phone() {
		return txtc_phone;
	}

	public JTextArea getTxtc_address() {
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

	public JLabel getLblOrderId() {
		return lblOrderId;
	}

	public JComboBox getJcombo_destination_1() {
		return Jcombo_destination_1;
	}

	public JPanel getPanel_Package() {
		return panel;
	}

	public JTable getTable() {
		// TODO Auto-generated method stub
		return tblorder;
	}

	public JPanel getPanelOrder() {
		return panel_order;
	}

	public JPanel getPanelCustomer() {
		return panel_customer;
	}

	public JPanel getPanelOrderList() {
		return panel_orderlist;
	}

	public JButton getBtnClear() {
		return btnClear;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public JButton getBtnRemove() {
		return btnRemove;
	}
}
