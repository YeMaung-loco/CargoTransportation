package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Model.Package;
import Model.Role;
import Model.Customer;
import Model.Department;
import Model.Staff;
import Model.Destination;
import Model.Order;
import Service.Customer_service;
import Service.Department_service;
import Service.DestinationPrice_service;
import Service.Order_service;
import Service.Package_service;
import Service.Staff_Service;
import TableModel.TableModel_Staff;
import View.Office_view;
import View.Order_Panel;
import View.Orderdetail_view;
import View.SetPrice_Panel;
import Model.Destination;
import TableModel.TableModel_Order;
import TableModel.TableModel_Orderdetail;

public class Orderdetail_controller implements ActionListener {

	List<Destination> wayList;
	OrderManage_controller order_controller;
	Orderdetail_view odetail;
	Staff_Service staffservice;
	Order_service orderservice;
	Customer_service customerservice;
	Package_service packageservice;
	Department_service department_Service;
	DestinationPrice_service destination_Service;
	TableModel_Orderdetail tblOrderdetail;
	Customer customer;
	Destination destination;
	Order order;
	Staff staff;
	Package pack;
	JFrame frame;
	JPanel viewdetail;
	JButton btnDelete, btnEdit, btnUpdate, btnBack;
	JLabel lblorderid, lblprice, lblway, lblpayment, lblname, lblphone, lbladdress, lbldate;
	JTextField txtprice, txtpayment, txtname, txtphone, txtaddress, txtdate;
	JComboBox<String> comboWay;
	Office_view office_view;
	JTable table;
	TableModel_Orderdetail tblModelorder;
	Office_view navigationPanel;
	SetPrice_Panel setPricepanel;
	int cus_id;
	int orderid;
	String order_no;
	String temp_no;
	TableRowSorter<TableModel_Orderdetail> sorter;
	//List<Package> packageList = new ArrayList<Package>();

	public Orderdetail_controller() {
		// this.frame = frame;
		dependencyInjection();
		initForm();
		initComponents();
		initController();

		loadAllList();
		loadData();
		getOrder();
		showlist();
		

	}

