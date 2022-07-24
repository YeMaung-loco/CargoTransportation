package Controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import Model.CurrentUserHolder;
import Model.Customer;
import Model.Destination;
import Model.Order;
import Model.Package;
import Model.Staff;
import Service.Customer_service;
import Service.Department_service;
import Service.DestinationPrice_service;
import Service.Order_service;
import Service.Orderstaff_service;
import Service.Package_service;
import Service.Staff_Service;
import TableModel.TableModel_Package;
import View.Office_view;
import View.Orderdetail_view;

public class Orderdetail_controller implements ActionListener, MouseListener {

	List<Destination> wayList;

	// Staff_Service staffservice;
	Order_service orderservice;
	Customer_service customerservice;
	Package_service packageservice;
	Department_service department_Service;
	DestinationPrice_service destination_Service;
	Staff_Service staffservice;
	TableModel_Package model_package;

	Customer customer;
	Destination destination;
	Order order = new Order();

	Staff staff;
	Package pack;

	JFrame frame;
	// JPanel viewdetail;
	JPanel panel_btn_Account, panel_btn_SetPrice, panel_btn_OrderMange, panel_btn_Approve, panel_btn_DeliManage;
	JButton btnDelete, btnEdit, btnUpdate, btnBack;
	JLabel lblorderid, lblprice, lblway, lblpayment, lblname, lblphone, lbladdress, lbldate, lblstatus, lbl_setstatus,
			lbldelivery, lbl_setdelivery;
	JTextField txtprice, txtpayment, txtname, txtphone, txtaddress, txtdate;
	JComboBox<String> comboWay;
	// Office_view office_view;
	JTable table;
	Orderdetail_view odetail;
	Office_view navigationPanel;
	// SetPrice_Panel setPricepanel;
	int cus_id;
	int orderid;
	String order_no;
	String temp_no;
	TableRowSorter<TableModel_Package> sorter;
	Orderstaff_service orderStaffservice;
	DeliveryManage_Controller deliveryManage_Controller;
	OrderManage_controller orderManage_controller;
	Payment_controller payment_controller;

	public Orderdetail_controller(DeliveryManage_Controller deliController, OrderManage_controller orderController,
			Payment_controller pay_controller, String order_no, JFrame frame) {
		if (deliController != null)
			deliveryManage_Controller = deliController;
		if (orderController != null)
			orderManage_controller = orderController;
		if (pay_controller != null)
			this.payment_controller = pay_controller;

		this.frame = frame;
		this.order_no = order_no;
		dependencyInjection();
		initForm();
		initComponents();
		initController();

		// loadAllList();
		loadData();
		dataLbl(order);
		// getOrder();
		showlist();

	}

