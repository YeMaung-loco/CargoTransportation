package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.DesignMode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import Model.CurrentUserHolder;
import Model.Customer;
import Model.Destination;
import Model.Order;
import Model.Package;
import Model.Weight;
import Service.Customer_service;
import Service.DestinationPrice_service;
import Service.Order_service;
import Service.Package_service;
import Service.WeightPrice_service;
import TableModel.TableModel_Order;
import Utility.Checking;
import Utility.ExportDataToExcel;
import Utility.Prefix;
import View.Office_view;
import View.Order_Panel;

public class OrderManage_controller
		implements MouseListener, ActionListener, CaretListener, ItemListener, ListSelectionListener {
	List<Destination> destinationList;
	List<Weight> weightList;
	ArrayList<Integer> weightkg;
	ArrayList<Integer> weightPrice;
	DestinationPrice_service destination_service;
	Order_service order_service;
	WeightPrice_service weight_service;
	Package_service package_service;
	Customer_service customer_service;
	Customer customer;
	Order order;
	int fee = 0;
	String order_no;
	int customer_id;

	Office_view office_view;
	JFrame containerFrame;
	Order_Panel order_Panel;
	JTable tblorder;
	TableModel_Order model_Order;
	TableRowSorter<TableModel_Order> sorter;
	JLabel lblFee, lblOrderId;
	JTextField txtc_name, txtc_phone, txtc_address, txt_search;
	JComboBox<String> comboDestination, searchComboDestination;
	JButton btnAdd, btnDelete, btnDone;
	JButton btn_viewDetail;
	JLabel iconManageStaff, iconSetPrice;

	boolean insertCO = false;
	boolean addedDestinationFee = false;
	// JCheckBox[] checkBoxList = new JCheckBox[50];
	HashMap<String, Integer> temp_packageList = new HashMap<String, Integer>();

	ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	int i = 0;

	public OrderManage_controller(JFrame frame) {
		containerFrame = frame;

		dependencyInjection();
		loadAllPrice();

		initForm();
		initComponents();
		initController();

		loadAllPrice();
		loadData();
		showList();
		newOrderId();

	}

	private void showList() {
		List<Order> orderList = new ArrayList<Order>();
		orderList = order_service.getAllOrderlist();
		btn_viewDetail = new JButton("View");
		model_Order = new TableModel_Order(orderList, btn_viewDetail);

		tblorder.setModel(model_Order);

		TableCellRenderer tableRenderer = tblorder.getDefaultRenderer(JButton.class);
		tblorder.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));

		sorter = new TableRowSorter<TableModel_Order>(model_Order);
	}

	private void loadData() {
		comboDestination.addItem("-Select-");
		searchComboDestination.addItem("-Select-");
		for (Destination d : destinationList) {
			comboDestination.addItem(d.getDestinationName());
			searchComboDestination.addItem(d.getDestinationName());
		}
	}

	private void loadAllPrice() {
		weightkg = new ArrayList<>();
		weightPrice = new ArrayList<>();

		destinationList = destination_service.getAlldestinationPrice();
		weightList = weight_service.getAllweightPrice();

		for (Weight weight : weightList) {
			weightkg.add(weight.getWeight_kg());
			weightPrice.add(weight.getWeightprice());
		}
		Collections.sort(weightkg);
		Collections.sort(weightPrice);
	}

	public void dependencyInjection() {
		try {
			destination_service = new DestinationPrice_service();
			order_service = new Order_service();
			weight_service = new WeightPrice_service();
			package_service = new Package_service();
			customer_service = new Customer_service();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void initForm() {

		office_view = new Office_view(containerFrame);
		order_Panel = new Order_Panel(containerFrame);
		office_view.getPanel_btnOrder().setBackground(new Color(218, 165, 32));

		///
		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Office Staff")) {
			// office_view.getPanel_btnSetPrice().setVisible(false);
			ImageIcon disableIcon = new ImageIcon(
					new ImageIcon("resource\\disable.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

			iconManageStaff = office_view.getIconManageStaff();
			iconSetPrice = office_view.getIconSetPrice();

			iconSetPrice.setIcon(disableIcon);
			iconManageStaff.setIcon(disableIcon);

		}
	}

	private void newOrderId() {
		order_no = Prefix.getPrimaryKey("CO-", order_service.getLastOrderId() + 1);
		lblOrderId.setText(order_no);
		addedDestinationFee = false;
		System.out.println("Order_Controller initform" + order_no);
	}

	public void initComponents() {
		txtc_name = order_Panel.getTxtc_name();
		txtc_phone = order_Panel.getTxtc_phone();
		txtc_address = order_Panel.getTxtc_address();
		txt_search = order_Panel.getTxt_searchorder();

		lblFee = order_Panel.getLbl_transporation();
		lblOrderId = order_Panel.getLblOrderId();

		btnAdd = order_Panel.getBtnNewButton();
		btnDelete = order_Panel.getBtnDelete();
		btnDone = order_Panel.getBtnDone();

		comboDestination = order_Panel.getJcombo_destination();
		searchComboDestination = order_Panel.getJcombo_destination_1();

		tblorder = order_Panel.getTable();

	}

	public void initController() {
		if (CurrentUserHolder.getCurrentUser().getRole().getRole_name().equals("Admin")) {
			office_view.getPanel_btnStaff().addMouseListener(this);
			office_view.getPanel_btnSetPrice().addMouseListener(this);
		}

		office_view.getPanel_btnOrder().addMouseListener(this);
		office_view.getPanel_btnDelivery().addMouseListener(this);
		office_view.getPanel_btn_approve().addMouseListener(this);
		office_view.getPanel_btnLogout().addMouseListener(this);

		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnDone.addActionListener(this);

		searchComboDestination.addItemListener(this);

		tblorder.addMouseListener(this);
		tblorder.getSelectionModel().addListSelectionListener(this);

		txt_search.addCaretListener(this);

	}

	private void edit() {
		Order order = new Order();
		order = order_service.getOrderById(order_no);
		dataToView(order);
	}

	private void dataToView(Order order) {
		temp_packageList.clear();
		fee = 0;
		checkBoxList.removeAll(checkBoxList);
		order_Panel.getPanel_Package().removeAll();
		order_Panel.getPanel_Package().revalidate();
		order_Panel.getPanel_Package().repaint();

		txtc_name.setText(order == null ? "" : order.getCustomer().getName());
		txtc_phone.setText(order == null ? "" : order.getCustomer().getPhone());
		txtc_address.setText(order == null ? "" : order.getCustomer().getAddress());
		comboDestination.setSelectedItem(order == null ? 0 : order.getDestination().getDestinationName());

		lblOrderId.setText(order == null ? "" : order.getOrder_no());
		lblFee.setText(order == null ? "" : String.valueOf(order.getTransportationfees()));
		if (order != null) {
			fee = order.getTransportationfees();
			List<Package> packList = package_service.getPackageModelByOrderNo(order_no);
			for (Package pack : packList) {
				checkBoxList.add(new JCheckBox(pack.getPackage_id()));

				int price = weightPrice.get(calculateWeight(0, weightkg.size() - 1, pack.getWeight()));

				temp_packageList.put(pack.getPackage_id(), price);
			}
			for (JCheckBox checkBox : checkBoxList) {
				// checkBoxList[i] = new JCheckBox(packageId);
				checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				order_Panel.getPanel_Package().add(checkBox);

				order_Panel.getPanel_Package().revalidate();
				order_Panel.getPanel_Package().repaint();

			}
		}

	}

	boolean setModel() {
		boolean flag = false;
		if (!txtc_name.getText().equals("") && !txtc_phone.getText().equals("") && !txtc_address.getText().equals("")) {
			if (Checking.IsValidName(txtc_name.getText()) && Checking.IsAllDigit(txtc_phone.getText())) {
				customer = new Customer();
				customer.setId(customer_service.getLastCustomerId() + 1);
				customer.setName(txtc_name.getText());
				customer.setPhone(txtc_phone.getText());
				customer.setAddress(txtc_address.getText());

				if (0 != comboDestination.getSelectedIndex()) {
					order = new Order();
					long millis = System.currentTimeMillis();
					Destination destination = destination_service
							.getDestinationByName(comboDestination.getSelectedItem().toString());

					System.out.println("destination id and name" + comboDestination.getSelectedIndex());

					order.setOrder_no(order_no);
					order.setCustomer(customer);
					order.setDestination(destination);
					order.setDate(new java.sql.Date(millis));
					flag = true;
				}
			}

		}

		return flag;
	}

	void insertCustomerAndOrder() {
		if (setModel()) {
			int insertCustomer = customer_service.createCustomer(customer);
			customer_id = customer_service.getLastCustomerId();
			int inserOrder = order_service.createOrder(order, customer_id);
			if (insertCustomer > 0 && inserOrder > 0) {
				insertCO = true;
			} else {
				alert("Input Properly!!!");
			}
		} else
			alert("Input required fields!!!");
	}

	private void addPackage() {
		if (!insertCO) {
			insertCustomerAndOrder();
		}
		if (insertCO) {
			System.out.println("Customer and order success " + order_no);
			String packageId = Prefix.getPrimaryKey("CK-", package_service.getLastPackageId() + 1);
			String weight = JOptionPane.showInputDialog(containerFrame, packageId, "Input weight in kg",
					JOptionPane.INFORMATION_MESSAGE);

			if (weight != null && !weight.equals("") && Checking.IsAllDigit(weight)) {
				if (!addedDestinationFee) {
					addedDestinationFee = true;
					int destinationPrice = destination_service.getdestinationPriceById(order.getDestination().getId());
					System.out.println("Destination Price-" + destinationPrice);
					fee += destinationPrice;
				}
				int packageWeight = Integer.parseInt(weight);
				int price = weightPrice.get(calculateWeight(0, weightkg.size() - 1, packageWeight));
				fee += price;

				System.out.println("PackageId" + packageId + "and" + packageWeight);
				int status = package_service.createPackage(packageId, order_no, packageWeight);
				if (status > 0) {
					JCheckBox checkbox = new JCheckBox(packageId);
					checkbox.setFont(new Font("Tahoma", Font.PLAIN, 15));
					order_Panel.getPanel_Package().add(checkbox);
					checkBoxList.add(checkbox);
					temp_packageList.put(packageId, price);
					lblFee.setText(String.valueOf(fee));
					order_Panel.getPanel_Package().revalidate();
					order_Panel.getPanel_Package().repaint();
					// i++;
				}
			} else {
				alert("Input properly!!");
			}

		}
	}

	void removePackage() {
		System.out.println("Remove Package");
		for (int i = 0; i < checkBoxList.size(); i++) {
			if (checkBoxList.get(i).isSelected()) {
				order_Panel.getPanel_Package().remove(checkBoxList.get(i));
				fee -= temp_packageList.get(checkBoxList.get(i).getText());
				checkBoxList.remove(i);
				lblFee.setText(String.valueOf(fee));
				order_Panel.getPanel_Package().revalidate();
				order_Panel.getPanel_Package().repaint();
			}

		}

	}

	private void delete() {
		int modelRowIndex = tblorder.convertRowIndexToModel(tblorder.getSelectedRow());
		System.out.println("delete " + modelRowIndex);
		if (modelRowIndex != -1) {
			int packageDelete = package_service.deletePackageByOrderNo(order_no);
			int orderDelete = order_service.deleteOrder(order_no);
			int customerDelete = customer_service.deleteCustomer(customer_id);

			if (packageDelete > 0)
				System.out.println("Package delete success");
			if (orderDelete > 0)
				System.out.println("Order delete success");
			if (customerDelete > 0)
				System.out.println("customer delete success");

			if (packageDelete > 0 && orderDelete > 0 && customerDelete > 0) {
				model_Order.removeRow(modelRowIndex);
				alert("Successfully Deleted!");
			} else
				alert("Delete Failed!");
		} else {
			alert("Select a row to Delete!!");
		}
	}

	public int calculateWeight(int first, int last, int weight) {
		int index = 0;
		if (weightkg.get(first) > weight) {
			System.out.println("Element is not found!" + index);
			return first;
		}
		if (weightkg.get(last) < weight) {
			return last;
		}
		int mid = (first + last) / 2;
		while (first <= last) {
			if (weightkg.get(mid) < weight) {
				first = mid + 1;
			} else if (weightkg.get(mid) == weight) {
				index = mid;
				System.out.println("weight kg is found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			if (weightkg.get(last) > weight) {
				index = last;
			} else {
				index = last + 1;
			}
			System.out.println("Element is not found!" + index);
		}
		return index;
	}

	private void done() {
		order.setTransportationfees(fee);
		int status = order_service.updateOrder(order_no, order);
		if (status > 0) {
			order = order_service.getlastOrder();
			if (model_Order != null)
				model_Order.insertRow(order);

			alert("Successfully Saved!");
			i = 0;
			insertCO = false;

		} else {
			alert("Failed Save!");
		}
		order = null;
		customer = null;
		dataToView(order);
		newOrderId();

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(office_view.getFrame(), msg);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(tblorder)) {
			if (tblorder.getSelectedColumn() == 7) {
				containerFrame.remove(order_Panel.getPanelCustomer());
				containerFrame.remove(order_Panel.getPanelOrder());
				containerFrame.remove(order_Panel.getPanelOrderList());
				containerFrame.remove(office_view.getPanel_navigation());
				Orderdetail_controller orderdetail_controller = new Orderdetail_controller(null, this, null, order_no,
						containerFrame);
			}

			if (e.getClickCount() == 2)
				edit();
		}

		if (e.getSource().equals(office_view.getPanel_btnStaff())) {
			System.out.println("order manage btnstaff");

			containerFrame.remove(order_Panel.getPanelCustomer());
			containerFrame.remove(order_Panel.getPanelOrder());
			containerFrame.remove(order_Panel.getPanelOrderList());
			containerFrame.remove(office_view.getPanel_navigation());
			CreateAccount_controller account_controller = new CreateAccount_controller(containerFrame);
		}
		if (e.getSource().equals(office_view.getPanel_btnSetPrice())) {
			containerFrame.remove(order_Panel.getPanelCustomer());
			containerFrame.remove(order_Panel.getPanelOrder());
			containerFrame.remove(order_Panel.getPanelOrderList());
			containerFrame.remove(office_view.getPanel_navigation());
			SetPrice_controller setPrice_controller = new SetPrice_controller(containerFrame);
		}

		if (e.getSource().equals(office_view.getPanel_btnDelivery())) {
			containerFrame.remove(order_Panel.getPanelCustomer());
			containerFrame.remove(order_Panel.getPanelOrder());
			containerFrame.remove(order_Panel.getPanelOrderList());
			containerFrame.remove(office_view.getPanel_navigation());
			DeliveryManage_Controller next_controller = new DeliveryManage_Controller(containerFrame);
		}

		if (e.getSource().equals(office_view.getPanel_btn_approve())) {
			containerFrame.remove(order_Panel.getPanelCustomer());
			containerFrame.remove(order_Panel.getPanelOrder());
			containerFrame.remove(order_Panel.getPanelOrderList());
			containerFrame.remove(office_view.getPanel_navigation());
			Payment_controller payment_controlle = new Payment_controller(containerFrame);
		}

		if (e.getSource().equals(office_view.getPanel_btnLogout())) {
			containerFrame.dispose();
			Login_controller nextController = new Login_controller();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd))
			addPackage();

		if (e.getSource().equals(btnDone))
			done();

		if (e.getSource().equals(btnDelete))
			removePackage();
		// delete();

		if (e.getSource().equals(btn_viewDetail)) {
			alert("View Detail");
			System.out.println("View detail");
		}

	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if (e.getSource().equals(txt_search)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txt_search.getText(), 1));
				System.out.println(searchComboDestination.getSelectedItem().toString());
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				tblorder.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(searchComboDestination)) {

			if (0 != searchComboDestination.getSelectedIndex())
				try {

					java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
					filters.add(RowFilter.regexFilter(searchComboDestination.getSelectedItem().toString(), 4));
					System.out.println();
					RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
					System.out.println(serviceFilter);
					sorter.setRowFilter(serviceFilter);
					tblorder.setRowSorter(sorter);
				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
			else {
				tblorder.setRowSorter(null);
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!tblorder.getSelectionModel().isSelectionEmpty()) {
			order_no = model_Order.getOrder_no(tblorder.convertRowIndexToModel(tblorder.getSelectedRow()));
			customer_id = model_Order.getCustomer_Id(tblorder.convertRowIndexToModel(tblorder.getSelectedRow()));

			// System.out.println("Order_No" + order_no);
		}

		else {
			System.out.println("Empty");

		}

	}
}

class JTableButtonRenderer implements TableCellRenderer {
	private TableCellRenderer defaultRenderer;

	public JTableButtonRenderer(TableCellRenderer renderer) {
		defaultRenderer = renderer;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (value instanceof Component)
			return (Component) value;
		return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
