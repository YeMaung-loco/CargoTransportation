package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Delivery_View {

	private JFrame frame;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tblorder;
	private JTextField textField;
	private JLabel lbltitle,lblfilter,lblsearchOrderid,lblsearchDestination;
	private JTextField txtOrderid,txtDestination;
	private JTextField txtOrderid_1;

	private JPanel panel;
	private JButton btnSelectdelivery;
	private JScrollPane scrollPane;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delivery_View window = new Delivery_View();
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
	public Delivery_View() {
		initialize();
		setTableDesign();
	}
	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("Order Id");
		dtm.addColumn("Destination");
		this.tblorder.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		lbltitle=new JLabel();
		lblfilter=new JLabel();
		lblsearchOrderid=new JLabel();
		lblsearchDestination=new JLabel();
		txtOrderid=new JTextField();
		txtDestination=new JTextField();
		btnSelectdelivery=new JButton();
		scrollPane=new JScrollPane();
		tblorder=new JTable();
		
		frame.setBounds(0, 0, 1300, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(200, 10, 1076, 736);
		frame.getContentPane().add(panel);
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
		lblsearchOrderid.setBounds(785, 82, 66, 23);
		lblsearchOrderid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblsearchOrderid);
		
		txtOrderid= new JTextField();
		txtOrderid.setBounds(866, 79, 200, 35);
		txtOrderid.setColumns(10);
		panel.add(txtOrderid);
		
	
		scrollPane.setBounds(10, 143, 1056, 531);
		panel.add(scrollPane);
		scrollPane.setViewportView(tblorder);
		
		btnSelectdelivery.setText("Assign");
		btnSelectdelivery.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSelectdelivery.setBounds(920, 684, 146, 33);
		panel.add(btnSelectdelivery);
		
		txtDestination = new JTextField();
		txtDestination.setColumns(10);
		txtDestination.setBounds(524, 79, 200, 35);
		panel.add(txtDestination);
		
		lblsearchDestination = new JLabel("Destination");
		lblsearchDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsearchDestination.setBounds(428, 82, 86, 23);
		panel.add(lblsearchDestination);
	}
	public JTextField getTxtDestination() {
		return txtDestination;
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
}
