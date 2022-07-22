package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Deliveryman_View {

	private JFrame frame;
	private JTextField textField;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tbldelivery;
	private JLabel lbltitle,lblfilter,lblsearchDeliveryname;
	private JTextField txtDeliveryname;
	private JButton btnconfirm;
	private JScrollPane scrollPane;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deliveryman_View window = new Deliveryman_View();
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
	public Deliveryman_View() {
		initialize();
		setTableDesign();
	}
	
	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("Staff Id");
		dtm.addColumn("Delivery Name");
		this.tbldelivery.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel = new JPanel();
		tbldelivery=new JTable();
		scrollPane=new JScrollPane();
		lbltitle=new JLabel();
		lblfilter=new JLabel();
		lblsearchDeliveryname=new JLabel();
		txtDeliveryname=new JTextField();
		btnconfirm=new JButton();
		
		frame.setBounds(0, 0, 625, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		panel.setBounds(25, 43, 555, 675);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tbldelivery=new JTable();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 129, 516, 502);
		panel.add(scrollPane);
		scrollPane.setViewportView(tbldelivery);
		
		lbltitle.setText("Delivery Staff List");
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltitle.setBounds(201, 10, 195, 29);
		panel.add(lbltitle);
		
		lblfilter.setText("Filter by:");
		lblfilter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblfilter.setBounds(66, 77, 83, 29);
		panel.add(lblfilter);
		
		lblsearchDeliveryname.setText(" Delivery Name");
		lblsearchDeliveryname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsearchDeliveryname.setBounds(236, 77, 122, 30);
		panel.add(lblsearchDeliveryname);
		
	
		txtDeliveryname.setBounds(384, 80, 152, 29);
		panel.add(txtDeliveryname);
		txtDeliveryname.setColumns(10);
		
		btnconfirm.setText("Confirm");
		btnconfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnconfirm.setBounds(414, 641, 122, 24);
		panel.add(btnconfirm);
	}
	public JTable gettblDelivery() {
		return tbldelivery;
	}
	public JPanel getpanel() {
		return panel;
		
	}
	public JButton getbtnconfirm() {
		return btnconfirm;
	}
	public JTextField getTxtDeliveryname() {
		return txtDeliveryname;
	}
}
