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
import javax.swing.JOptionPane;
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

import Model.Department;
import Model.Staff;
import Model.Role;
import Service.Department_service;
import Service.Staff_Service;
import TableModel.TableModel_Staff;
import View.Office_view;
import View.Staff_Panel;

public class CreateAccount_controller implements ActionListener, MouseListener, ListSelectionListener, CaretListener {
	Office_view office_view;
	Staff_Panel cePanel;
	Staff staff;
	TableModel_Staff model_Staff;
	JTable table;

	TableRowSorter<TableModel_Staff> sorter;

	JTextField txtName, txtNRC, txtPhone, txtDepartment, txtsearch;
	JTextArea txtareaAddress;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	ButtonGroup radioGroup;
	JCheckBox chckbxupload, chckbxManage, chckActive;
	JComboBox<String> comboDepartment;

	JButton btnSave, btnUpdate, btnDelete, btnClear, btnMinimize, btnMaximize, btnSearch;
	Staff_Service staff_Service;
	Department_service department_Service;
	int temp_id;

	public CreateAccount_controller() {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() {
		btnSave = cePanel.getBtnSave();
		btnClear = cePanel.getBtnClear();
		btnUpdate = cePanel.getBtnUpdate();
		btnDelete = cePanel.getBtnDelete();
		btnSearch = cePanel.getBtnSearch();
		btnMaximize = cePanel.getBtnMaximize();
		btnMinimize = cePanel.getBtnMinimize();

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
		office_view.getPanel_btnOrder().addMouseListener(this);
		office_view.getPanel_btnDelivery().addMouseListener(this);

		cePanel.getBtnMinimize().addActionListener(this);
		cePanel.getBtnMaximize().addActionListener(this);
		cePanel.getBtnSave().addActionListener(this);
		cePanel.getBtnClear().addActionListener(this);
		cePanel.getBtnDelete().addActionListener(this);
		cePanel.getBtnUpdate().addActionListener(this);

		table.addMouseListener(this);
		table.getSelectionModel().addListSelectionListener(this);

		txtsearch.addCaretListener(this);

	}

	private void initForm() {
		office_view = new View.Office_view();
		cePanel = new Staff_Panel(office_view.getFrame());
		cePanel.getBtnMaximize().setVisible(false);
		office_view.getPanel_btnStaff().setBackground(new Color(218, 165, 32));

	}

	private void loadComboData() {
		List<Department> departmentList = new ArrayList<>();
		comboDepartment.addItem("-Select-");
		departmentList = this.department_Service.getAllDepartment();
		departmentList.forEach(d -> this.comboDepartment.addItem(d.getDepartmentName()));
	}

	private void setModel() {

		long millis = System.currentTimeMillis();
		int roleId = 0;
		String roleName = "";
		if (chckbxupload.isSelected()) {
			roleId = 1;
			roleName = "Normal Staff";
		}
		if (chckbxupload.isSelected() && chckbxManage.isSelected()) {
			roleId = 2;
			roleName = "Office Staff";
		}
		if (radioGroup.getSelection().getActionCommand().equals("Office") && !chckbxupload.isSelected()
				&& !chckbxManage.isSelected()) {
			roleId = 4;
			roleName = "Staff";
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

	}

	private void collapseInputForm(boolean collapse) {

		cePanel.getBtnMinimize().setVisible(!collapse);
		cePanel.getBtnMaximize().setVisible(collapse);

		if (collapse) {
			cePanel.getPanel_create().setBounds(200, 0, 1144, 50);
			cePanel.getPanel_list().setBounds(200, 50, 1144, 690);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 630);
		} else {
			cePanel.getPanel_create().setBounds(200, 0, 1144, 310);
			cePanel.getPanel_list().setBounds(200, 310, 1144, 430);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 370);

		}
	}

	private void save() {
		setModel();
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
		Staff staff = new Staff();
		staff = staff_Service.getstaffById(temp_id);
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
			int status = staff_Service.deleteStaff(temp_id);
			if (status > 0) {
				model_Staff.removeRow(modelRowIndex);
				alert("Successfully Deleted!");
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
				System.out.println("deliver man");
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
		if (e.getSource().equals(table)) {
			if (e.getClickCount() == 2)
				edit();
		}
		if (e.getSource().equals(office_view.getPanel_btnOrder())) {

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
			dataToView(staff);
		}
		if (e.getSource().equals(btnDelete)) {
			delete();
		}
		if (e.getSource().equals(btnUpdate)) {
			update();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!table.getSelectionModel().isSelectionEmpty()) {
			temp_id = model_Staff.getStaff_Id(table.getSelectedRow());

			// temp_id = Integer.parseInt(table.getValueAt(table.getSelectedRow(),
			// 0).toString());
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
