package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import Model.Authenticate;
import Model.Department;
import Model.Role;
import Model.Staff;
import Service.Auth_service;
import Service.Department_service;
import Service.Staff_Service;
import TableModel.TableModel_Staff;
import Utility.Checking;
import View.Office_view;
import View.Staff_Panel;

public class CreateAccount_controller implements ActionListener, MouseListener, ListSelectionListener, CaretListener {
	OrderManage_controller order_controller;

	Office_view office_view;
	Staff_Panel cePanel;
	Staff staff;
	Authenticate auth;
	TableModel_Staff model_Staff;
	JTable table;

	TableRowSorter<TableModel_Staff> sorter;

	JFrame frame;
	JPanel inputPanel, listPanel;
	JTextField txtName, txtNRC, txtPhone, txtDepartment, txtsearch;
	JTextArea txtareaAddress;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	ButtonGroup radioGroup;
	JCheckBox chckbxupload, chckbxManage, chckActive;
	JComboBox<String> comboDepartment;

	JButton btnSave, btnUpdate, btnDelete, btnClear, btnMinimize, btnMaximize, btnSearch, btnCreate, btnEdit;
	Staff_Service staff_Service;
	Auth_service auth_Service;
	Department_service department_Service;
	int temp_id;

	public CreateAccount_controller(JFrame frame) {
		this.frame = frame;
		dependencyInjection();
		initForm();
		initComponents();
		initController();
		loadComboData();
		showList();
	}

