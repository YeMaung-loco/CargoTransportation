package View;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Delivery_View {

	private JFrame frame;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable tblorder;

	private JLabel lbltitle, lblfilter, lblsearchOrderid, lblsearchDestination;
	JLabel deselectLable;
	private JTextField txtOrderid, txtDestination;
    private JComboBox combodestination;
	private JPanel panel;
	JPanel panel_deselect;
	private JButton btnSelectdelivery ,btnDeselect;
	private JScrollPane scrollPane;

	public Delivery_View(JFrame container) {
		this.frame = container;
		initialize();
		setTableDesign();

		frame.revalidate();
		frame.repaint();
	}

	private void setTableDesign() {
		dtm.addColumn("Selected");
		dtm.addColumn("No.");
		dtm.addColumn("OrderID");
		dtm.addColumn("CustomerName");
		dtm.addColumn("Phone");
		dtm.addColumn("Destination");
		dtm.addColumn("Date");
		dtm.addColumn("Transportation Fees");
		this.tblorder.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
		panel = new JPanel();
		lbltitle = new JLabel();
		lblfilter = new JLabel();
		lblsearchOrderid = new JLabel();
		lblsearchDestination = new JLabel();
		txtOrderid = new JTextField();
		combodestination=new JComboBox();
		btnSelectdelivery = new JButton();
		scrollPane = new JScrollPane();
		tblorder = new JTable();

		btnDeselect=new JButton();
		/*
		 * frame.setBounds(0, 0, 1300, 790);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.getContentPane().setLayout(null);
		 */

		panel = new JPanel();
		panel.setBounds(200, 0, 1144, 740);

		panel.setLayout(null);

		lbltitle.setText("Order Assign");
		lbltitle.setBounds(473, 10, 137, 35);
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lbltitle);

		lblfilter.setText("Filer by:");
		lblfilter.setBounds(319, 79, 86, 27);
		lblfilter.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblfilter);

		lblsearchOrderid.setText("OrderId");
		lblsearchOrderid.setBounds(850, 82, 66, 23);
		lblsearchOrderid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblsearchOrderid);

		txtOrderid = new JTextField();
		txtOrderid.setBounds(920, 79, 180, 35);
		txtOrderid.setColumns(10);
		panel.add(txtOrderid);
		
		tblorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblorder.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));

		scrollPane.setBounds(30, 143, 1070, 531);
		panel.add(scrollPane);
		scrollPane.setViewportView(tblorder);

		btnSelectdelivery.setText("Assign");
		btnSelectdelivery.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSelectdelivery.setBounds(950, 684, 151, 33);
		panel.add(btnSelectdelivery);

//		txtDestination = new JTextField();
//		txtDestination.setColumns(10);
//		txtDestination.setBounds(524, 79, 200, 35);
//		panel.add(txtDestination);
		combodestination.setFont(new Font("Tahoma",Font.PLAIN,17));
		combodestination.setBounds(524,79,200,35);
		panel.add(combodestination);
		

		lblsearchDestination = new JLabel("Destination");
		lblsearchDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsearchDestination.setBounds(428, 82, 86, 23);
		panel.add(lblsearchDestination);

		ImageIcon account_icon = new ImageIcon("resource\\unselect.png");
		deselectLable = new JLabel(account_icon);
		deselectLable.setToolTipText("Unselect all order");
		deselectLable.setBounds(0,0, 33, 33);
		panel_deselect = new JPanel();
		panel_deselect.setLayout(null);
		panel_deselect.setBounds(22, 79, 33, 33);
		
	//	btnDeselect.setText("Deselect");
	//	btnDeselect.setBounds(22, 79, 100, 32);
	//	panel.add(btnDeselect);
	//	panel_deselect.add(deselectLable);

	//	panel.add(panel_deselect);

		if (frame != null)
			frame.getContentPane().add(panel);
	}

	

	public JTextField getTxtOrderid() {
		return txtOrderid;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JTable getTblorder() {
		return tblorder;
	}

	public JButton getBtnSelectdelivery() {
		return btnSelectdelivery;
	}

	public JPanel getPanel_Deselect() {
		return panel_deselect;
	}
	
	public JButton getBtnDeselect() {
		return btnDeselect;
	}
	public JComboBox getCombo() {
		return combodestination;
	}

}
