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

public class order {

	private JFrame frame;
	private JTextField txtc_name, txtc_phone, txtc_address, txt_weight;

	private JTable tblorder;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JComboBox Jcombo_destination;
	private JLabel lbl_transporation, lblc_name, lblNewLabel, lblTransportationFees, lblWeightKg, lbldestination,
			lblorder, lbl_customersave_1, lblc_address, lblc_phone, lbl_ordersave;
	private JPanel panel_customer, panel_orderlist, panel_ordersave, panel_order, panel_customersave;
	private JScrollPane scrollpane_orderlist;
	private JTextField txt_searchorder;
	private JLabel lbl_searchorder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					order window = new order();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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
		dtm.addColumn("Transportation Fees");
		this.tblorder.setModel(dtm);
	}

	private void initialize() {
		frame = new JFrame();
		panel_customer = new JPanel();
		panel_customersave = new JPanel();
		panel_order = new JPanel();
		panel_orderlist = new JPanel();
		panel_ordersave = new JPanel();

		lbl_customersave_1 = new JLabel();
		lbl_ordersave = new JLabel();
		lbl_transporation = new JLabel();
		lbl_transporation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel = new JLabel();
		lblc_name = new JLabel();
		lblc_phone = new JLabel();
		lblc_address = new JLabel();
		lbldestination = new JLabel();
		lblorder = new JLabel();
		lblWeightKg = new JLabel();
		lblorder = new JLabel();
		lblTransportationFees = new JLabel();

		txtc_name = new JTextField();
		txtc_address = new JTextField();
		txtc_phone = new JTextField();
		txt_weight = new JTextField();
		Jcombo_destination = new JComboBox<>();
		scrollpane_orderlist = new JScrollPane();
		lbl_searchorder = new JLabel();
		txt_searchorder = new JTextField();
		txt_searchorder.setFont(new Font("Tahoma", Font.PLAIN, 17));
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

		panel_customersave.setLayout(null);
		panel_customersave.setBounds(327, 303, 120, 41);

		lbl_customersave_1.setText("Save");
		lbl_customersave_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_customersave_1.setBounds(32, 7, 55, 26);

		panel_order.setBackground(new Color(0, 139, 139));
		panel_order.setBounds(572, 0, 572, 370);
		panel_order.setLayout(null);

		lblorder.setText("Order Input Form");
		lblorder.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblorder.setBounds(172, 10, 227, 33);

		lbldestination.setText("Destination City");
		lbldestination.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbldestination.setBounds(56, 88, 159, 40);

		lblWeightKg.setText("Package Weight");
		lblWeightKg.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWeightKg.setBounds(56, 169, 159, 40);

		txt_weight.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_weight.setColumns(10);
		txt_weight.setBounds(275, 170, 227, 40);

		lblTransportationFees.setText("Transportation Fees");
		lblTransportationFees.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTransportationFees.setBounds(56, 237, 199, 40);

		Jcombo_destination.setFont(new Font("Tahoma", Font.BOLD, 17));
		String city[] = new String[] { "KyalGaung", "Musal", "Mandalay", "Yangon" };
		Jcombo_destination.setModel(new DefaultComboBoxModel(city));

		Jcombo_destination.setBounds(275, 88, 227, 40);

		panel_ordersave.setBounds(374, 303, 120, 41);
		panel_ordersave.setLayout(null);

		lbl_ordersave.setText("Save");
		lbl_ordersave.setBounds(32, 7, 56, 26);
		lbl_ordersave.setFont(new Font("Tahoma", Font.BOLD, 21));
		lbl_ordersave.setLabelFor(panel_ordersave);

		lbl_transporation.setBackground(Color.LIGHT_GRAY);
		lbl_transporation.setForeground(Color.LIGHT_GRAY);
		lbl_transporation.setBounds(275, 237, 227, 40);

		panel_orderlist.setBackground(new Color(30, 144, 255));
		panel_orderlist.setBounds(0, 370, 1144, 370);
		panel_orderlist.setLayout(null);

		scrollpane_orderlist.setBounds(0, 63, 1144, 307);
		
		lbl_searchorder.setText("Search");
		lbl_searchorder.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_searchorder.setBounds(728, 17, 79, 36);
		
		
		txt_searchorder.setBounds(854, 17, 212, 36);

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
		panel_customersave.add(lbl_customersave_1);
		panel_customer.add(panel_customersave);

		panel_order.add(lblorder);
		panel_order.add(lbldestination);
		panel_order.add(lblWeightKg);
		panel_order.add(Jcombo_destination);
		panel_order.add(lblTransportationFees);
		panel_order.add(lbl_transporation);
		panel_order.add(txt_weight);
		panel_ordersave.add(lbl_ordersave);
		panel_order.add(panel_ordersave);
		panel_orderlist.add(scrollpane_orderlist);
		
		
		
		panel_orderlist.add(lbl_searchorder);
		
		
		panel_orderlist.add(txt_searchorder);
		txt_searchorder.setColumns(10);

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

	public JTextField getTxt_weight() {
		return txt_weight;
	}

	public JLabel getLbl_transporation() {
		return lbl_transporation;
	}
	public JPanel getPanel_customersave() {
		return panel_customersave;
	}
	public JPanel getPanel_ordersave() {
		return panel_ordersave;
	}
	public JLabel getLbl_searchorder() {
		return lbl_searchorder;
	}
	public JTextField getTxt_searchorder() {
		return txt_searchorder;
	}
}