	private void dependencyInjection() {
		try {
			this.packageservice = new Package_service();
			this.destination_Service = new DestinationPrice_service();
			this.customerservice = new Customer_service();
			this.orderservice = new Order_service();
			this.staffservice = new Staff_Service();
			this.orderStaffservice = new Orderstaff_service();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initForm() {
		odetail = new Orderdetail_view(frame);
		navigationPanel = new Office_view(frame);

		if (deliveryManage_Controller != null) {
			navigationPanel.getPanel_btnDelivery().setBackground(new Color(218, 165, 32));
		}
		if (orderManage_controller != null) {
			navigationPanel.getPanel_btnOrder().setBackground(new Color(218, 165, 32));

		}
		if (payment_controller != null) {
			navigationPanel.getPanel_btn_approve().setBackground(new Color(218, 165, 32));
		}

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Office Staff")) {
			ImageIcon disableIcon = new ImageIcon(
					new ImageIcon("resource\\disable.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

			JLabel iconManageStaff = navigationPanel.getIconManageStaff();
			JLabel iconSetPrice = navigationPanel.getIconSetPrice();

			iconSetPrice.setIcon(disableIcon);
			iconManageStaff.setIcon(disableIcon);

		}

	}

	private void initComponents() {
		/// viewdetail = odetail.getPanel_orderdetails();
		lbldelivery = new JLabel();
		lbl_setdelivery = new JLabel();
		panel_btn_Account = navigationPanel.getPanel_btnStaff();
		panel_btn_OrderMange = navigationPanel.getPanel_btnOrder();
		panel_btn_SetPrice = navigationPanel.getPanel_btnSetPrice();
		panel_btn_DeliManage = navigationPanel.getPanel_btnDelivery();
		panel_btn_Approve = navigationPanel.getPanel_btn_approve();

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
		lblstatus = odetail.getLblstatus();
		lbl_setstatus = odetail.getLbl_setstatus();
		lbldelivery = odetail.getLbldelivery();
		lbl_setdelivery = odetail.getLblsetdelivery();

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

		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Admin")) {
			panel_btn_Account.addMouseListener(this);
			panel_btn_SetPrice.addMouseListener(this);
		}

		panel_btn_DeliManage.addMouseListener(this);
		panel_btn_OrderMange.addMouseListener(this);
		panel_btn_Approve.addMouseListener(this);

		btnDelete.addActionListener(this);
		btnBack.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnEdit.addActionListener(this);
	}

//	private void loadAllList() {
//
//	}

	private void loadData() {
		order = orderservice.getOrderById(order_no);
		wayList = destination_Service.getAlldestinationPrice();
		comboWay.addItem("-Select-");
		for (Destination d : wayList) {
			comboWay.addItem(d.getDestinationName());
		}
	}

//	private void getOrder() {
//
//		//localData(order);
//
//	}

	private void editdata() {
		// Order order = new Order();

		// order = orderservice.getOrderById(" ");
		// datatoText(order);
	}

	private void showlist() {
		System.out.println("showlist");

		List<String> packagelist = new ArrayList<String>();
		packagelist = packageservice.getPackageByOrderNo(order_no);

		model_package = new TableModel_Package(packagelist);
		table.setModel(model_package);
		sorter = new TableRowSorter<TableModel_Package>(model_package);
	}

	void updateOrderdetail() {
		setModel();
		int updateCustomer = customerservice.updateCustomer(cus_id, customer);
		if (updateCustomer > 0) {
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

	private void dataLbl(Order order) {
		lblname.setText(order == null ? "" : order.getCustomer().getName());
		lblphone.setText(order == null ? "" : order.getCustomer().getPhone());
		lbladdress.setText(order == null ? "" : order.getCustomer().getAddress());
		lblorderid.setText(order == null ? "" : order.getOrder_no());
		lblprice.setText(order == null ? "" : String.valueOf(order.getTransportationfees()));
		lblway.setText(order == null ? "" : order.getDestination().getDestinationName());
		lbldate.setText(order == null ? "" : String.valueOf(order.getDate()));
		lbl_setstatus.setText(order == null ? "" : String.valueOf(order.getStatus()));
		String status = order.getStatus();

		System.out.println(order_no);
		if (status != "" & status != null) {
			if (!status.contains("T")) {

				int staff_id = orderStaffservice.getdeli(order_no);
				String deli = staffservice.getdeliname(staff_id);
				lbldelivery.setVisible(true);
				lbl_setdelivery.setVisible(true);
				lbl_setdelivery.setText(deli == null ? "" : deli);
			}

		} else {
			System.out.println("delivering is not");
		}

	}

	private void datatoText(Order order) {
		// System.out.println("Customer Name-" + order.getCustomer().getName());

		txtname.setText(order == null ? "" : order.getCustomer().getName());
		txtphone.setText(order == null ? "" : order.getCustomer().getPhone());
		txtaddress.setText(order == null ? "" : order.getCustomer().getAddress());
		txtprice.setText(order == null ? "" : String.valueOf(order.getTransportationfees()));
		txtdate.setText(order == null ? "" : String.valueOf(order.getDate()));
		comboWay.setSelectedIndex(order == null ? 0 : order.getDestination().getId());

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

	private void changeVisible(boolean visible) {
		lblname.setVisible(visible);
		lblphone.setVisible(visible);
		lbladdress.setVisible(visible);
		lblway.setVisible(visible);
		lblprice.setVisible(visible);
		lbldate.setVisible(visible);
		lblpayment.setVisible(visible);
		txtname.setVisible(!visible);
		txtphone.setVisible(!visible);
		txtaddress.setVisible(!visible);
		txtprice.setVisible(!visible);
		txtdate.setVisible(!visible);
		txtpayment.setVisible(!visible);
		comboWay.setVisible(!visible);
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
		changeVisible(false);
		editdata();

	}

	private void update() {
		// updateOrderdetail();
		// resetFormdata();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnEdit)) {
			// edit();
			datatoText(order);
			changeVisible(false);
		}
		if (e.getSource().equals(btnUpdate)) {
			update();
			changeVisible(true);
			// localView();
		}
		if (e.getSource().equals(btnDelete)) {

		}

		if (e.getSource().equals(btnBack)) {
			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());

			if (orderManage_controller != null) {
				OrderManage_controller order_controller = new OrderManage_controller(frame);
			}

			if (deliveryManage_Controller != null) {
				DeliveryManage_Controller delivery_Controller = new DeliveryManage_Controller(frame);
			}

			if (payment_controller != null) {
				Payment_controller nextController = new Payment_controller(frame);
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(panel_btn_Account)) {

			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());
			CreateAccount_controller account_controller = new CreateAccount_controller(frame);
		}
		if (e.getSource().equals(panel_btn_OrderMange)) {
			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());
			OrderManage_controller order_controller = new OrderManage_controller(frame);

		}
		if (e.getSource().equals(panel_btn_SetPrice)) {
			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());
			SetPrice_controller price_controller = new SetPrice_controller(frame);

		}

		if (e.getSource().equals(panel_btn_Approve)) {
			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());
			Payment_controller nextController = new Payment_controller(frame);

		}

		if (e.getSource().equals(panel_btn_DeliManage)) {
			frame.remove(odetail.getPanel_orderdetails());
			frame.remove(navigationPanel.getPanel_navigation());
			DeliveryManage_Controller nextController = new DeliveryManage_Controller(frame);

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
