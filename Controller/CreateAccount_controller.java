package Controller;

import java.awt.Color;
import java.awt.Panel;
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import javax.swing.JOptionPane;
=======
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
>>>>>>> Stashed changes
=======
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
>>>>>>> Stashed changes
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Department;
import Model.Staff;
import Service.Department_service;
import Service.Staff_Service;
import TableModel.TableModel_Staff;
import View.Office_view;
import View.Staff_Panel;

public class CreateAccount_controller implements ActionListener, MouseListener, ListSelectionListener {
	Office_view office_view;
	Staff_Panel cePanel;
	Staff staff;
	TableModel_Staff model_Staff;
=======
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import Model.Staff;
import Model.department;
import Service.Staff_Service;
import Service.Department_Service;
import TableModel.tableModel_Staff;
import View.Office_view;
import View.Staff_Panel;

=======
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import Model.Staff;
import Model.department;
import Service.Staff_Service;
import Service.Department_Service;
import TableModel.tableModel_Staff;
import View.Office_view;
import View.Staff_Panel;

>>>>>>> Stashed changes
public class CreateAccount_controller implements ActionListener, MouseListener {
	Office_view office_view;
	Staff_Panel cePanel;
	Staff staff;
	tableModel_Staff model_Staff;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	JTable table;
	JTextField txtName, txtNRC, txtPhone, txtDepartment, txtsearch;
	JTextArea txtareaAddress;
	JRadioButton rdbtnOffice, rdbtnDelivery;
	ButtonGroup radioGroup;
	JCheckBox chckbxupload, chckbxManage, chckActive;
	JComboBox<String> comboDepartment;

	JButton btnSave, btnUpdate, btnDelete, btnClear, btnMinimize, btnMaximize, btnSearch;
	Staff_Service staff_Service;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	Department_service department_Service;
	int temp_id;
=======
	Department_Service department_Service;
>>>>>>> Stashed changes
=======
	Department_Service department_Service;
>>>>>>> Stashed changes

	public CreateAccount_controller() {
		dependencyInjection();
		initForm();
		initComponents();
		initController();

		loadComboData();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		showList();
=======
		// System.out.println(cePanel.getComboDepartment().getSelectedItem());
>>>>>>> Stashed changes
=======
		// System.out.println(cePanel.getComboDepartment().getSelectedItem());
>>>>>>> Stashed changes
	}

	private void dependencyInjection() {
		try {
			this.staff_Service = new Staff_Service();
<<<<<<< Updated upstream
<<<<<<< Updated upstream
			this.department_Service = new Department_service();
=======
			this.department_Service = new Department_Service();
>>>>>>> Stashed changes
=======
			this.department_Service = new Department_Service();
>>>>>>> Stashed changes
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	}

	private void initForm() {
		office_view = new View.Office_view();
		// office_view.getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
		cePanel = new Staff_Panel(office_view.getFrame());
		// cePanel.setExtendedState(cePanel.MAXIMIZED_BOTH);
		cePanel.getBtnMaximize().setVisible(false);
		office_view.getPanel_btnStaff().setBackground(new Color(218, 165, 32));

	}

	private void loadComboData() {
		List<department> departmentList = new ArrayList<>();
		comboDepartment.addItem("-Select-");
		departmentList = this.department_Service.getAllDepartment();
		departmentList.forEach(s -> this.comboDepartment.addItem(s.getDepartmentName()));
//		comboDepartment.addItem("KyalGaung");
//		comboDepartment.addItem("Musal");
//		comboDepartment.addItem("Mandalay");

	}

	private void setModel() {
		long millis = System.currentTimeMillis();
		int role = 0;
		if (chckbxupload.isSelected())
			role = 1;
		if (chckbxupload.isSelected() && chckbxManage.isSelected())
			role = 2;
		if (radioGroup.getSelection().getActionCommand().equals("Office") && !chckbxupload.isSelected()
				&& !chckbxManage.isSelected())
			role = 4;
		if (radioGroup.getSelection().getActionCommand().equals("Delivery"))
			role = 5;
		staff = new Staff();
		staff.setName(txtName.getText());
		staff.setPhone(txtPhone.getText());
		staff.setAddress(txtareaAddress.getText());
		staff.setNrc(txtNRC.getText());
		staff.setRole(role);
		staff.setDepartmentId(comboDepartment.getSelectedIndex());
		staff.setActive(true);
		staff.setDate(String.valueOf(new java.sql.Date(millis)));
		// staff.setActive(chckActive.isSelected() ? true : false);
	}

	private void initComponents() {
		table = cePanel.getTable();
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

		comboDepartment = cePanel.getComboDepartment();

		radioGroup = cePanel.getRadioGroup();
		chckbxupload = cePanel.getChckbxupload();
		chckbxManage = cePanel.getChckbxManage();
		chckActive = cePanel.getChckbxActive();

		rdbtnDelivery = cePanel.getRdbtnDelivery();
		rdbtnOffice = cePanel.getRdbtnOffice();

		// chckActive = cePanel.getCheckBox();

<<<<<<< Updated upstream
	}

	private void loadComboData() {
		List<Department> departmentList = new ArrayList<>();
		comboDepartment.addItem("-Select-");
		departmentList = this.department_Service.getAllDepartment();
		departmentList.forEach(s -> this.comboDepartment.addItem(s.getDepartmentName()));
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
		staff.setName(txtName.getText());
		staff.setPhone(txtPhone.getText());
		staff.setAddress(txtareaAddress.getText());
		staff.setNrc(txtNRC.getText());
		staff.setRoleId(roleId);
		staff.setRoleName(roleName);
		staff.setDepartmentId(comboDepartment.getSelectedIndex());
		staff.setDepartmentName(comboDepartment.getSelectedItem().toString());
		staff.setActive(true);
		staff.setDate(new java.sql.Date(millis));
		staff.setActive(chckActive.isSelected() ? true : false);
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

		comboDepartment = cePanel.getComboDepartment();

		radioGroup = cePanel.getRadioGroup();
		rdbtnDelivery = cePanel.getRdbtnDelivery();
		rdbtnOffice = cePanel.getRdbtnOffice();
		
		chckbxupload = cePanel.getChckbxupload();
		chckbxManage = cePanel.getChckbxManage();
		chckActive = cePanel.getChckbxActive();
		
		table = cePanel.getTable();
=======
>>>>>>> Stashed changes
	}

	private void collapseInputForm(boolean collapse) {
		if (collapse) {
			System.out.println("collapse");
			cePanel.getPanel_create().setBounds(200, 0, 1144, 50);
			cePanel.getPanel_list().setBounds(200, 50, 1144, 690);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 630);
		} else {
			System.out.println("expand");
<<<<<<< Updated upstream
			cePanel.getPanel_create().setBounds(200, 0, 1144, 310);
			cePanel.getPanel_list().setBounds(200, 310, 1144, 430);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 370);
		}
	}

	
=======
			cePanel.getPanel_create().setBounds(200, 0, 1144, 370);
			cePanel.getPanel_list().setBounds(200, 370, 1144, 370);
			cePanel.getScrollPane().setBounds(10, 46, 1110, 310);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(office_view.getPanel_btnStaff())) {
			if (e.getClickCount() == 2) {
				System.out.println("Test Double Click!!");

				////
				// Department_enum.KyalGaung.toString()
				System.out.println(comboDepartment.getSelectedItem());
				System.out.println(comboDepartment.getSelectedIndex());
				////
			} else {
				System.out.println("Single Click!!");
			}
		}
		if (e.getSource().equals(office_view.getPanel_btnOrder())) {
			if (e.getClickCount() == 2) {
				System.out.println("Test Double Click!!");
			}
		}

		if (e.getSource().equals(btnSave)) {
			save();
		}

	}
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		}
		staff = null;
		dataToView(staff);
	}

	private void showList() {
		List<Staff> staffList = new ArrayList<Staff>();
		staffList = staff_Service.getAllstaff();
		model_Staff = new TableModel_Staff(staffList);
		table.setModel(model_Staff);
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
=======

>>>>>>> Stashed changes
=======

>>>>>>> Stashed changes
		}
		staff = null;
		dataToView(staff);
	}