	private void dependencyInjection() {
		try {
			packageservice = new Package_service();
			this.destination_Service = new DestinationPrice_service();
			this.staffservice = new Staff_Service();
			this.customerservice = new Customer_service();
			this.orderservice = new Order_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initForm() {
		// office_view = new View.Office_view(frame);
		// navigationPanel = new Office_view(frame);
		// setPricepanel = new SetPrice_Panel(frame);
		odetail = new Orderdetail_view();

		// office_view.getPanel_btnOrder().setBackground(new Color(218, 165, 32));

		// frame.revalidate();
		// frame.repaint();
	}

	private void initComponents() {
		viewdetail = odetail.getPanel_orderdetails();
		btnDelete = odetail.getBtndelete();
		btnBack = odetail.getBtnback();
		btnEdit = odetail.getBtnedit();
		btnUpdate = odetail.getBtnupdate();
		lblorderid = odetail.getLbl_setorderid();
		lblprice = odetail.getLbl_setprice();
		lblpayment = odetail.getLbl_setpayment();
		lblway = odetail.getLbl_setway();
		lblname = odetail.getLbl_setname();
		lblphone = odetail.getLbl_setphone();
		lbladdress = odetail.getLbl_setaddress();
		lbldate = odetail.getLbl_setdate();
		txtprice = odetail.getTxt_orderprice();
		txtpayment = odetail.getTxt_payment();
		txtdate = odetail.getTxt_date();
		txtname = odetail.getTxt_name();
		txtphone = odetail.getTxt_phone();
		txtaddress = odetail.getTxt_address();
		comboWay = odetail.getComboWay();
		table = odetail.getTbl_orderdetail();
	}

	private void initController() {
		// navigationPanel.getPanel_btnStaff().addMouseListener(this);
		// navigationPanel.getPanel_btnOrder().addMouseListener(this);
		// navigationPanel.getPanel_btnDelivery().addMouseListener(this);
		// navigationPanel.getPanel_btnSetPrice().addMouseListener(this);
		btnDelete.addActionListener(this);
		btnBack.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnEdit.addActionListener(this);
	}

	private void loadAllList() {
		wayList = destination_Service.getAlldestinationPrice();
	}

	private void loadData() {
		comboWay.addItem("-Select-");
		for (Destination d : wayList) {
			comboWay.addItem(d.getDestinationName());
		}
	}

	private void getOrder() {
		Order order = new Order();
		temp_no = lblorderid.getText();

		order = orderservice.getOrderById(7);
		order_no=order.getOrder_no();
		localData(order);
		pack = packageservice.getlastPackageId(temp_no);
		System.out.println("pack is" + pack);

		/*
		 * if (tblOrderdetail != null) tblOrderdetail.insertRow(pack);
		 */
	}

	private void editdata() {
		Order order = new Order();

		order = orderservice.getOrderById(2);
		datatoText(order);
	}

	private void showlist() {
		System.out.println("showlist");

		List<Package> packagelist = new ArrayList<Package>();
		packagelist = packageservice.getPackageByOrderNo(order_no);
		
		
		
		//System.out.println(packagelist.toString());

		tblOrderdetail = new TableModel_Orderdetail(packagelist);
		table.setModel(tblOrderdetail);
		sorter = new TableRowSorter<TableModel_Orderdetail>(tblOrderdetail);
	}

	void updateOrderdetail() {
		setModel();
		temp_no = lblorderid.getText();
		System.out.println(temp_no);
		cus_id = orderservice.getCustomerid(temp_no);
		System.out.println(cus_id);
		int updateCustomer = customerservice.updateCustomer(cus_id, customer);
		if (updateCustomer != 0) {
			System.out.println(" customer successful");
		} else {
			System.out.println("fail customer");
		}

		int updateOrder = orderservice.updateOrder(temp_no, order);

		if (updateCustomer > 0 && updateOrder > 0) {
			System.out.println("update successful");
		} else {
			System.out.println("update fail");
		}

	}

	private void localData(Order order) {

		lblname.setText(order == null ? "" : order.getCustomer().getName());
		lblphone.setText(order == null ? "" : order.getCustomer().getPhone());
		lbladdress.setText(order == null ? "" : order.getCustomer().getAddress());
		lblorderid.setText(order == null ? "" : order.getOrder_no());
		lblprice.setText(order == null ? "" : String.valueOf(order.getTransportationfees()));
		lblway.setText(order == null ? "" : order.getDestination().getDestinationName());
		lbldate.setText(order == null ? "" : String.valueOf(order.getDate()));
	}

	private void datatoText(Order order) {
		txtname.setText(order == null ? "" : order.getCustomer().getName());
		txtphone.setText(order == null ? "" : order.getCustomer().getPhone());
		txtaddress.setText(order == null ? "" : order.getCustomer().getAddress());
		comboWay.setSelectedIndex(order == null ? 0 : order.getDestination().getId());
		txtprice.setText(order == null ? "" : String.valueOf(order.getTransportationfees()));

		txtdate.setText(order == null ? "" : String.valueOf(order.getDate()));
	}

	private void setModel() {
		long millis = System.currentTimeMillis();
		order = new Order();
		customer = new Customer();
		customer.setId(customerservice.getLastCustomerId());
		customer.setName(txtname.getText());
		customer.setAddress(txtaddress.getText());
		customer.setPhone(txtphone.getText());

		if (0 != comboWay.getSelectedIndex()) {

			Destination destination = new Destination();
			destination.setId(comboWay.getSelectedIndex());
			order.setDestination(new Destination(comboWay.getSelectedIndex(), comboWay.getSelectedItem().toString()));

			order.setCustomer(customer);

			order.setTransportationfees(Integer.parseInt(txtprice.getText()));
			order.setDate(new java.sql.Date(millis));
		} else {
			JOptionPane.showMessageDialog(null, "Please select one way");
		}

	}

//	private void loadinfo(Order order) {
//		lblorderid.setText(order= ?
//	}
	private void changetxtVisible() {

		// lblname.setVisible(visiable);
		// txtname.setVisible(!visiable);

		lblname.setVisible(false);
		lblphone.setVisible(false);
		lbladdress.setVisible(false);
		lblway.setVisible(false);
		lblprice.setVisible(false);
		lbldate.setVisible(false);
		lblpayment.setVisible(false);
		txtname.setVisible(true);
		txtphone.setVisible(true);
		txtaddress.setVisible(true);
		txtprice.setVisible(true);
		txtdate.setVisible(true);
		txtpayment.setVisible(true);
		comboWay.setVisible(true);
	}

	private void changelblVisible() {
		lblname.setVisible(true);
		lblphone.setVisible(true);
		lbladdress.setVisible(true);
		lblway.setVisible(true);
		lblprice.setVisible(true);
		lbldate.setVisible(true);
		lblpayment.setVisible(true);
		txtname.setVisible(false);
		txtphone.setVisible(false);
		txtaddress.setVisible(false);
		txtprice.setVisible(false);
		txtdate.setVisible(false);
		txtpayment.setVisible(false);
		comboWay.setVisible(false);
	}

	private void resetFormdata() {
		txtname.setText("");
		txtphone.setText("");
		txtaddress.setText("");
		txtprice.setText("");
		txtdate.setText("");
		comboWay.setSelectedIndex(0);
	}

	private void edit() {
		changetxtVisible();
		editdata();

	}

	private void update() {
		updateOrderdetail();
		resetFormdata();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEdit)) {
			edit();
		}
		if (e.getSource().equals(btnUpdate)) {
			update();
			changelblVisible();
		//	localView();
		}
		if (e.getSource().equals(btnDelete)) {

		}

	}

}
