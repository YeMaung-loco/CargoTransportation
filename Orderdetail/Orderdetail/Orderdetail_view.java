package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;

public class Orderdetail_view {

	private JFrame frame;
	private JPanel panel_orderdetails;
	private JTextField txt_orderid,txt_orderprice,txt_name,txt_phone,txt_address,txt_payment,txt_date;
	
	private JLabel lblorder,lblorderid,lblprice,lblway,lblpayment,lblname,lblphone,lbladdress,lbldate;
	private JLabel lbl_setorderid,lbl_setprice,lbl_setway,lbl_setpayment,lbl_setname,lbl_setphone,lbl_setaddress,lbl_setdate;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JTable tbl_orderdetail;
	private JButton btnupdate,btndelete,btnedit,btnback;
	
	private JComboBox comboWay;
	private JScrollPane scrollPane;
	
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Orderdetail_view window = new Orderdetail_view();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public Orderdetail_view() {
//		System.out.println("order detail");
//		//this.frame=frame;
//		initialize();
//		addComponents();
//		setTableDesign();
//		
//		//frame.revalidate();
//		//frame.repaint();
//
//	}
	public Orderdetail_view() {
		System.out.println("order detail");
		initialize();
		setTableDesign();
		addProperties();
		addComponents();
		frame.revalidate();
		frame.repaint();
		}
	private void setTableDesign() {
		dtm.addColumn("No.");
		dtm.addColumn("ID");

		this.tbl_orderdetail.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		panel_orderdetails = new JPanel();
		txt_orderid=new JTextField();
		txt_orderprice=new JTextField();
		txt_name=new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_phone=new JTextField();
		txt_address=new JTextField();
		txt_address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_payment=new JTextField();
		txt_payment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_date=new JTextField();
		txt_date.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblorder=new JLabel();
		lblorderid=new JLabel();
		lblprice=new JLabel();
		lblname=new JLabel();
		lblphone=new JLabel();
		lbladdress=new JLabel();
		lblpayment=new JLabel();
		lbldate=new JLabel();
		lblway=new JLabel();
		
		lbl_setorderid=new JLabel();
		lbl_setprice=new JLabel();
		lbl_setname=new JLabel();
		lbl_setaddress=new JLabel();
		lbl_setpayment=new JLabel();
		lbl_setdate=new JLabel();
		lbl_setway=new JLabel();
		lbl_setphone=new JLabel();
		comboWay = new JComboBox();
		comboWay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane=new JScrollPane();
		tbl_orderdetail=new JTable();
		panel_orderdetails.add(txt_orderid);
		btnupdate=new JButton();
		btndelete=new JButton();
		btnedit=new JButton();
		btnback=new JButton();
		
	}
	
	
	private void addProperties() {
		frame.setBounds(0, 0, 1300, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.validate();
		frame.repaint();
		panel_orderdetails.setBorder(null);
		panel_orderdetails.setBackground(new Color(0, 139, 139));
		panel_orderdetails.setBounds(200, 10, 1076, 735);
		panel_orderdetails.setLayout(null);
		
		
		lblorder.setText("Order Details");
		lblorder.setBounds(451, 20, 140, 43);
		lblorder.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		lblorderid.setText("Order id");
		lblorderid.setBounds(30, 123, 124, 32);
		lblorderid.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		
		txt_orderid.setBounds(259, 123, 202, 36);
		txt_orderid.setBackground(Color.WHITE);
		txt_orderid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txt_orderid.setColumns(10);
		
		
		
		lbl_setorderid.setText("c001");
		lbl_setorderid.setBounds(259, 127, 202, 36);
		lbl_setorderid.setFont(new Font("Tahoma", Font.PLAIN, 17));
	
		
		lblprice.setText("Price");
		lblprice.setBounds(30, 197, 124, 32);
		lblprice.setFont(new Font("Tahoma", Font.BOLD, 17));
	
		
		
		txt_orderprice.setBounds(259, 197, 202, 36);
		txt_orderprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_orderprice.setColumns(10);
		
		
		lbl_setprice.setText("");
		lbl_setprice.setBounds(259, 201, 202, 36);
		lbl_setprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblway.setText("Way");
		lblway.setBounds(30, 272, 124, 32);
		lblway.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
	    lbl_setway.setText("");
		lbl_setway.setBounds(259, 276, 202, 36);
		lbl_setway.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		lblname.setText("Name");
		lblname.setBounds(630, 115, 124, 32);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		
		txt_name.setBounds(829, 115, 202, 36);
		txt_name.setColumns(10);
		
		
		lbl_setname.setText("");
		lbl_setname.setBounds(829, 119, 202, 36);
		lbl_setname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		lblphone.setText("Phone");
		lblphone.setBounds(630, 193, 124, 32);
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		txt_phone = new JTextField();
		txt_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_phone.setBounds(829, 193, 202, 36);
		txt_phone.setColumns(10);
		
		
		lbl_setphone.setText("");
		lbl_setphone.setBounds(829, 197, 202, 36);
		lbl_setphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		lbladdress.setText("Address");
		lbladdress.setBounds(630, 272, 124, 32);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 17));
	
		
		
		txt_address.setBounds(829, 272, 202, 36);
		txt_address.setColumns(10);
		
		
		lbl_setaddress.setText("");
		lbl_setaddress.setBounds(829, 276, 202, 36);
		lbl_setaddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
				
		lblpayment.setText("Payment");
		lblpayment.setBounds(30, 345, 124, 32);
		lblpayment.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		
		txt_payment.setBounds(259, 345, 202, 36);
		txt_orderid.setVisible(false);
		txt_payment.setColumns(10);
		txt_payment.setVisible(false);
		txt_name.setVisible(false);
		txt_address.setVisible(false);
		txt_phone.setVisible(false);
		txt_date.setVisible(false);
		txt_orderprice.setVisible(false);
		comboWay.setVisible(false);
		
		
	    lbl_setpayment.setText("");
		lbl_setpayment.setBounds(259, 349, 202, 36);
		lbl_setpayment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		lbldate.setText("Date");
		lbldate.setBounds(630, 345, 124, 32);
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		
		
		txt_date.setBounds(829, 345, 202, 36);
		txt_date.setColumns(10);
		
		
		lbl_setdate.setText("");
		lbl_setdate.setBounds(829, 349, 202, 36);
		lbl_setdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		

		
		
		
		scrollPane.setBounds(30, 408, 431, 302);
		
		
		
		tbl_orderdetail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbl_orderdetail.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 15));
		
		scrollPane.setViewportView(tbl_orderdetail);
		
		
	
		
		btnupdate.setText("Update");
		btnupdate.setBounds(648, 678, 100, 32);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		btndelete.setText("Delete");
		btndelete.setBounds(785, 678, 100, 32);
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		btnedit.setText("Edit");
		btnedit.setBounds(507, 678, 100, 32);
		btnedit.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		btnback.setText("Back");
		btnback.setBounds(924, 678, 100, 32);
		btnback.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		comboWay.setBounds(259, 280, 202, 36);
		
	}
	private void addComponents() {
		frame.getContentPane().add(panel_orderdetails);
		panel_orderdetails.add(lblorder);
		panel_orderdetails.add(lblorderid);
		panel_orderdetails.add(lbl_setorderid);
		panel_orderdetails.add(lblprice);
		panel_orderdetails.add(txt_orderprice);
		panel_orderdetails.add(lbl_setprice);
		panel_orderdetails.add(lblway);
		panel_orderdetails.add(lbl_setway);
		panel_orderdetails.add(lblname);
		panel_orderdetails.add(txt_name);
		panel_orderdetails.add(lbl_setname);
		panel_orderdetails.add(lblphone);
		panel_orderdetails.add(txt_phone);
		panel_orderdetails.add(lbl_setphone);
		panel_orderdetails.add(lbladdress);
		panel_orderdetails.add(txt_address);
		panel_orderdetails.add(lbl_setaddress);
		panel_orderdetails.add(lblpayment);
		panel_orderdetails.add(txt_payment);
		panel_orderdetails.add(lbl_setpayment);
		panel_orderdetails.add(lbldate);
		panel_orderdetails.add(txt_date);
		panel_orderdetails.add(lbl_setdate);
		panel_orderdetails.add(scrollPane);
		panel_orderdetails.add(btnupdate);
		panel_orderdetails.add(btndelete);
		panel_orderdetails.add(btnedit);
		panel_orderdetails.add(btnback);
		panel_orderdetails.add(comboWay);

		
		

	}
	public JTextField getTxt_orderid() {
		return txt_orderid;
	}
	public JTextField getTxt_orderprice() {
		return txt_orderprice;
	}
	public JComboBox getComboWay() {
		return comboWay;
	}
	public JTextField getTxt_payment() {
		return txt_payment;
	}
	public JTextField getTxt_name() {
		return txt_name;
	}
	public JTextField getTxt_phone() {
		return txt_phone;
	}
	public JTextField getTxt_address() {
		return txt_address;
	}
	public JTextField getTxt_date() {
		return txt_date;
	}
	public JLabel getLbl_setorderid() {
		return lbl_setorderid;
	}
	public JLabel getLbl_setprice() {
		return lbl_setprice;
	}
	public JLabel getLbl_setway() {
		return lbl_setway;
	}
	public JLabel getLbl_setname() {
		return lbl_setname;
	}
	public JLabel getLbl_setphone() {
		return lbl_setphone;
	}
	public JLabel getLbl_setaddress() {
		return lbl_setaddress;
	}
	public JLabel getLbl_setpayment() {
		return lbl_setpayment;
	}
	public JLabel getLbl_setdate() {
		return lbl_setdate;
	}
	public JButton getBtnupdate() {
		return btnupdate;
	}
	public JButton getBtndelete() {
		return btndelete;
	}
	public JButton getBtnedit() {
		return btnedit;
	}
	public JButton getBtnback() {
		return btnback;
	}
	public JTable getTbl_orderdetail() {
		return tbl_orderdetail;
	}
	public JPanel getPanel_orderdetails() {
		return panel_orderdetails;
	}
}