<<<<<<< Updated upstream
<<<<<<< Updated upstream
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
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	private void dataToView(Staff staff) {
		txtName.setText(staff == null ? "" : staff.getName());
		txtPhone.setText(staff == null ? "" : staff.getPhone());
		txtNRC.setText(staff == null ? "" : staff.getNrc());
		txtareaAddress.setText(staff == null ? "" : staff.getAddress());
		comboDepartment.setSelectedIndex(staff == null ? 0 : staff.getDepartmentId());
		chckActive.setSelected(staff != null && staff.getActive() ? true : false);

<<<<<<< Updated upstream
<<<<<<< Updated upstream
		if (staff == null) {
			radioGroup.clearSelection();
			chckbxupload.setSelected(false);
			chckbxManage.setSelected(false);
		}

		if (staff != null) {
			switch (staff.getRoleId()) {
=======
		if (staff != null)
			switch (staff.getRole()) {
>>>>>>> Stashed changes
=======
		if (staff != null)
			switch (staff.getRole()) {
>>>>>>> Stashed changes
			case 1: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(false);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
				return;
			}
			case 2: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(true);
				return;
			}
=======
			}
			case 2: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(true);
			}
>>>>>>> Stashed changes
			case 3: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(false);
<<<<<<< Updated upstream
				return;
=======
>>>>>>> Stashed changes
			}
			case 4: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);
<<<<<<< Updated upstream
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
=======
=======
			}
			case 2: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(true);
			}
			case 3: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(true);
				chckbxManage.setSelected(false);
			}
			case 4: {
				rdbtnOffice.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);

			}
			case 5: {
				rdbtnDelivery.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);

			}
			}
		else {
			radioGroup.clearSelection();
			chckbxupload.setSelected(false);
			chckbxManage.setSelected(false);
		}
>>>>>>> Stashed changes

			}
			case 5: {
				rdbtnDelivery.setSelected(true);
				chckbxupload.setSelected(false);
				chckbxManage.setSelected(false);

			}
			}
		else {
			radioGroup.clearSelection();
			chckbxupload.setSelected(false);
			chckbxManage.setSelected(false);
>>>>>>> Stashed changes
		}

	}

	private void alert(String msg) {
		JOptionPane.showMessageDialog(office_view.getFrame(), msg);
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
			System.out.println("collapse");
			cePanel.getBtnMinimize().setVisible(false);
			cePanel.getBtnMaximize().setVisible(true);
			collapseInputForm(true);
		}

		if (e.getSource().equals(btnMaximize)) {
			System.out.println("expand");
			collapseInputForm(false);
			cePanel.getBtnMinimize().setVisible(true);
			cePanel.getBtnMaximize().setVisible(false);
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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!table.getSelectionModel().isSelectionEmpty()) {
			temp_id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		} else {
			System.out.println("Empty");
		}
=======
=======
>>>>>>> Stashed changes
	private void update() {
		// TODO Auto-generated method stub

	}

	private void delete() {
		// TODO Auto-generated method stub
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

	}

}