	private void dependencyInjection() {
		try {
			this.staff_Service = new Staff_Service();
			this.department_Service = new Department_service();
			this.auth_Service = new Auth_service();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		// frame = office_view.getFrame();
		inputPanel = cePanel.getPanel_create();
		listPanel = cePanel.getPanel_list();

		btnSave = cePanel.getBtnSave();
		btnClear = cePanel.getBtnClear();
		btnUpdate = cePanel.getBtnUpdate();
		btnDelete = cePanel.getBtnDelete();
		btnSearch = cePanel.getBtnSearch();
		btnMaximize = cePanel.getBtnMaximize();
		btnMinimize = cePanel.getBtnMinimize();
		btnCreate = cePanel.getBtnCreate();
		btnEdit = cePanel.getBtnedit();
		btnCreate.setVisible(false);

		txtName = cePanel.getTxtName();
		txtPhone = cePanel.getTxtPhone();
		txtareaAddress = cePanel.getTxtareaAddress();
		txtNRC = cePanel.getTxtNRC();

		txtsearch = cePanel.getTxtsearch();

		comboDepartment = cePanel.getComboDepartment();

		radioGroup = cePanel.getRadioGroup();
		rdbtnDelivery = cePanel.getRdbtnDelivery();
		rdbtnOffice = cePanel.getRdbtnOffice();

		chckbxupload = cePanel.getChckbxupload();
		chckbxManage = cePanel.getChckbxManage();
		chckActive = cePanel.getChckbxActive();

		table = cePanel.getTable();

	}

	private void initController() {

		office_view.getPanel_btnStaff().addMouseListener(this);
		office_view.getPanel_btnSetPrice().addMouseListener(this);

		office_view.getPanel_btnOrder().addMouseListener(this);
		office_view.getPanel_btnDelivery().addMouseListener(this);
		office_view.getPanel_btn_approve().addMouseListener(this);
		office_view.getPanel_btnLogout().addMouseListener(this);

		btnMinimize.addActionListener(this);
		btnMaximize.addActionListener(this);
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCreate.addActionListener(this);
		btnEdit.addActionListener(this);

		table.addMouseListener(this);
		table.getSelectionModel().addListSelectionListener(this);

		txtsearch.addCaretListener(this);

	}

	private void initForm() {
		office_view = new View.Office_view(frame);
		cePanel = new Staff_Panel(frame);

		///
		cePanel.getBtnMaximize().setVisible(false);
		office_view.getPanel_btnStaff().setBackground(new Color(218, 165, 32));

		frame.revalidate();
		frame.repaint();
	}

	private void loadComboData() {
		List<Department> departmentList = new ArrayList<>();
		comboDepartment.addItem("-Select-");
		departmentList = this.department_Service.getAllDepartment();
		departmentList.forEach(d -> this.comboDepartment.addItem(d.getDepartmentName()));
	}

	private boolean setModel() {
		if (Checking.IsValidName(txtName.getText()) && Checking.IsAllDigit(txtPhone.getText())
				&& comboDepartment.getSelectedIndex() != 0) {

			long millis = System.currentTimeMillis();
			int roleId = 0;
			String roleName = "";

			if (radioGroup.getSelection().getActionCommand().equals("Office")) {
				roleId = 2;
				roleName = "Office Staff";
			}
			if (radioGroup.getSelection().getActionCommand().equals("Delivery")) {
				roleId = 5;
				roleName = "Delivery";
			}

			staff = new Staff();
			Role role = new Role();
			Department department = new Department();
			staff.setName(txtName.getText());
			staff.setPhone(txtPhone.getText());
			staff.setAddress(txtareaAddress.getText());
			staff.setNrc(txtNRC.getText());
			staff.setRole(new Role(roleId, roleName));
			staff.setDepartment(
					new Department(comboDepartment.getSelectedIndex(), comboDepartment.getSelectedItem().toString()));
			staff.setDate(new java.sql.Date(millis));
			staff.setActive(chckActive.isSelected() ? true : false);

		} else {
			alert("Input properly!!");
			return false;
		}
		return true;
	}

	private void collapseInputForm(boolean collapse) {

		btnMinimize.setVisible(!collapse);
		btnMaximize.setVisible(collapse);

		if (collapse) {
			inputPanel.setBounds(200, 0, 1144, 50);
			listPanel.setBounds(200, 50, 1144, 690);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 630);
		} else {
			inputPanel.setBounds(200, 0, 1144, 310);
			listPanel.setBounds(200, 310, 1144, 430);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 370);

		}
	}

	private void save() {
		if (setModel()) {
			int status = staff_Service.createStaff(staff);

			System.out.println(staff.getName());
			if (status > 0) {
				staff = staff_Service.laststaff();
				if (model_Staff != null)
					model_Staff.insertRow(staff);

				alert("Successfully Saved!");

			} else {
				alert("Failed Save!");
			}
//			staff = null;
//			dataToView(staff);
		}
		staff = null;
		dataToView(staff);

	}

	private void showList() {
		List<Staff> staffList = new ArrayList<Staff>();
		staffList = staff_Service.getAllstaff();
		model_Staff = new TableModel_Staff(staffList);
		table.setModel(model_Staff);
		sorter = new TableRowSorter<TableModel_Staff>(model_Staff);
	}

	private void edit() {
		auth = new Authenticate();
		int status = auth_Service.checkStaffid(temp_id, auth);

		System.out.println(status);
		if (status > 0) {
			btnCreate.setVisible(false);
			btnEdit.setVisible(true);
		} else {
			btnEdit.setVisible(false);
			btnCreate.setVisible(true);

		}
		Staff staff = new Staff();
		staff = staff_Service.getstaffById(temp_id);
		collapseInputForm(false);
		dataToView(staff);
	}

	private void update() {
		setModel();
		int status = staff_Service.updateStaff(temp_id, staff);
		if (status > 0) {
			alert("Successfully Updated!");
			int modelRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
			model_Staff.setValueAt(staff, modelRowIndex);
		} else {
			alert("Failed update!");
		}
		staff = null;
		dataToView(staff);
	}

	private void delete() {
		int modelRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
		System.out.println("delete " + modelRowIndex);
		if (modelRowIndex != -1) {
			int authdelete = auth_Service.deleteLogin(temp_id);
			int status = staff_Service.deleteStaff(temp_id);
			if (status > 0 && authdelete > 0) {
				model_Staff.removeRow(modelRowIndex);
				alert("Successfully Deleted!");

				staff = null;
				dataToView(staff);
			} else
				alert("Delete Failed!");
		} else {
			alert("Select a row to Delete!!");
		}
	}

	@SuppressWarnings("unused")
	private void dataToView(Staff staff) {
		txtName.setText(staff == null ? "" : staff.getName());
		txtPhone.setText(staff == null ? "" : staff.getPhone());
		txtNRC.setText(staff == null ? "" : staff.getNrc());
		txtareaAddress.setText(staff == null ? "" : staff.getAddress());
		comboDepartment.setSelectedIndex(staff == null ? 0 : staff.getDepartment().getDepartment_Id());
		chckActive.setSelected(staff != null && staff.getActive() ? true : false);

		if (staff == null) {
			radioGroup.clearSelection();
			chckbxupload.setSelected(false);
			chckbxManage.setSelected(false);
		}

		if (staff != null) {
			switch (staff.getRole().getRole_Id()) {
			case 1: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(false);
				return;
			}
			case 2: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(true);
				return;
			}

			case 4: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);
				return;

			}
			case 5: {
				rdbtnDelivery.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);
				return;

			}
			default: {
				radioGroup.clearSelection();
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);
				return;
			}

			}
		}

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(office_view.getFrame(), msg);
	}

	@Override
	public void mousePressed(MouseEvent e) {

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
		if (e.getSource().equals(table)) {
			if (e.getClickCount() == 2)
				edit();

		}
		if (e.getSource().equals(office_view.getPanel_btnOrder())) {
			frame.remove(inputPanel);
			frame.remove(listPanel);
			frame.remove(office_view.getPanel_navigation());
			order_controller = new OrderManage_controller(frame);
		}
		if (e.getSource().equals(office_view.getPanel_btnDelivery())) {
			frame.remove(inputPanel);
			frame.remove(listPanel);
			frame.remove(office_view.getPanel_navigation());
			DeliveryManage_Controller deliveryManage_Controller = new DeliveryManage_Controller(frame);
		}

		if (e.getSource().equals(office_view.getPanel_btnSetPrice())) {
			frame.remove(inputPanel);
			frame.remove(listPanel);
			frame.remove(office_view.getPanel_navigation());
			SetPrice_controller setPrice_controller = new SetPrice_controller(frame);
		}

		if (e.getSource().equals(office_view.getPanel_btn_approve())) {
			frame.remove(inputPanel);
			frame.remove(listPanel);
			frame.remove(office_view.getPanel_navigation());
			Payment_controller payment_controlle = new Payment_controller(frame);
		}

		if (e.getSource().equals(office_view.getPanel_btnLogout())) {
			frame.dispose();
			Login_controller nextController = new Login_controller();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnMinimize)) {
			collapseInputForm(true);
		}

		if (e.getSource().equals(btnMaximize)) {
			collapseInputForm(false);
		}

		if (e.getSource().equals(btnSave)) {
			save();
		}
		if (e.getSource().equals(btnClear)) {
			staff = null;
			btnCreate.setVisible(false);
			btnEdit.setVisible(false);

			dataToView(staff);
		}
		if (e.getSource().equals(btnDelete)) {
			delete();
		}
		if (e.getSource().equals(btnUpdate)) {
			update();
		}
		if (e.getSource().equals(btnCreate)) {

			new Create_controller(temp_id);

		}
		if (e.getSource().equals(btnEdit)) {

			new UpdateAccount_controller(temp_id);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!table.getSelectionModel().isSelectionEmpty()) {
			temp_id = model_Staff.getStaff_Id(table.convertRowIndexToModel(table.getSelectedRow()));
		} else {
			System.out.println("Empty");
		}

	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if (e.getSource().equals(txtsearch)) {
			try {
				java.util.List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(1);
				filters.add(RowFilter.regexFilter("(?i)" + txtsearch.getText(), 1));
				RowFilter<Object, Object> serviceFilter = RowFilter.andFilter(filters);
				sorter.setRowFilter(serviceFilter);
				table.setRowSorter(sorter);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}

		}
	}

}
